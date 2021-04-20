<%-- 
    Document   : add
    Created on : Jun 9, 2020, 12:05:51 PM
    Author     : sree
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Passenger</title>
    </head>
    <body>
        <%
        HttpSession ses=request.getSession();
        int i=Integer.parseInt(ses.getAttribute("i").toString());
        //out.print(i);
        String clas=ses.getAttribute("class").toString();
        int seats=0;
        if(i==0){
	seats=Integer.parseInt(request.getParameter("num").toString());
	int id=Integer.parseInt(request.getParameter("id").toString());
	String promo=request.getParameter("promo").toString();
	ses.setAttribute("id",id);
	ses.setAttribute("seats",seats);
            if(promo.equals(""))
            ses.setAttribute("promo", "zero");
            else{
            ses.setAttribute("promo",promo);
            }
        int random=(int) (Math.random()*1000+ 1);
	ses.setAttribute("random", random);
        }
        else if(i>0){
        seats=Integer.parseInt(ses.getAttribute("seats").toString());
}
%>
<%if(i==0){ %>
        <h2>Enter Primary Passenger Details</h2>
        <form action="Add" method="post" id="one">
        Name: <input type="text" name="pname" required>
        Age: <input type="number" name="age" required>
        Gender: <select name="gender" required><option value='Male'>Male</option><option value='Female'>Female</option></select>
        Class:<%= clas %>
        <%
        i++;
        ses.setAttribute("i",i);
        %>
        <input type='submit' value='add' name='add'>
        </form>
        <%}

//i=Integer.parseInt(ses.getAttribute("i").toString());
else if(i<seats){%>

<h2>Enter Secondary Passenger Details</h2>
<h2>Enter Passenger <%= i+1%> Details</h2>
<form action="Add" method="post" id="two">
Name: <input type="text" name="pname" required>
Age: <input type="number" name="age" required>
Gender: <select name="gender" required><option value='Male'>Male</option><option value='Female'>Female</option></select>
Class:<%= clas %>
<%
i++;
ses.setAttribute("i", i);
%>
<input type='submit' value='Add' name='add'>
</form>
<%}
else if(i==seats){
	out.print("<script>document.getElementById('two')='none'</script>");
        %>
        <form action="Book" method="post">
        <input type="submit" value="Proceed">
        </form>
    <% 
    }
    %>

    </body>
</html>
