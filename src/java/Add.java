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
public class Add extends HttpServlet {

    public boolean add(String uname,String clas,int random,int prime,HttpServletRequest request)
    {
        String name=request.getParameter("pname");
   	int age=Integer.parseInt(request.getParameter("age"));
   	String gender=request.getParameter("gender");
                
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
            PreparedStatement ps=con.prepareStatement("insert into airline.passenger(name,age,gender,class,prime,uname,random) values(?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, clas);
            ps.setInt(5, prime);
            ps.setString(6,uname);
            ps.setInt(7, random);
            int x=ps.executeUpdate();
            if(x>0) {
                    return true;
                    }
                }
   	catch(ClassNotFoundException | SQLException e)
        {
              System.out.println(e);
        }			
   	
        return false;
    }
    
    public boolean add(String uname,String clas,int random,HttpServletRequest request)
    {
        String name=request.getParameter("pname");
   	int age=Integer.parseInt(request.getParameter("age"));
   	String gender=request.getParameter("gender");
                
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
            PreparedStatement ps=con.prepareStatement("insert into airline.passenger(name,age,gender,class,prime,uname,random) values(?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, clas);
            ps.setInt(5, 0);
            ps.setString(6,uname);
            ps.setInt(7, random);
            int x=ps.executeUpdate();
            if(x>0) {
                    return true;
                    }
                }
   	catch(ClassNotFoundException | SQLException e)
        {
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
            out.println("<title>Servlet Add</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
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
	String x=request.getParameter("add");
	String uname=ses.getAttribute("uname").toString();
	String clas=ses.getAttribute("class").toString();
	int random=Integer.parseInt(ses.getAttribute("random").toString());
	PrintWriter pw=response.getWriter();
	if(x.equals("Add")) {
            if(add(uname,clas,random,request)) {
			pw.print("<script>alert('Secondary Passanger"
						+ " added successfully')</script>");
			pw.print("<script>location.href='add.jsp'</script>");
		}}
		if(x.equals("add")) {
			if(add(uname,clas,random,1,request)) {
				pw.print("<script>alert('Primary Passanger"
							+ " added successfully')</script>");
				pw.print("<script>location.href='add.jsp'</script>");
			}}
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
