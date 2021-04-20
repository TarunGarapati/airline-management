<%-- 
    Document   : J2
    Created on : Jun 6, 2020, 9:35:03 AM
    Author     : sree
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Bookings</title>
        <style>
        #you
        {
        padding:8px 16px;
        border-radius:30px;
        outline:none;
        background-colour:olive;
        border-color:olive;
        float:right;
        cursor:pointer;
        }
        </style>
    </head>
    <body>
        <%
        HttpSession ses=request.getSession();
        if(ses.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");	
        }
        else{
	String name=ses.getAttribute("uname").toString();
	%>
<form action="Customer" method="post"><input type="submit" id="you" name="id" value="Logout"></form>
<form action="J3.jsp" method="post"><input type="submit" id="you" style="margin-right:5px" value="Book"></form>
<form action="J4.jsp" method="post"><input type="submit" id="you" style="margin-right:5px" value="Cancel"></form>

<center><big><h1>My Bookings</h1></big></center>

<%
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


%>
<%
try{
	String q="select *,company.company,passenger.name from ticket inner join company on ticket.company_id=company.id inner join user on user.username=ticket.uname inner join passenger on passenger.random=ticket.random where user.username=? and passenger.prime=?";
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
					+"<th>PNR Number</th>"
					+"<th>Primary Passanger Name</th>"
					+"<th>From</th>"
					+"<th>To</th>"
					+"<th>Company</th>"
					+"<th>Class of journey</th>"
					+"<th>Date of Journey(YYYY/MM/DD)</th>"
					+"<th>Arrival Time</th>"
					+"<th>Destination Time</th>"
					+"<th>Seats Booked</th>"
					+"<th>Amount Paid</th>"
					+"</tr>"				
					);
			
			i=1;
		}
			out.print("<tr>"
					+"<td>"+rs.getInt(12)+"</td>"
					+"<td>"+rs.getString(22)+"</td>"
					+ "<td>"+rs.getString(2)+"</td>"
					+ "<td>"+rs.getString(3)+"</td>"
					+"<td>"+rs.getString(14)+"</td>"
					+"<td>"+rs.getString(25)+"</td>"
					+ "<td>"+rs.getString(9)+"</td>"
					+ "<td>"+rs.getString(4)+"</td>"	
                                        + "<td>"+rs.getString(5)+"</td>"
					+ "<td>"+rs.getString(10)+"</td>"
					+"<td>"+rs.getString(7)+"</td>"
					+ "</tr>"
                                        );
        }
	out.print("</table>");	
}
catch(Exception e){
	e.printStackTrace();
}}
%>
    </body>
</html>
