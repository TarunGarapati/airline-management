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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sree
 */
public class Ticket extends HttpServlet {
    public boolean add_to_mybookings(int fid,String from,String to,String clas,int seats,String company,String start_time,String end_time,String uname,String date,int random,float amount,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession ses=request.getSession();
	PrintWriter pw=response.getWriter();
        String x=ses.getAttribute("day").toString();
	String sql1="";
        //pw.println(fid+" "+company+" "+random+" "+uname);
        //pw.println(from+" "+to+" "+start_time+" "+end_time+" "+date);
        
        switch(x)
        {
            case "mon":
            {
                sql1="select flight.mon_seats_eco,flight.mon_seats_bus from airline.flight where flight.id=?";
                break;
            }
            case "tue":
            {
                sql1="select flight.tue_seats_eco,flight.tue_seats_bus from airline.flight where flight.id=?";
                break;
            }
            case "wed":
            {
                sql1="select flight.wed_seats_eco,flight.wed_seats_bus from airline.flight where flight.id=?";
                break;
            }
            case "thu":
            {
                sql1="select flight.thu_seats_eco,flight.thu_seats_bus from airline.flight where flight.id=?";
                break;
            }
            case "fri":
            {
                sql1="select flight.fri_seats_eco,flight.fri_seats_bus from airline.flight where flight.id=?";
                break;
            }
            case "sat":
            {
                sql1="select flight.sat_seats_eco,flight.sat_seats_bus from airline.flight where flight.id=?";
                break;
            }
            case "sun":
            {
                sql1="select flight.sun_seats_eco,flight.sun_seats_bus from airline.flight where flight.id=?";
                break;
            }
        }
	    String sql2="";
	    if(clas.equals("economy")) {
            switch (x) {
                case "mon":
                    sql2="update airline.flight set mon_seats_eco=? where flight.id=?";
                    break;
                case "tue":
                    sql2="update airline.flight set tue_seats_eco=? where flight.id=?";
                    break;
                case "wed":
                    sql2="update airline.flight set wed_seats_eco=? where flight.id=?";
                    break;
                case "thu":
                    sql2="update airline.flight set thu_seats_eco=? where flight.id=?";
                    break;
                case "fri":
                    sql2="update airline.flight set fri_seats_eco=? where flight.id=?";
                    break;
                case "sat":
                    sql2="update airline.flight set sat_seats_eco=? where flight.id=?";
                    break;
                case "sun":
                    sql2="update airline.flight set sun_seats_eco=? where flight.id=?";
                    break;
            }
	    	}
	    else if(clas.equals("business")) {
	    switch (x) {
                case "mon":
                    sql2="update airline.flight set mon_seats_bus=? where flight.id=?";
                    break;
                case "tue":
                    sql2="update airline.flight set tue_seats_bus=? where flight.id=?";
                    break;
                case "wed":
                    sql2="update airline.flight set wed_seats_bus=? where flight.id=?";
                    break;
                case "thu":
                    sql2="update airline.flight set thu_seats_bus=? where flight.id=?";
                    break;
                case "fri":
                    sql2="update airline.flight set fri_seats_bus=? where flight.id=?";
                    break;
                case "sat":
                    sql2="update airline.flight set sat_seats_bus=? where flight.id=?";
                    break;
                case "sun":
                    sql2="update airline.flight set sun_seats_bus=? where flight.id=?";
                    break;
            }	    		
	    }
    	String q1="select company.id from airline.company where company.company=? ";
	String q2="insert into airline.ticket(from_pl,to_pl,start_time,end_time,company_id,price,flight_id,date,seats,uname,random) values(?,?,?,?,?,?,?,?,?,?,?)";
        
            try {
		Class.forName("com.mysql.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	    	PreparedStatement s1=con.prepareStatement(q1);
	    	PreparedStatement s2=con.prepareStatement(q2);
	    	PreparedStatement st1=con.prepareStatement(sql1);
	    	PreparedStatement st2=con.prepareStatement(sql2);
	    		    
	    		s1.setString(1, company);
	    		st1.setInt(1, fid);
	    		ResultSet r1=s1.executeQuery();
	    		ResultSet rs1=st1.executeQuery();
	    		r1.next();
	    		rs1.next();
	    		int id=r1.getInt(1);
	    		int seats_rem=0;
	    		if(clas.equals("economy")) {
	    		seats_rem=rs1.getInt(1);}
	    		else if(clas.equals("business")) {
	    		 seats_rem=rs1.getInt(2);}
	    		seats_rem=seats_rem-seats;
                        pw.print(seats_rem+" "+id);
	    		if(seats_rem<0) {
                            pw.print("<script>window.alert('Ticket Cannot be generated due to unsufficient seats');</script>");
                            RequestDispatcher rd=request.getRequestDispatcher("Search");
                            rd.forward(request, response);		
	    		}
	    		st2.setInt(1, seats_rem);
	    		st2.setInt(2, fid);
	    		s2.setString(1, from);
	    		s2.setString(2, to);
	    		s2.setString(3,start_time);
	    		s2.setString(4, end_time);
	    		s2.setInt(5, id);
	    		s2.setFloat(6, amount);
	    		s2.setInt(7,fid);
	    		s2.setString(8, date);
	    		s2.setInt(9, seats);
	    		s2.setString(10, uname);
	    		s2.setInt(11, random);
	    		int y=st2.executeUpdate();
	    		int z=s2.executeUpdate();
                        pw.print(y+" "+z);
	    		if(y>0 && z>0)
	    		return true;
                        else
                        {
                         y=seats_rem+seats;
                         st2.setInt(1, y);
                         st2.setInt(2, fid);
                         z=st2.executeUpdate(); 
                         return false;   
                        }    
	    	}
	    	catch(ClassNotFoundException | SQLException | IOException | ServletException e){
	    		System.out.println(e);
	    	}


     return false; 
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
            out.println("<title>Servlet Ticket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ticket at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        HttpSession ses=request.getSession();
	if(ses.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");	
	}

	PrintWriter pw=response.getWriter();
	int fid=Integer.parseInt(ses.getAttribute("id").toString());
	String from= ses.getAttribute("from").toString();
	String to=ses.getAttribute("to").toString();
	String clas=ses.getAttribute("class").toString();
        int seats=Integer.parseInt(ses.getAttribute("seats").toString());
	String company=ses.getAttribute("company").toString();
	String start_time=ses.getAttribute("start_time").toString();
	String end_time=ses.getAttribute("end_time").toString();
	String uname=ses.getAttribute("uname").toString();
        String date=ses.getAttribute("date").toString();
	int random=(Integer.parseInt(ses.getAttribute("random").toString()));
	float amount=Float.parseFloat(ses.getAttribute("amount_paid").toString());
		if(add_to_mybookings(fid,from,to,clas,seats,company,start_time,end_time,uname,date,random,amount,request,response)) {
                    pw.print("<script>window.alert('Ticket generated succesfully, Check Your Bookings for ticket');</script>");
                    pw.print("<script>window.location.href='J2.jsp';</script>");}
		else {
                    pw.print("<script>window.alert('Ticket not generated,please book again');</script>");
                    pw.print("<script>window.location.href='J3.jsp';</script>");}

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
