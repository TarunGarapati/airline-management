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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sree
 */
public class Book extends HttpServlet {
    public void book_ticket(int id,String from,String to,String clas,int seats,String promo,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
     	PrintWriter pw=response.getWriter();
        HttpSession ses=request.getSession();
	String q1="select company.company,flight.start_time,flight.dest_time,flight.price_eco,flight.price_bus from flight inner join company on company.id=flight.company_id where flight.id=?";
	String q2="select promocode.value from promocode where code=?";
	if(clas.equals("economy")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	    		PreparedStatement ps1=con.prepareStatement(q1);
	    		PreparedStatement ps2=con.prepareStatement(q2);
	    		ps1.setInt(1, id);
	    		ps2.setString(1, promo);
	    		ResultSet rs1=ps1.executeQuery();
	    		ResultSet rs2=ps2.executeQuery();
	    		if(rs1.next() && rs2.next()) {
	    		float total= ((float)seats * rs1.getFloat(4));
	    		float tax=(float) ((0.10)*total);
	    		float convienence=250;
	    		float tot=total+tax+convienence-rs2.getFloat(1);
	    		ses.setAttribute("company", rs1.getString(1));
	    		ses.setAttribute("start_time", rs1.getString(2));
	    		ses.setAttribute("end_time", rs1.getString(3));
	    		ses.setAttribute("amount_paid", tot);
	    		pw.print("<html>"
   					+ "<head>"
   					+ "<style>"
   					+ "table {\r\n" + 
   					"  font-family: arial, sans-serif;\r\n" + 
   					"  border-collapse: collapse;\r\n" + 
   					"  width: 80%;\r\n" + 
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
   			
	    		
	    		pw.print("<html>");
			pw.print("<center><b><big><h2 style='margin-top:71px;position:absolute;margin-left:574px'>Final Confirmation</h2></big></b></center>");
			pw.print("<table align='center'><tr>");
			pw.print("<tr><td>Economy Class Price(for one seat):</td>");
			pw.print("<td>"+rs1.getFloat(4)+"</td></br></tr>");
			pw.print("<tr><td>Total Amount:(  "+(float)seats+" x "+rs1.getFloat(4)+")"+ "</td>");
			pw.print("<td>"+total+"</td></br></tr>");
			pw.print("<tr><td>Total Tax:</td>");
			pw.print("<td>+"+tax+"</td></br></tr>");
			pw.print("<tr><td>Convienence:</td>");
			pw.print("<td>+"+convienence+"</td></br></tr>");
			pw.print("<tr><td>Promo Code Discount:</td>");
			pw.print("<td>-"+rs2.getFloat(1)+"</td></br></tr>");			
			pw.print("<tr><td>Final Amount To be Paid:</td>");
			pw.print("<td>"+tot+"</td></br></tr>");
			pw.print("<tr>");
			pw.print("<form action='Ticket' method='post'>");
			pw.print("<input type='submit' style='padding:5px 10px;position:absolute;margin-top:250px;margin-left:615px' value='Generate Ticket'></tr></form>");
			pw.print("</html>");}}
	    	catch(  ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
	    	}
        else if(clas.equals("business")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	    		PreparedStatement ps1=con.prepareStatement(q1);
	    		PreparedStatement ps2=con.prepareStatement(q2);
	    		ps1.setInt(1, id);
	    		ps2.setString(1, promo);
	    		ResultSet rs1=ps1.executeQuery();
	    		ResultSet rs2=ps2.executeQuery();
	    		if(rs1.next() && rs2.next()) {
	    		float total= ((float)seats * rs1.getFloat(5));
	    		float tax=(float) ((0.10)*total);
	    		float convienence=250;
	    		float tot=total+tax+convienence-rs2.getFloat(1);
	    		ses.setAttribute("company", rs1.getString(1));
	    		ses.setAttribute("start_time", rs1.getString(2));
	    		ses.setAttribute("end_time", rs1.getString(3));
	    		ses.setAttribute("amount_paid", tot);
	    		pw.print("<html>"
   					+ "<head>"
   					+ "<style>"
   					+ "table {\r\n" + 
   					"  font-family: arial, sans-serif;\r\n" + 
   					"  border-collapse: collapse;\r\n" + 
   					"  width: 80%;\r\n" + 
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
   			
	    		
	    		pw.print("<html>");
			pw.print("<center><b><big><h2 style='margin-top:71px;position:absolute;margin-left:574px'>Final Confirmation</h2></big></b></center>");
			pw.print("<table align='center'><tr>");
			pw.print("<tr><td>Business Class Price(for one seat):</td>");
			pw.print("<td>"+rs1.getFloat(5)+"</td></br></tr>");
			pw.print("<tr><td>Total Amount:(  "+(float)seats+" x "+rs1.getFloat(5)+")"+ "</td>");
			pw.print("<td>"+total+"</td></br></tr>");
			pw.print("<tr><td>Total Tax:</td>");
			pw.print("<td>+"+tax+"</td></br></tr>");
			pw.print("<tr><td>Convienence:</td>");
			pw.print("<td>+"+convienence+"</td></br></tr>");
			pw.print("<tr><td>Promo Code Discount:</td>");
			pw.print("<td>-"+rs2.getFloat(1)+"</td></br></tr>");
			
			pw.print("<tr><td>Final Amount To be Paid:</td>");
			pw.print("<td>"+tot+"</td></br></tr>");
			pw.print("<tr>");
			pw.print("<form action='Ticket' method='post'>");
			pw.print("<input type='submit' style='padding:5px 10px;position:absolute;margin-top:250px;margin-left:615px' value='Generate Ticket'></tr></form>");
			pw.print("</html>");}}
	    	catch(  ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
	    	}
	    	
	    	
	    	
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
            out.println("<title>Servlet Book</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Book at " + request.getContextPath() + "</h1>");
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

		String from= ses.getAttribute("from").toString();
		String to= ses.getAttribute("to").toString();
		String clas=ses.getAttribute("class").toString();
		String promo=ses.getAttribute("promo").toString();
		int id=Integer.parseInt(ses.getAttribute("id").toString());
		int seats=Integer.parseInt(ses.getAttribute("seats").toString());
		book_ticket(id,from,to,clas,seats,promo,request,response);				
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
