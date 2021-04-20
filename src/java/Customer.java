/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
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
public class Customer extends User {

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
            out.println("<title>Servlet Customer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Customer at " + request.getContextPath() + "</h1>");
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
                    String a=request.getParameter("username");
                    String b=request.getParameter("password");
                    if(login(a, b))
                    {
                    HttpSession ses=request.getSession();
                    ses.setAttribute("uname",a);
                    ses.setMaxInactiveInterval(1000);
                    response.sendRedirect("J2.jsp");
                    }
                    else
                    {
                        pw.print("<script>alert('Invalid User!Please create an account');"+"window.location.href='Signup.jsp';");
                        pw.print("</script>");
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
            case "Signup":
                {
                    String a=request.getParameter("name");
                    String b=request.getParameter("phonenum");
                    String c=request.getParameter("email");
                    String d=request.getParameter("username");
                    String e=request.getParameter("password");    
                    if(signup(a,b,c,d,e))
                    {
                        pw.print("<script>window.alert('Account Created Succesfully');</script>");
    			pw.print("<script>window.location.href='Login.jsp';</script>");
    				
                    }
                    else
                    {
                        pw.print("<script>window.alert('Problem in creating an account');</script>");
    			pw.print("<script>window.location.href='Signup.jsp';</script>");	
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
