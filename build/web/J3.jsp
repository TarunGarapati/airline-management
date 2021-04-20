<%-- 
    Document   : J3
    Created on : Jun 6, 2020, 6:09:48 PM
    Author     : sree
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<%ResultSet resultset=null;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="date.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans|Permanent+Marker" rel="stylesheet">
        <title>Book Ticket</title>
        <style>
        @import url('https://fonts.googleapis.com/css?family=Open+Sans|Permanent+Marker');
        img{
        background-position:center;
        background-repeat:no-repeat;
        background-size:cover;
        position:absolute;
        width:100%;
        height:100%;
        z-index:-1;
        filter: blur(3px);
        -webkit-filter: blur(3px);
        }

        div .one{text-align : center;bgcolor:yellow;
        padding-top: 30px;padding-left:40px;
        }

        input{
        font-size:large;
        font-family: 'sans-serif';
        font-weight:bold;
        }
        #you
        {
        padding:8px 16px;
        border-radius:30px;
        outline:none;
        background-colour:olive;
        border-color:olive;
        margin-left:550px;
        cursor:pointer;
        }
        #you1{
        padding:8px 14px;
        border-radius:30px;
        outline:none;
        background-colour:olive;
        border-color:olive;
        margin-left:550px;
        cursor:pointer;
        }
        select{
        margin-left:5px;
        padding:9px 40px;
        border:none;
        outline:none;
        font-size:medium;
        font-weight:bold;
        }
        #vis1{
        margin-left:45px;
        padding:11px 40px;
        border:none;
        outline:none;
        border-bottom:2px solid black;
        background:transparent;
        font-size:medium;
        font-weight:bold;
        cursor:pointer;
        }
        option{
        padding:11px 60px;
        background:transparent;
        }
        #vis{
        margin-left:45px;
        padding:9px 40px;
        border:none;
        outline:none;
        border-bottom:2px solid black;
        background:transparent;
        font-size:medium;
        font-weight:bold;
        cursor:pointer;
        }
        th{
        margin-left:15px;
        }
        </style>
    </head>
    <body>
    <%
    session=request.getSession();
    if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");	
    }
    %>
    <div style="margin-left:90px;margin-bottom:10px;margin-top:10px;">
    <form action="Customer" method="post">
    <input type="submit" value="Logout" id="you1" name="id">
    </form>
    <b></b><big style="margin-left:450px;font-size:xx-large;margin-bottom:30px;">Search Domestic Flights</b></big>
    </div>
    
    <hr style="border-bottom:2px solid black"><br><br><br>
    <form action="Search" method="post">
    <div class="one" style="margin-left:2%">
    <div class="page">
    <div class="page__demo">
    <table>
    <tr height="">
  	<th><u>Type of Journey</u></th>
  	<th><u>From</u></th>
  	<th><u>To</u></th>
      	<th><u>Today Date</u></th>
  	<th><u>Date Of Journey</u></th>    
  	<th><u>Class of journey</u></th>
  	
    </tr>
  
    <tr>
    <td>
	<b><input type="text" value="Domestic" id="vis1" style="cursor:none" readonly></b>
  	</td>
        <td>
        <select id="vis" name="from" required="cannot be empty">
        <option value="None">None</option>
         
        <%
        Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	Statement st=con.createStatement();
	String q="select international.place from airline.international where domestic=1";
	ResultSet rs=st.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>

  </select>
  	</td>
  	<td>
  	<select id="vis" name="to" required="cannot be empty">
  	
  <option value="None">None</option>
  <%
 	
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	st=con.createStatement();
	rs=st.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>
	
  </select></td>
  	<td>
  		<input type="date" name="date1" id="vis" required>
  	</td>
        <td>
  		<input type="date" name="date2" id="vis" required>
  	</td>
  	<td>
  	<select id="vis" name="class" required>
        <option value="economy">Economy</option>
        <option value="business">Business</option>
        </select>
  	</td>	
        </tr>
        </table>
    <br>
        <input type="submit" value="Search Domestic" id="you" name="id" style="margin-bottom:70px">
    </div>
    </div>
    </div>
    </form>
<marquee behavior='scroll' direction='left'><b style='color:red'><h3>Advance Bookings can be made only before one week from current date</h3></b></marquee>

<div style="margin-left:90px;margin-bottom:10px;margin-top:10px;">
    
<b></b><big style="margin-left:425px;font-size:xx-large;margin-bottom:30px;">Search International Flights</b></big>

</div>
<hr style="border-bottom:2px solid black"><br><br><br>
<form action="Search" method="post">
<div class="one" style="margin-left:2%">
<div class="page">
  <div class="page__demo">
  <table>
  <tr height="">
  	<th><u>Type of Journey</u></th>
  	<th><u>From</u></th>
  	<th><u>To</u></th>
        <th><u>Today Date</u></th>
  	<th><u>Date Of Journey</u></th>
  	<th><u>Class of journey</u></th>
  	
  </tr>
  
  <tr>
   <td>
	<b><input type="text" value="International" style="cursor:none" id="vis" readonly></b>
   </td>
  	<td>

  <select id="vis" name="from" required="cannot be empty">
  <option value="None">None</option>
  
  <%
   
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	st=con.createStatement();
	q="select international.place from airline.international where international=1 union select international.place from airline.international where domestic=1";
	rs=st.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>

  </select>
  	</td>
  	<td>
  	<select id="vis" name="to" required="cannot be empty">
  	
  <option value="None">None</option>
  <%	
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	st=con.createStatement();
	rs=st.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>
	
  </select></td>
  	<td>
  		<input type="date" name="date1" id="vis" required>
  	</td>
        <td>
  		<input type="date" name="date2" id="vis" required>
  	</td>
  	<td>
  	<select id="vis" name="class" required>
        <option value="economy">Economy</option>
        <option value="business">Business</option>
        </select>  
  	</td>
  </tr>
  </table>
        <br>
        <input type="submit" value="Search International" name="id" id="you">
    </div>
    </div>
    </div>
    </form>


    </body>
</html>
