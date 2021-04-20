<%-- 
    Document   : J1
    Created on : Jun 3, 2020, 2:56:45 PM
    Author     : sree
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
        <style>
        body{margin:0;}
        .navbar {
                overflow: hidden;
                background-color: #333;
                position: fixed;
                top: 0;
                width: 100%;
                }
        .navbar a {
                    float: left;
                    display: block;
                    color: #f2f2f2;
                    text-align: center;
                    padding: 14px 16px;
                    text-decoration: none;
                    font-size: 17px;
                    }
        .navbar a:hover {
                        background: #ddd;
                        color: black;
                        }

        .main {
                padding: 16px;
                margin-top: 30px;
                height: 1500px; 
                }
        </style>
    </head>
    
    <body>
        <script type="text/javascript">
function display1(){
	document.getElementById("one").style.display="block";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	}
function display2(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="block";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	document.getElementById("eight").style.display="none";
	}
function display3(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="block";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	document.getElementById("eight").style.display="none";
        }
function display4(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="block";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	document.getElementById("eight").style.display="none";
        }
function display5(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="block";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	document.getElementById("eight").style.display="none";
	}
function display6(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="block";
	document.getElementById("seven").style.display="none";
	document.getElementById("eight").style.display="none";
	}
function display7(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="block";
        document.getElementById("eight").style.display="none";
	}
function display8(){
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("three").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
        document.getElementById("eight").style.display="block";
	}
        </script>
        <div class="navbar">
        <a href="#one" onclick="display1()">Add Flight</a>
        <a href="#two" onclick="display2()">Remove Flight</a>
        <a href="#three" onclick="display3()">Remove User</a>
        <a href="#four" onclick="display4()">Add Company</a>
        <a href="#five" onclick="display5()">Add Route</a>
        <a href="#six" onclick="display6()">Add PromoCode</a>
        <a href="#seven" onclick="display7()">Update Seats</a>
        <a href="#eight" onclick="display8()">Update Price</a>  
  <form action="Admin" method="post"><a style="float:right"><button style="background-color:transparent;border:none;color:white;cursor:pointer" name="id" value="Logout">Logout</button></a></form>
     </div>
    
        <div id="one" style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Flight</b></h2></center>
			<table align="center">
			<tr><td>Enter company Name:</td><td>		
			 <select id="cid" name="cid" required="cannot be empty">
  <option value="None">None</option>
  
  <%
        Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","" );
	Statement cs=con.createStatement();
	String q="select company.id,company.company from airline.company ";
	ResultSet rs=cs.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(2) %>
	</option><%	
	}%>

  </select>
			</td></tr>
			<tr><td>Enter Route Details:</td><td>
			
			 <select id="rid" name="rid" required="cannot be empty">
                          <option value="None">None</option>
  
  <%
          Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	  cs=con.createStatement();
          q="select route.id,route.from_pl,route.to_pl from airline.route ";
	  rs=cs.executeQuery(q);
          while(rs.next()){%>
          <option value=<%= rs.getInt(1) %>>
          <%=rs.getString(2) %> - <%=rs.getString(3) %>
	</option><%	
	}%>

  </select>				
			 </td></tr>
			<tr><td>Enter Start Time:</td><td><input type="text" name="start"></td></tr>
			<tr><td>Enter End Time:</td><td><input type="text" name="end"></td></tr>
			<tr><td>Enter Economy Price:</td><td><input type="number" name="price1"></td></tr>
			<tr><td>Enter Business Price:</td><td><input type="number" name="price2"></td></tr>
			<tr><td>Domestic or international flight</td><td>  
			
			<select id="dom" name="dom">
                        <option value="0"> international</option>
                        <option value="1">  Domestic</option>
                        </select>			
			</td></tr>
                        
			<tr>
			<td>Monday Availability</td><td>  
			<select name="mon">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
                        <td>Monday Available Economy Seats</td><td><input type="number" name="mon_seats_eco"></td>
                        <td>Monday Available Business Seats</td><td><input type="number" name="mon_seats_bus"></td>
			</tr>
                        
			<tr>
			<td>Tuesday Availability</td>
			<td> 
			<select name="tue">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
                        
			<td>Tuesday Available Economy Seats</td><td><input type="number" name="tue_seats_eco"></td>
			<td>Tuesday Available Business Seats</td><td><input type="number" name="tue_seats_bus"></td>
			</tr>
			<tr>
			<td>Wednesday Availability</td>
			<td> 
			<select name="wed">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Wednesday Available Economy Seats</td><td><input type="number" name="wed_seats_eco"></td>
			<td>Wednesday Available Business Seats</td><td><input type="number" name="wed_seats_bus"></td>
			</tr>
			<tr>
			<td>Thursday Availability</td>
			<td> 
			<select name="thu">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Thursday Available Economy Seats</td><td><input type="number" name="thu_seats_eco"></td>
			<td>Thursday Available Business Seats</td><td><input type="number" name="thu_seats_bus"></td>
			</tr>
			<tr>
			<td>Friday Availability</td>
			<td> 
			<select name="fri">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Friday Available Economy Seats</td><td><input type="number" name="fri_seats_eco"></td>
			<td>Friday Available Business Seats</td><td><input type="number" name="fri_seats_bus"></td>
			</td></tr>
			<tr>
			<td>Saturday Availability</td>
			<td> 
			<select name="sat">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Saturday Available Economy Seats</td><td><input type="number" name="sat_seats_eco"></td>
			<td>Saturday Available Business Seats</td><td><input type="number" name="sat_seats_bus"></td>
			</tr>
			<tr>
			<td>Sunday Availability</td>
			<td> 
			<select name="sun">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Sunday Available Economy Seats</td><td><input type="number" name="sun_seats_eco"></td>
			<td>Sunday Available Business Seats</td><td><input type="number" name="sun_seats_bus"></td>
			</tr>
			
			</table>
			<center><input type="submit" value="Add Flight" name="id"></center>
			
	</form>

</div>
        <div id="two"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Remove Flight</b></h2></center>
			<table align="center">
			<tr><td>Enter Flight Details:</td><td> 
			
			<select id="vis" name="fid" required="cannot be empty">
  <option value="None">None</option>
  
  <% 
          Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	  cs=con.createStatement();
	  q="select flight.id,company.company,route.from_pl,route.to_pl,flight.start_time,flight.dest_time from airline.flight inner join airline.route on flight.route_id=route.id inner join airline.company on flight.company_id=company.id";
	  rs=cs.executeQuery(q);
          while(rs.next()){%>
          <option value=<%= rs.getInt(1) %>>
	  <%=rs.getString(1) %> : <%=rs.getString(2) %> ,  (<%=rs.getString(3) %> - <%=rs.getString(4) %>) , (<%=rs.getString(5) %> - <%=rs.getString(6) %>)  
	  </option><%	
	}%>

  </select>
  
			
			</td></tr>
			</table>
			<center><input type="submit" value="Remove Flight" name="id"></center>
			
	</form>
</div>
        <div id="three"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Remove User</b></h2></center>
			<table align="center">
			<tr><td>Enter UserId:</td><td>
		<select id="vis" name="uid" required="cannot be empty">
                <option value="None">None</option>
  
  <%
          Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	  cs=con.createStatement();
	  q="select user.id,user.name from airline.user";
	  rs=cs.executeQuery(q);
          while(rs.next()){%>
          <option value=<%= rs.getInt(1) %>>
          <%=rs.getString(1) %> : <%=rs.getString(2) %> 
          </option><%	
          }%>

  </select>	
			</td></tr>
			</table>
			<center><input type="submit" value="Remove User" name="id"></center>
			
	</form>
</div>

        <div id="four"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Company</b></h2></center>
			<table align="center">
			<tr><td>Enter Company Name:</td><td><input type="text" name="cname"></td></tr>
			</table>
			<center><input type="submit" value="Add Company" name="id"></center>
			
	</form>
        </div>
        <div id="five"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Route</b></h2></center>
			<table align="center">
			<tr><td>Enter Distance:</td><td><input type="number" name="value"></td></tr>
			<tr><td>Enter From:</td><td><input type="text" name="from"></td></tr>
			<tr><td>Enter To:</td><td><input type="text" name="to"></td></tr>
			</table>
			<center><input type="submit" value="Add Route" name="id"></center>
	</form>
        </div>
        
        <div id="six"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add PromoCode</b></h2></center>
			<table align="center">
			<tr><td>Enter Code:</td><td><input type="text" name="code"></td></tr>
			<tr><td>Enter Value:</td><td><input type="number" name="value"></td></tr>
			</table>
			<center><input type="submit" value="Add Promocode" name="id"></center>
	</form>
        </div>
        <div id="seven" style="display:none">
	<form action="Admin" method="post">
	<center><h2><b>Update Seats</b></h2></center>
			<table align="center">
			<tr>
			<td>Enter Flight Details:</td><td> 
			
			<select id="vis" name="fid" required="cannot be empty">
  <option value="None">None</option>
    <% 
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	cs=con.createStatement();
        q="select flight.id,company.company,route.from_pl,route.to_pl,flight.start_time,flight.dest_time from airline.flight inner join airline.route on flight.route_id=route.id inner join airline.company on flight.company_id=company.id";
	rs=cs.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(1) %> : <%=rs.getString(2) %> ,  (<%=rs.getString(3) %> - <%=rs.getString(4) %>) , (<%=rs.getString(5) %> - <%=rs.getString(6) %>)  
	</option><%	
	}%>
  

    </select>			
			</td>
			</tr>
			<tr>
			<td>Enter day to be updated:</td>
			<td><select name="day" id="how">
				<option value="mon">Monday</option>
				<option value="tue">Tuesday</option>
				<option value="wed">Wednesday</option>
				<option value="thu">Thursday</option>
				<option value="fri">Friday</option>
				<option value="sat">Saturday</option>
				<option value="sun">Sunday</option>
			</select></td>
			</tr>
			<tr>
			<td>Enter Economy seats:</td><td><input type="number" name="seat1"></td></tr>
			<tr><td>Enter Business seats:</td><td><input type="number" name="seat2"></td>
			</tr>
                        </table>
                        <center><input type="submit" name="id" value="Update Seats"></center>
		</form>
          </div> 
        <div id="eight" style="display:none">
	<form action="Admin" method="post">
	<center><h2><b>Update Price</b></h2></center>
			<table align="center">
			<tr>
			<td>Enter Flight Details:</td><td> 
			
			<select id="vis" name="fid" required="cannot be empty">
  <option value="None">None</option>
    <% 
        Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
	cs=con.createStatement();
        q="select flight.id,company.company,route.from_pl,route.to_pl,flight.start_time,flight.dest_time from airline.flight inner join airline.route on flight.route_id=route.id inner join airline.company on flight.company_id=company.id";
	rs=cs.executeQuery(q);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(1) %> : <%=rs.getString(2) %> ,  (<%=rs.getString(3) %> - <%=rs.getString(4) %>) , (<%=rs.getString(5) %> - <%=rs.getString(6) %>)  
	</option><%	
	}%>
  

    </select>			
			</td>
			</tr>
			<tr>
			<td>Enter day to be updated:</td>
			<td><select name="day" id="how">
				<option value="mon">Monday</option>
				<option value="tue">Tuesday</option>
				<option value="wed">Wednesday</option>
				<option value="thu">Thursday</option>
				<option value="fri">Friday</option>
				<option value="sat">Saturday</option>
				<option value="sun">Sunday</option>
			</select></td>
			</tr>
			<tr>
			<td>Enter Economy price:</td><td><input type="number" name="price1"></td></tr>
			<tr><td>Enter Business price:</td><td><input type="number" name="price2"></td>
			</tr>
                        </table>
                        <center><input type="submit" name="id" value="Update Price"></center>
		</form>
          </div> 
    
     
    </body>    
</html>
