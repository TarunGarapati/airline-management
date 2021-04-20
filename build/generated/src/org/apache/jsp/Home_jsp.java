package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Airline Reservation System</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"main-page.css\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("  \n");
      out.write("    <script src=\"automate-slideshow.js\" type=\"text/javascript\"></script>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("\n");
      out.write("    *{margin: 0;padding:0px}\n");
      out.write("\n");
      out.write("                .header{\n");
      out.write("                    width: 100%;\n");
      out.write("                    background-color: none; \n");
      out.write("                    height: 60px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .showLeft{\n");
      out.write("                   text-shadow: none !important;\n");
      out.write("                    color:#fff !important; \n");
      out.write("                    padding:10px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .icons li {\n");
      out.write("                    background: none repeat scroll 0 0 #fff;\n");
      out.write("                    height: 7px;\n");
      out.write("                    width: 7px;\n");
      out.write("                    line-height: 0;\n");
      out.write("                    list-style: none outside none;\n");
      out.write("                    margin-right: 15px;\n");
      out.write("                    margin-top: 3px;\n");
      out.write("                    vertical-align: top;\n");
      out.write("                    border-radius:50%;\n");
      out.write("                    pointer-events: none;\n");
      out.write("                    border-color: black;\n");
      out.write("                    background-color: black;\n");
      out.write("                }\n");
      out.write("    \n");
      out.write("    .btn-left {\n");
      out.write("                    left: 0.4em;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .btn-right {\n");
      out.write("                    right: 0.4em;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .btn-left, .btn-right {\n");
      out.write("                    position: absolute;\n");
      out.write("                    top: 0.24em;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .dropbtn {\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    color: white;\n");
      out.write("                    font-size: 16px;\n");
      out.write("                    border: none;\n");
      out.write("                    cursor: pointer;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .dropbtn:hover, .dropbtn:focus {\n");
      out.write("                  \n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .dropdown {\n");
      out.write("                    position: absolute;\n");
      out.write("                    display: inline-block;\n");
      out.write("                    right: 0.4em;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .dropdown-content {\n");
      out.write("                    display: none;\n");
      out.write("                    position: relative;\n");
      out.write("                    margin-top: 60px;\n");
      out.write("                    background-color: #f9f9f9;\n");
      out.write("                    min-width: 160px;\n");
      out.write("                    overflow: auto;\n");
      out.write("                    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("                    z-index: 1;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .dropdown-content a {\n");
      out.write("                    color: black;\n");
      out.write("                    padding: 12px 16px;\n");
      out.write("                    text-decoration: none;\n");
      out.write("                    display: block;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .dropdown a:hover {background-color: #f1f1f1}\n");
      out.write("\n");
      out.write("                .show {display:block;}\n");
      out.write("\n");
      out.write("            </style>\n");
      out.write("            <script>\n");
      out.write("                function changeLanguage(language) {\n");
      out.write("                    var element = document.getElementById(\"url\");\n");
      out.write("                    element.value = language;\n");
      out.write("                    element.innerHTML = language;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function showDropdown() {\n");
      out.write("                    document.getElementById(\"myDropdown\").classList.toggle(\"show\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Close the dropdown if the user clicks outside of it\n");
      out.write("                window.onclick = function(event) {\n");
      out.write("                    if (!event.target.matches('.dropbtn')) {\n");
      out.write("                        var dropdowns = document.getElementsByClassName(\"dropdown-content\");\n");
      out.write("                        var i;\n");
      out.write("                        for (i = 0; i < dropdowns.length; i++) {\n");
      out.write("                            var openDropdown = dropdowns[i];\n");
      out.write("                            if (openDropdown.classList.contains('show')) {\n");
      out.write("                                openDropdown.classList.remove('show');\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <div class=\"menu\" name=\"menubar\">\n");
      out.write("        <img src=\"logo2.png\" id=\"special\">\n");
      out.write("\t<span id=\"Build\" style=\"font-size:xx-large;font-family:sans-serif;margin-right:29%;text-decoration:underline\">Fly In The Air</span>\n");
      out.write("    \t<button class=\"btn btn-primary active\"  ><a href=\"Signup.jsp\" style=\"text-decoration:none;color:white;\" target=\"_blank\">SignUp</a></button>\n");
      out.write("    \t<button class=\"btn btn-primary disabled\"><a href=\"Login.jsp\" style=\"text-decoration:none;color:white\" target=\"_blank\">LogIn</a></button>\n");
      out.write("    \n");
      out.write("        <div class=\"header\">\n");
      out.write("\n");
      out.write("                <!-- three dot menu -->\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <!-- three dots -->\n");
      out.write("                    <ul class=\"dropbtn icons btn-right showLeft\" style=\"margin-top:-70px;\" onclick=\"showDropdown()\">\n");
      out.write("                        <li></li>\n");
      out.write("                        <li></li>\n");
      out.write("                        <li></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- menu -->\n");
      out.write("                    <div id=\"myDropdown\" class=\"dropdown-content\">\n");
      out.write("                        <a href=\"J3.jsp\">Book Ticket</a>\n");
      out.write("                        <a href=\"J4.jsp\">Cancel Ticket</a>\n");
      out.write("                        <a href=\"J2.jsp\">My Bookings</a> \n");
      out.write("                        <a href=\"Ad_Login.jsp\">Admin Login</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tvar k=1;\n");
      out.write("\t</script>\n");
      out.write("<div class=\"container\">\n");
      out.write("   <img class=\"mySlides\" src=\"flight1.jpg\">\n");
      out.write("   <img class=\"mySlides\" src=\"flight2.jpg\">\n");
      out.write("   <img class=\"mySlides\" src=\"flight3.jpg\">\n");
      out.write("   <img class=\"mySlides\" src=\"flight4.jpg\">\n");
      out.write("   <img class=\"mySlides\" src=\"flight5.jpg\">\n");
      out.write("</div>\n");
      out.write("  <div class=\"circles\" style=\"margin-left:45%;margin-top:13px;\">\n");
      out.write("  \t<div class=\"dot\" id=\"c1\" onclick=\"crctpic(k)\"></div>\n");
      out.write("  \t<div id=\"c2\" class=\"dot\" onclick=\"crctpic(k+1)\"></div>\n");
      out.write("  \t<div id=\"c3\" class=\"dot\" onclick=\"crctpic(k+2)\"></div>\n");
      out.write("  \t<div id=\"c4\" class=\"dot\" onclick=\"crctpic(k+3)\"></div>\n");
      out.write("  \t<div id=\"c5\" class=\"dot\" onclick=\"crctpic(k+4)\"></div>\n");
      out.write("  </div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("  var myIndex = 0;\n");
      out.write("  carousel();\n");
      out.write("  \t</script>\n");
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
