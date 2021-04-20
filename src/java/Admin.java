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
public class Admin extends User {
    public boolean Add_Flight(HttpServletRequest request, HttpServletResponse response)
    {
        int c_id=Integer.parseInt(request.getParameter("cid"));
        int r_id=Integer.parseInt(request.getParameter("rid"));
        String st_time=request.getParameter("start");
        String arr_time=request.getParameter("end");
        int dom=Integer.parseInt(request.getParameter("dom"));
        int mon=Integer.parseInt(request.getParameter("mon"));
        int tue=Integer.parseInt(request.getParameter("tue"));
        int wed=Integer.parseInt(request.getParameter("wed"));
        int thu=Integer.parseInt(request.getParameter("thu"));
        int fri=Integer.parseInt(request.getParameter("fri"));
        int sat=Integer.parseInt(request.getParameter("sat"));
        int sun=Integer.parseInt(request.getParameter("sun"));
        float price1=Float.parseFloat(request.getParameter("price1"));
        float price2=Float.parseFloat(request.getParameter("price2"));
        int mon1_seats=Integer.parseInt(request.getParameter("mon_seats_eco"));
        int tue1_seats=Integer.parseInt(request.getParameter("tue_seats_eco"));
        int wed1_seats=Integer.parseInt(request.getParameter("wed_seats_eco"));
        int thu1_seats=Integer.parseInt(request.getParameter("thu_seats_eco"));
        int fri1_seats=Integer.parseInt(request.getParameter("fri_seats_eco"));
        int sat1_seats=Integer.parseInt(request.getParameter("sat_seats_eco"));
        int sun1_seats=Integer.parseInt(request.getParameter("sun_seats_eco"));
        int mon2_seats=Integer.parseInt(request.getParameter("mon_seats_bus"));
        int tue2_seats=Integer.parseInt(request.getParameter("tue_seats_bus"));
        int wed2_seats=Integer.parseInt(request.getParameter("wed_seats_bus"));
        int thu2_seats=Integer.parseInt(request.getParameter("thu_seats_bus"));
        int fri2_seats=Integer.parseInt(request.getParameter("fri_seats_bus"));
        int sat2_seats=Integer.parseInt(request.getParameter("sat_seats_bus"));
        int sun2_seats=Integer.parseInt(request.getParameter("sun_seats_bus"));
        
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
         PreparedStatement ps=con.prepareStatement("insert into airline.flight(company_id,route_id,start_time,dest_time,domestic,mon,tue,wed,thu,fri,sat,sun,price_eco,price_bus,mon_seats_eco,tue_seats_eco,wed_seats_eco,thu_seats_eco,fri_seats_eco,sat_seats_eco,sun_seats_eco,mon_seats_bus,tue_seats_bus,wed_seats_bus,thu_seats_bus,fri_seats_bus,sat_seats_bus,sun_seats_bus) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         ps.setInt(1,c_id);
         ps.setInt(2,r_id);
         ps.setString(3,st_time);
         ps.setString(4,arr_time);
         ps.setInt(5,dom);
         ps.setInt(6,mon);
         ps.setInt(7,tue);
         ps.setInt(8,wed);
         ps.setInt(9,thu);
         ps.setInt(10,fri);
         ps.setInt(11,sat);
         ps.setInt(12,sun);
         ps.setFloat(13,price1);
         ps.setFloat(14,price2);
         ps.setInt(15,mon1_seats);
         ps.setInt(16,tue1_seats);
         ps.setInt(17,wed1_seats);
         ps.setInt(18,thu1_seats);
         ps.setInt(19,fri1_seats);
         ps.setInt(20,sat1_seats);
         ps.setInt(21,sun1_seats);
         ps.setInt(22,mon2_seats);
         ps.setInt(23,tue2_seats);
         ps.setInt(24,wed2_seats);
         ps.setInt(25,thu2_seats);
         ps.setInt(26,fri2_seats);
         ps.setInt(27,sat2_seats);
         ps.setInt(28,sun2_seats);
         
         int x=ps.executeUpdate();
         if(x>0)
             return true;
        }
        catch(ClassNotFoundException | SQLException ex)
             {
                 System.out.println(ex);
             }
        return false;
    }
    public boolean Remove_Flight(HttpServletRequest request, HttpServletResponse response)
    {
        int a=Integer.parseInt(request.getParameter("fid"));
         try
         {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
         PreparedStatement ps=con.prepareStatement("delete from airline.flight where id=?");
         ps.setInt(1,a);
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
    
    public boolean Update_Seats(HttpServletRequest request, HttpServletResponse response)
    {
        int a=Integer.parseInt(request.getParameter("fid"));
        int b=Integer.parseInt(request.getParameter("seat1"));
        int c=Integer.parseInt(request.getParameter("seat2"));
        String d=request.getParameter("day");
        String q="";
        if(d.equals("mon"))
        q="update airline.flight set mon_seats_eco=?,mon_seats_bus=? where flight.id=?";
        else if(d.equals("tue"))
        q="update airline.flight set tue_seats_eco=?,tue_seats_bus=? where flight.id=?";
        else if(d.equals("wed"))
        q="update airline.flight set wed_seats_eco=?,wed_seats_bus=? where flight.id=?";
        else if(d.equals("thu"))
        q="update airline.flight set thu_seats_eco=?,thu_seats_bus=? where flight.id=?";
        else if(d.equals("fri"))
        q="update airline.flight set fri_seats_eco=?,fri_seats_bus=? where flight.id=?";
        else if(d.equals("sat"))
        q="update airline.flight set sat_seats_eco=?,sat_seats_bus=? where flight.id=?";
        else if(d.equals("sun"))
        q="update airline.flight set sun_seats_eco=?,sun_seats_bus=? where flight.id=?";
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
         PreparedStatement ps=con.prepareStatement(q);
         ps.setInt(1,b);
         ps.setInt(2,c);
         ps.setInt(3,a);
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
    
    public boolean Update_Price(HttpServletRequest request, HttpServletResponse response)
    {
        int a=Integer.parseInt(request.getParameter("fid"));
        float b=Float.parseFloat(request.getParameter("price1"));
        float c=Float.parseFloat(request.getParameter("price2"));
        String d=request.getParameter("day");
        String q="";
        if(d.equals("mon"))
        q="update airline.flight set mon_price_eco=?,mon_price_bus=? where flight.id=?";
        else if(d.equals("tue"))
        q="update airline.flight set tue_price_eco=?,tue_price_bus=? where flight.id=?";
        else if(d.equals("wed"))
        q="update airline.flight set wed_price_eco=?,wed_price_bus=? where flight.id=?";
        else if(d.equals("thu"))
        q="update airline.flight set thu_price_eco=?,thu_price_bus=? where flight.id=?";
        else if(d.equals("fri"))
        q="update airline.flight set fri_price_eco=?,fri_price_bus=? where flight.id=?";
        else if(d.equals("sat"))
        q="update airline.flight set sat_price_eco=?,sat_price_bus=? where flight.id=?";
        else if(d.equals("sun"))
        q="update airline.flight set sun_price_eco=?,sun_price_bus=? where flight.id=?";
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
         PreparedStatement ps=con.prepareStatement(q);
         ps.setFloat(1,b);
         ps.setFloat(2,c);
         ps.setInt(3,a);
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
    
    public boolean Add_Company(HttpServletRequest request, HttpServletResponse response)
    {
        String a=request.getParameter("cname");
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
    
         PreparedStatement ps=con.prepareStatement("insert into airline.company(company) values (?)");
         ps.setString(1,a);
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
    
    public boolean Add_Promocode(HttpServletRequest request, HttpServletResponse response)
    {
        String a=request.getParameter("code");
        float b=Float.parseFloat(request.getParameter("value"));
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
    
         PreparedStatement ps=con.prepareStatement("insert into airline.promocode(code,value) values (?,?)");
         ps.setString(1,a);
         ps.setFloat(2,b);
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
    
    public boolean Add_Route(HttpServletRequest request, HttpServletResponse response)
    {
        float a=Float.parseFloat(request.getParameter("value"));
        String b=request.getParameter("from");
        String c=request.getParameter("to");

        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
    
         PreparedStatement ps=con.prepareStatement("insert into airline.route(distance,from_pl,to_pl) values (?,?,?)");
         ps.setFloat(1,a);
         ps.setString(2,b);
         ps.setString(3,c);
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
    
    public boolean Remove_User(HttpServletRequest request, HttpServletResponse response)
    {
        int a=Integer.parseInt(request.getParameter("uid"));
        try
        {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
    
         PreparedStatement ps=con.prepareStatement("delete from airline.user where user.id=?");
         ps.setInt(1,a);
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
            out.println("<title>Servlet Servlet4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet4 at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        String x=request.getParameter("id");
        switch (x) {
            case "Login":
            {
                    HttpSession ses=request.getSession();
                    String a=request.getParameter("username");
                    String b=request.getParameter("password");
                    if(login(a, b,"admin"))
                    {
                    ses.setAttribute("uname",a);
                    ses.setMaxInactiveInterval(1000);
                    response.sendRedirect("J1.jsp");
                    }
                    else
                    {
                    pw.print("<script>window.alert('Invalid Admin');</script>");
                    pw.print("<script>window.location.href='Ad_Login.jsp';</script>");	
                    }
                    break;
            }
            case "Logout":
            {
              HttpSession ses=request.getSession();
              if(logout(ses))
              {
                response.sendRedirect("Home.jsp");
              }
              break;
            }
            case "Add Flight":
                {                    
                    if(Add_Flight(request,response)) 
                    {
                    pw.println("<script>alert('Flight added Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Remove Flight":
                {
                    if(Remove_Flight(request,response))
                    {
                    pw.println("<script>alert('Flight removed Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Update Seats":
                {
                    if(Update_Seats(request,response))
                    {
                    pw.println("<script>alert('Seats updated Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Update Price":
                {
                    if(Update_Price(request,response))
                    {
                    pw.println("<script>alert('Prices updated Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Add Company":
                {
                    if(Add_Company(request,response))
                    {
                    pw.println("<script>alert('Company added Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Add Promocode":
                {
                    if(Add_Promocode(request,response))
                    {
                    pw.println("<script>alert('Promocode added Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Add Route":
                {
                    if(Add_Route(request,response))
                    {
                    pw.println("<script>alert('Route added Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }
            case "Remove User":
                {
                    if(Remove_User(request,response))
                    {
                    pw.println("<script>alert('User removed Successfully')</script>");
                    pw.print("<script>window.location.href='J1.jsp';</script>");
                    }
                    break;
                }     
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
