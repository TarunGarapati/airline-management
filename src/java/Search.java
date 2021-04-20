/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 *
 * @author sree
 */
public class Search extends HttpServlet {
    public ArrayList<Flight> search_flights(String from,String to,String date,HttpServletRequest request) throws ParseException
    {
    		 ArrayList<Flight> flights=new ArrayList<>();
		try {
		HttpSession ses=request.getSession();
                Date d =  new SimpleDateFormat("yyyy-MM-dd").parse(date);
		SimpleDateFormat s=new SimpleDateFormat("E");
		String x=s.format(d);
		x=x.toLowerCase();
		ses.setAttribute("day", x);
                String q="";
                         switch (x) {
                             case "mon":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.mon_seats_eco,flight.mon_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and mon=1";
                                 break;
                             case "tue":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.tue_seats_eco,flight.tue_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and tue=1";
                                 break;
                             case "wed":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.wed_seats_eco,flight.wed_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and wed=1";
                                 break;
                             case "thu":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.thu_seats_eco,flight.thu_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and thu=1";
                                 break;
                             case "fri":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.fri_seats_eco,flight.fri_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and fri=1";
                                 break;
                             case "sat":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.sat_seats_eco,flight.sat_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and sat=1";
                                 break;
                             case "sun":
                                 q="select flight.id,company.company,route.distance,flight.start_time,flight.dest_time,flight.sun_seats_eco,flight.sun_seats_bus,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id inner join route on route.id=flight.route_id where route.from_pl=? and route.to_pl=? and sun=1";
                                 break;
                         }
		
                String sql="select code,value from airline.promocode";
		
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
    		PreparedStatement st=con.prepareStatement(q);
    		Statement st1=(Statement) con.createStatement();
    		ResultSet rs1=st1.executeQuery(sql);
    		st.setString(1, from);
    		st.setString(2, to);
    		ResultSet rs=st.executeQuery();
    		while(rs.next()) {
    			Flight a=new Flight(rs.getInt(1),rs.getString(2),rs.getFloat(3),from,to,rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getFloat(9));
    			flights.add(a);
    		}
                String promo="";
    		while(rs1.next()) {
    			promo=promo+"use code "+rs1.getString(1)+" and get flat Rs."+rs1.getFloat(2)+" off, ";
    		}
    		ses.setAttribute("promo", promo);
		}
                catch(ClassNotFoundException | SQLException e)
                {
                System.out.println(e);
                }
		return flights;
    	    
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
            //processRequest(request, response);
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            HttpSession ses=request.getSession();
            String from=request.getParameter("from");
            String to=request.getParameter("to");
            if(from.equals(to)) {
                pw.print("<html><script>alert('From and To places cannot be same')</script>");
                pw.print("<script>location.href='J3.jsp'</script></html>");
            }
            String tod_date=request.getParameter("date1");
            String jr_date=request.getParameter("date2");                
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = sdf.parse(tod_date);
                Date d2 = sdf.parse(jr_date);
                if(d1.compareTo(d2)> 0) {
                    pw.print("<html><script>alert('Date out of scope')</script>");
                    pw.print("<script>location.href='J3.jsp'</script></html>");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
            String clas=request.getParameter("class");
            ArrayList<Flight> a = search_flights(from,to,jr_date,request);
            
            if(a.isEmpty()) {
                pw.print("<html><script>alert('No flights available on this date')</script>");
                pw.print("<script>location.href='J3.jsp'</script></html>");
            }
            else {
                pw.print("<html><head><style>#you\r\n" +
                        "{\r\n" +
                        "padding:8px 16px;\r\n" +
                        "border-radius:30px;\r\n" +
                        "outline:none;\r\n" +
                        "background-colour:olive;\r\n" +
                        "border-color:olive;\r\n" +
                        "float:right;\r\n" +
                        "cursor:pointer;\r\n" +
                        "}\r\n" +
                        "</style></head></style>");
                pw.print("<form action='Customer' method='post'><input id='you' type='submit' value='Logout' name='id'></form>");
                Iterator itr=a.iterator();
                int i=0;
                while(itr.hasNext()) {
                    Flight f=(Flight)itr.next();
                    if(i==0) {
                        pw.print("<html>"
                                +"<head>"
                                + "<style>"
                                + "table {\r\n" +
                                "  font-family: arial, sans-serif;\r\n" +
                                "  border-collapse: collapse;\r\n" +
                                "  width: 100%;\r\n" +
                                "}\r\n" +
                                "\r\n" +
                                "td, th {\r\n" +
                                "  border: 1px solid #dddddd;\r\n" +
                                "  text-align: left;\r\n" +
                                "  padding: 8px;\r\n" +
                                "}\r\n" +
                                "\r\n" +
                                "tr:nth-child(even) {\r\n" +
                                "  background-color: #dddddd;\r\n" +
                                "}"
                                + "</style>"
                                +"</head>"
                                + "</html>");
                        pw.print("<table>"
                                +"<tr>"
                                +"<th>Flight Id</th>"
                                +"<th>From</th>"
                                +"<th>To</th>"
                                + "<th>Company</th>"
                                + "<th>Distance</th>"
                                + "<th>Date of Journey(YYYY/MM/DD)</th>"
                                + "<th>Arrival Time</th>"
                                + "<th>Destination Time</th>"
                                + "<th>Economy Seat Price</th>"
                                +"<th>Business Seat Price</th>"
                                + "<th>Availability(Economy)</th>"
                                + "<th>Availability(Business)</th>"
                                + "</tr>"
                                +"</table>"
                        );
                        i=1;
                    }
                    int eco=f.seats_eco;
                    int bus=f.seats_bus;
                    pw.print("<html>"
                            + "<head>"
                            + "<style>"
                            + "table {\r\n" +
                            "  font-family: arial, sans-serif;\r\n" +
                            "  border-collapse: collapse;\r\n" +
                            "  width: 100%;\r\n" +
                            "}\r\n" +
                            "\r\n" +
                            "td, th {\r\n" +
                            "  border: 1px solid #dddddd;\r\n" +
                            "  text-align: left;\r\n" +
                            "  padding: 8px;\r\n" +
                            "}\r\n" +
                            "\r\n" +
                            "tr:nth-child(even) {\r\n" +
                            "  background-color: #dddddd;\r\n" + 
                            "}"
                            + "#one{"
                            + "color:green;}"
                            + "#two{"
                            + "color:red;}"
                            + "</style>"
                            +"</head>"
                            + "</html>");
                    pw.print("<table>"
                            +"<tr>"
                            +"<td>"+f.id+"</td>"
                            + "<td>"+from+"</td>"
                            + "<td>"+to+"</td>"
                            +"<td>"+ f.company+"</td>"
                            + "<td>"+f.distance+"km</td>"
                            + "<td>"+jr_date+"</td>"
                            + "<td>"+f.start_time+"</td>"
                            + "<td>"+f.end_time+"</td>"
                            +"<td>"+f.price_eco+"</td>"
                            + "<td>"+f.price_bus+"</td>"
                    );
                    if(eco>0) {
                        pw.print("<td id='one'><b><big>"
                                + eco+" seats available</big></b></td>"
                        );
                    }
                    else {
                        pw.print("<td id='two'><b><big>Seats Unavailable</big></b></td>");
                    }
                    if(bus>0) {
                        pw.println("<td id='one'><b><big>"
                                + bus+" seats available</big></b></td></tr>"
                        );
                    }
                    else {
                        pw.println("<td id='two'><b><big>Seats Unavailable</big></b></td></tr>");
                    }
                    pw.print("</tr>"
                            +"</table>"
                    );
                }
                i=0;
                ses.setAttribute("i", i);
                ses.setAttribute("from", from);
                ses.setAttribute("to", to);
                ses.setAttribute("date",jr_date);
                ses.setAttribute("class",clas);
                    
                if(clas.equals("economy")) {
                    pw.println("<center><tr><form action='add.jsp' method='post'>"
                            + "<b><big style='margin-left:30px'>Flight Id:</big></b>"
                            + "<input type='number' name='id' style='padding:5px 10px;margin-right:15px;' placeholder='Enter Flight Id'><br><br>");
                    
                    pw.print("<b><big style='margin-left:30px' id='1'>Enter Economy Class Seats:</big></b>"
                            + "<input type='number' name='num' style='padding:5px 10px;margin-right:15px;' placeholder='Enter number of seats'>");
                    pw.print("<b><big style='margin-left:20px'>Have a promo code:</big></b><input type='text' name='promo' style='padding:5px 10px;margin-right:15px;' placeholder='Promo Code'>"
                            + "<input type='submit' style='padding:5px 10px' value='Book'></form><br><br></tr></center></table>");
                }
                else{
                    pw.println("<center><tr><form action='add.jsp' method='post'>"
                            + "<b><big style='margin-left:30px'>Flight Id:</big></b>"
                            + "<input type='number' name='id' style='padding:5px 10px;margin-right:15px;' placeholder='Enter Flight Id'><br><br>");
                    
                    pw.print("<b><big id='2'>Enter Business Class Seats:</big></b>"
                            + "<input type='number' name='num' style='padding:5px 10px;margin-right:15px;' placeholder='Enter number of seats'>");
                    pw.print("<b><big style='margin-left:20px'>Have a promo code:</big></b><input type='text' name='promo' style='padding:5px 10px;margin-right:15px;' placeholder='Promo Code'>"
                            + "<input type='submit' style='padding:5px 10px' value='Book'></form><br><br></tr></center></table>");
                }
                String promo=ses.getAttribute("promo").toString();
                pw.print("<br><br><marquee behavior='scroll' direction='left'><b style='color:red'><h3>Promo Codes:"
                        +promo
                        + "</h3></b></marquee>");
            }
        }
		catch(ParseException e) {
                    System.out.println(e);
		}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
