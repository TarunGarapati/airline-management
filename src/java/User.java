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
public class User extends HttpServlet {
    public boolean login(String uname,String pass)
    {
        boolean status=false;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
        PreparedStatement ps=con.prepareStatement("select username,password from user where username=? and password=?");
        ps.setString(1, uname);
        ps.setString(2, pass);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        }
        catch(ClassNotFoundException | SQLException e)
        {
              System.out.println(e);
        }
        return status;
    }
    
    public boolean login(String uname,String pass,String role)
    {
        boolean status=false;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
        PreparedStatement ps=con.prepareStatement("select username,password from admin where username=? and password=?");
        ps.setString(1, uname);
        ps.setString(2, pass);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        }
        catch(ClassNotFoundException | SQLException e)
        {
              System.out.println(e);
        }
        return status;
    }
    
    public boolean signup(String name,String phno,String email,String uname,String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
            PreparedStatement ps=con.prepareStatement("insert into user(name,phonenum,email,username,password) values(?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,phno);
            ps.setString(3,email);
            ps.setString(4,uname);
            ps.setString(5,pass);
            int x=ps.executeUpdate();
            if(x>0)
                return true;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
        
    public boolean logout(HttpSession session)
    {
        session.invalidate();
        return true;
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
            out.println("<title>Servlet User</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet User at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
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
        processRequest(request, response);
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
