package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.HttpSession;

public final class J2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>My Bookings</title>\n");
      out.write("        <style>\n");
      out.write("        #you\n");
      out.write("        {\n");
      out.write("        padding:8px 16px;\n");
      out.write("        border-radius:30px;\n");
      out.write("        outline:none;\n");
      out.write("        background-colour:olive;\n");
      out.write("        border-color:olive;\n");
      out.write("        float:right;\n");
      out.write("        cursor:pointer;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        HttpSession ses=request.getSession();
        if(ses.getAttribute("uname")==null){
	response.sendRedirect("index1.html");	
        }
        else{
	String name=ses.getAttribute("uname").toString();
	
      out.write("\n");
      out.write("<form action=\"Customer\" method=\"post\"><input type=\"submit\" id=\"you\" name=\"id\" value=\"Logout\"></form>\n");
      out.write("<form action=\"J3.jsp\" method=\"post\"><input type=\"submit\" id=\"you\" style=\"margin-right:5px\" value=\"Book\"></form>\n");
      out.write("<form action=\"J4.jsp\" method=\"post\"><input type=\"submit\" id=\"you\" style=\"margin-right:5px\" value=\"Cancel\"></form>\n");
      out.write("\n");
      out.write("<center><big><h1>My Bookings</h1></big></center>\n");
      out.write("\n");

out.print("<html>"
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



      out.write('\n');

try{
	String q="select *,company.company,passanger.name from ticket inner join company on ticket.company=company.id inner join user on user.uname=ticket.uname inner join passanger on passanger.random=ticket.random where user.uname=? and passanger.prime=?";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	PreparedStatement st=con.prepareStatement(q);
	st.setString(1,name);
	st.setInt(2,1);
	ResultSet rs=st.executeQuery();
	int i=0;
	while(rs.next()){
		if(i==0){
			out.print("<table align='center'>"
					+"<tr>"
					+"<th>Ticket Id</th>"
					+"<th>Primary Passanger Name</th>"
					+"<th>From</th>"
					+"<th>To</th>"
					+ "<th>Company</th>"
					+"<th>Class of journey</th>"
					+ "<th>Date of Journey(YYYY/MM/DD)</th>"
					+ "<th>Arrival Time</th>"
					+ "<th>Destination Time</th>"
					+"<th>Seats Booked</th>"
					+"<th>Amount Paid</th>"
					+ "</tr>"	
						
					);
			
			i=1;
		}
		else
                {
			out.print("<tr>"
					+"<td>"+rs.getInt(12)+"</td>"
					+"<td>"+rs.getString(21)+"</td>"
					+ "<td>"+rs.getString(2)+"</td>"
					+ "<td>"+rs.getString(3)+"</td>"
					+"<td>"
					+  rs.getString(14)
					+"</td>"
							+"<td>"
							+  rs.getString(24)
							+"</td>"
							
					+ "<td>"
					+rs.getString(9)+"</td>"
					+ "<td>"
					+rs.getString(4)+"</td>"	
							+ "<td>"+rs.getString(5)+"</td>"
									+ "<td>"+rs.getString(10)+"</td>"
									+"<td>"+rs.getString(7)+"</td>"
									+ "</tr>"
											);
			
		
		}
        }
	out.print("</table>");
		
	
	
}
catch(Exception e){
	e.printStackTrace();
}}

      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
