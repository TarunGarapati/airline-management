package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class J3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
ResultSet resultset=null;
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"date.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans|Permanent+Marker\" rel=\"stylesheet\">\n");
      out.write("        <title>Book Ticket</title>\n");
      out.write("        <style>\n");
      out.write("        @import url('https://fonts.googleapis.com/css?family=Open+Sans|Permanent+Marker');\n");
      out.write("        img{\n");
      out.write("        background-position:center;\n");
      out.write("        background-repeat:no-repeat;\n");
      out.write("        background-size:cover;\n");
      out.write("        position:absolute;\n");
      out.write("        width:100%;\n");
      out.write("        height:100%;\n");
      out.write("        z-index:-1;\n");
      out.write("        filter: blur(3px);\n");
      out.write("        -webkit-filter: blur(3px);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        div .one{text-align : center;bgcolor:yellow;\n");
      out.write("        padding-top: 30px;padding-left:40px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input{\n");
      out.write("        font-size:large;\n");
      out.write("        font-family: 'sans-serif';\n");
      out.write("        font-weight:bold;\n");
      out.write("        }\n");
      out.write("        #you\n");
      out.write("        {\n");
      out.write("        padding:8px 16px;\n");
      out.write("        border-radius:30px;\n");
      out.write("        outline:none;\n");
      out.write("        background-colour:olive;\n");
      out.write("        border-color:olive;\n");
      out.write("        margin-left:550px;\n");
      out.write("        cursor:pointer;\n");
      out.write("        }\n");
      out.write("        #you1{\n");
      out.write("        padding:8px 14px;\n");
      out.write("        border-radius:30px;\n");
      out.write("        outline:none;\n");
      out.write("        background-colour:olive;\n");
      out.write("        border-color:olive;\n");
      out.write("        margin-left:425px;\n");
      out.write("        cursor:pointer;\n");
      out.write("        }\n");
      out.write("        select{\n");
      out.write("        margin-left:5px;\n");
      out.write("        padding:9px 40px;\n");
      out.write("        border:none;\n");
      out.write("        outline:none;\n");
      out.write("        font-size:medium;\n");
      out.write("        font-weight:bold;\n");
      out.write("        }\n");
      out.write("        #vis1{\n");
      out.write("        margin-left:45px;\n");
      out.write("        padding:11px 40px;\n");
      out.write("        border:none;\n");
      out.write("        outline:none;\n");
      out.write("        border-bottom:2px solid black;\n");
      out.write("        background:transparent;\n");
      out.write("        font-size:medium;\n");
      out.write("        font-weight:bold;\n");
      out.write("        cursor:pointer;\n");
      out.write("        }\n");
      out.write("        option{\n");
      out.write("        padding:11px 60px;\n");
      out.write("        background:transparent;\n");
      out.write("        }\n");
      out.write("        #vis{\n");
      out.write("        margin-left:45px;\n");
      out.write("        padding:9px 40px;\n");
      out.write("        border:none;\n");
      out.write("        outline:none;\n");
      out.write("        border-bottom:2px solid black;\n");
      out.write("        background:transparent;\n");
      out.write("        font-size:medium;\n");
      out.write("        font-weight:bold;\n");
      out.write("        cursor:pointer;\n");
      out.write("        }\n");
      out.write("        th{\n");
      out.write("        margin-left:15px;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");

    session=request.getSession();
    if(session.getAttribute("uname")==null){
	response.sendRedirect("index1.html");	
    }
    
      out.write("\n");
      out.write("    <div style=\"margin-left:90px;margin-bottom:10px;margin-top:10px;\">\n");
      out.write("    <form action=\"Customer\" method=\"post\">\n");
      out.write("    <b></b><big style=\"margin-left:450px;font-size:xx-large;margin-bottom:30px;\">Search Domestic Flights</b></big>\n");
      out.write("    <input type=\"submit\" value=\"Logout\" id=\"you1\" name=\"id\">\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("    <hr style=\"border-bottom:2px solid black\"><br><br><br>\n");
      out.write("    <form action=\"Search\" method=\"post\">\n");
      out.write("    <div class=\"one\" style=\"margin-left:2%\">\n");
      out.write("    <div class=\"page\">\n");
      out.write("    <div class=\"page__demo\">\n");
      out.write("    <table>\n");
      out.write("    <tr height=\"\">\n");
      out.write("  \t<th><u>Type of Journey</u></th>\n");
      out.write("  \t<th><u>From</u></th>\n");
      out.write("  \t<th><u>To</u></th>\n");
      out.write("  \t<th><u>Date Of Journey</u></th>\n");
      out.write("  \t<th><u>Class of journey</u></th>\n");
      out.write("  \t\n");
      out.write("    </tr>\n");
      out.write("  \n");
      out.write("    <tr>\n");
      out.write("    <td>\n");
      out.write("\t<b><input type=\"text\" value=\"Domestic\" id=\"vis1\" style=\"cursor:none\" readonly></b>\n");
      out.write("  \t</td>\n");
      out.write("        <td>\n");
      out.write("        <select id=\"vis\" name=\"from\" required=\"cannot be empty\">\n");
      out.write("        <option value=\"None\">None</option>\n");
      out.write("         \n");
      out.write("        ");

        Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	Statement st=con.createStatement();
	String q="select international.place from airline.international where domestic=1";
	ResultSet rs=st.executeQuery(q);
	while(rs.next()){
      out.write("\n");
      out.write("\t<option value=");
      out.print( rs.getString(1) );
      out.write(">\n");
      out.write("\t");
      out.print(rs.getString(1) );
      out.write("\n");
      out.write("\t</option>");
	
	}
      out.write("\n");
      out.write("\n");
      out.write("  </select>\n");
      out.write("  \t</td>\n");
      out.write("  \t<td>\n");
      out.write("  \t<select id=\"vis\" name=\"to\" required=\"cannot be empty\">\n");
      out.write("  \t\n");
      out.write("  <option value=\"None\">None</option>\n");
      out.write("  ");

 	
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	st=con.createStatement();
	rs=st.executeQuery(q);
	while(rs.next()){
      out.write("\n");
      out.write("\t<option value=");
      out.print( rs.getString(1) );
      out.write(">\n");
      out.write("\t");
      out.print(rs.getString(1) );
      out.write("\n");
      out.write("\t</option>");
	
	}
      out.write("\n");
      out.write("\t\n");
      out.write("  </select></td>\n");
      out.write("  \t<td>\n");
      out.write("  \t\t<input type=\"date\" name=\"date\" id=\"vis\" required>\n");
      out.write("  \t</td>\n");
      out.write("  \t<td>\n");
      out.write("  \t<select id=\"vis\" name=\"class\" required>\n");
      out.write("        <option value=\"economy\">Economy</option>\n");
      out.write("        <option value=\"business\">Business</option>\n");
      out.write("        </select>\n");
      out.write("  \t</td>\t\n");
      out.write("        </tr>\n");
      out.write("        </table>\n");
      out.write("    <br>\n");
      out.write("        <input type=\"submit\" value=\"Search Domestic\" id=\"you\" name=\"id\" style=\"margin-bottom:70px\">\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("    </form>\n");
      out.write("<marquee behavior='scroll' direction='left'><b style='color:red'><h3>Advanced Bookings can be made only before one week from current date</h3></b></marquee>\n");
      out.write("\n");
      out.write("<div style=\"margin-left:90px;margin-bottom:10px;margin-top:10px;\">\n");
      out.write("<form action=\"Customer\" method=\"post\">\n");
      out.write("<b></b><big style=\"margin-left:425px;font-size:xx-large;margin-bottom:30px;\">Search International Flights</b></big>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<hr style=\"border-bottom:2px solid black\"><br><br><br>\n");
      out.write("<form action=\"Search\" method=\"post\">\n");
      out.write("<div class=\"one\" style=\"margin-left:2%\">\n");
      out.write("<div class=\"page\">\n");
      out.write("  <div class=\"page__demo\">\n");
      out.write("  <table>\n");
      out.write("  <tr height=\"\">\n");
      out.write("  \t<th><u>Type of Journey</u></th>\n");
      out.write("  \t<th><u>From</u></th>\n");
      out.write("  \t<th><u>To</u></th>\n");
      out.write("  \t<th><u>Date Of Journey</u></th>\n");
      out.write("  \t<th><u>Class of journey</u></th>\n");
      out.write("  \t\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("  <tr>\n");
      out.write("   <td>\n");
      out.write("\t<b><input type=\"text\" value=\"International\" style=\"cursor:none\" id=\"vis\" readonly></b>\n");
      out.write("   </td>\n");
      out.write("  \t<td>\n");
      out.write("\n");
      out.write("  <select id=\"vis\" name=\"from\" required=\"cannot be empty\">\n");
      out.write("  <option value=\"None\">None</option>\n");
      out.write("  \n");
      out.write("  ");

   
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	st=con.createStatement();
	q="select international.place from airline.international where international=1 union select international.place from airline.international where domestic=1";
	rs=st.executeQuery(q);
	while(rs.next()){
      out.write("\n");
      out.write("\t<option value=");
      out.print( rs.getString(1) );
      out.write(">\n");
      out.write("\t");
      out.print(rs.getString(1) );
      out.write("\n");
      out.write("\t</option>");
	
	}
      out.write("\n");
      out.write("\n");
      out.write("  </select>\n");
      out.write("  \t</td>\n");
      out.write("  \t<td>\n");
      out.write("  \t<select id=\"vis\" name=\"to\" required=\"cannot be empty\">\n");
      out.write("  \t\n");
      out.write("  <option value=\"None\">None</option>\n");
      out.write("  ");
	
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	st=con.createStatement();
	rs=st.executeQuery(q);
	while(rs.next()){
      out.write("\n");
      out.write("\t<option value=");
      out.print( rs.getString(1) );
      out.write(">\n");
      out.write("\t");
      out.print(rs.getString(1) );
      out.write("\n");
      out.write("\t</option>");
	
	}
      out.write("\n");
      out.write("\t\n");
      out.write("  </select></td>\n");
      out.write("  \t<td>\n");
      out.write("  \t\t<input type=\"date\" name=\"date\" id=\"vis\" required>\n");
      out.write("  \t</td>\n");
      out.write("  \t<td>\n");
      out.write("  \t<select id=\"vis\" name=\"clas\" required>\n");
      out.write("        <option value=\"economy\">Economy</option>\n");
      out.write("        <option value=\"business\">Business</option>\n");
      out.write("        </select>  \n");
      out.write("  \t</td>\n");
      out.write("  </tr>\n");
      out.write("  </table>\n");
      out.write("        <br>\n");
      out.write("        <input type=\"submit\" value=\"Search International\" name=\"id\" id=\"you\">\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("    </form>\n");
      out.write("\n");
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
