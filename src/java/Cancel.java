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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sree
 */
public class Cancel extends HttpServlet {
    public boolean cancel_ticket(int tid)
    {
        try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	    PreparedStatement ps1=con.prepareStatement("delete from airline.ticket where ticket.random=?");
	    PreparedStatement ps2=con.prepareStatement("select ticket.flight_id,passenger.class,ticket.seats,ticket.date from ticket inner join passenger on ticket.random=passenger.random where ticket.random=? and passenger.prime=?");
	    ps2.setInt(1,tid);
            ps2.setInt(2,1);
	    ResultSet rs=ps2.executeQuery();
	    if(rs.next()) {
                int a=rs.getInt(1);
	    	String b=rs.getString(2);
                int c=rs.getInt(3);
	    	String d=rs.getString(4);
                String q="";
                Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(d);
		SimpleDateFormat s=new SimpleDateFormat("E");
		String x=s.format(date);
		x=x.toLowerCase();
		
	    	if(b.equals("economy")) {
                    switch (x) {
                case "mon":
                    q="update airline.flight set mon_seats_eco=mon_seats_eco+? where flight.id=?";
                    break;
                case "tue":
                    q="update airline.flight set tue_seats_eco=tue_seats_eco+? where flight.id=?";
                    break;
                case "wed":
                    q="update airline.flight set wed_seats_eco=wed_seats_eco+? where flight.id=?";
                    break;
                case "thu":
                    q="update airline.flight set thu_seats_eco=thu_seats_eco+? where flight.id=?";
                    break;
                case "fri":
                    q="update airline.flight set fri_seats_eco=fri_seats_eco+? where flight.id=?";
                    break;
                case "sat":
                    q="update airline.flight set sat_seats_eco=sat_seats_eco+? where flight.id=?";
                    break;
                case "sun":
                    q="update airline.flight set sun_seats_eco=sun_seats_eco+? where flight.id=?";
                    break;
                }
                    }
	    	else if(b.equals("business")){
                    switch (x) {
                case "mon":
                    q="update airline.flight set mon_seats_bus=mon_seats_bus+? where flight.id=?";
                    break;
                case "tue":
                    q="update airline.flight set tue_seats_bus=tue_seats_bus+? where flight.id=?";
                    break;
                case "wed":
                    q="update airline.flight set wed_seats_bus=wed_seats_bus+? where flight.id=?";
                    break;
                case "thu":
                    q="update airline.flight set thu_seats_bus=thu_seats_bus+? where flight.id=?";
                    break;
                case "fri":
                    q="update airline.flight set fri_seats_bus=fri_seats_bus+? where flight.id=?";
                    break;
                case "sat":
                    q="update airline.flight set sat_seats_bus=sat_seats_bus+? where flight.id=?";
                    break;
                case "sun":
                    q="update airline.flight set sun_seats_bus=sun_seats_bus+? where flight.id=?";
                    break;
                }
                }
	    	PreparedStatement ps3=con.prepareStatement(q);
	    	ps1.setInt(1, tid);
	    	int y=ps1.executeUpdate();
	    		if(y>0) {
	    			ps3.setInt(1, c);
	    			ps3.setInt(2, a);
	    			int z=ps3.executeUpdate();
	    			if(z>0) {
                                    PreparedStatement ps4=con.prepareStatement("delete from airline.passenger where passenger.random=?");
                                    ps4.setInt(1,tid);
                                    int o=ps4.executeUpdate();
	    			return true;}
	    			}}}
	    		catch(ClassNotFoundException | SQLException | ParseException e) {
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
            out.println("<title>Servlet Cancel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cancel at " + request.getContextPath() + "</h1>");
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
        int tid=Integer.parseInt(request.getParameter("tid"));		
	PrintWriter pw=response.getWriter();
        if(cancel_ticket(tid)) {
		pw.print("<script>window.alert('Journey Cancelled Successfully');</script>");
		pw.print("<script>window.location.href='J2.jsp';</script>");
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
