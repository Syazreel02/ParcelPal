<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%
   // Java code to connect to the database and perform database operations
   
   try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM parcel");
      while (rs.next()) {
    	  	String parcelID = rs.getString("parcelID"); 
    	    String staffID = rs.getString("staffID"); 
    	    String trackID = rs.getString("trackID"); 
    	    String courierName = rs.getString("courierName"); 
    	    String dateDelivered = rs.getString("dateDelivered"); 
    	    Double weight = rs.getDouble("weight"); 
    	    String custName = rs.getString("custName"); 
    	    String custPhoneNum = rs.getString("custPhoneNum"); 
    	    String paymentStatus = rs.getString("paymentStatus"); 
       }
      rs.close();
      stmt.close();
      con.close();
   } catch (Exception e) {
      e.printStackTrace();
   }
%>
<!DOCTYPE html = "en">
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name = "viewport" content = "width = device-width, initial-scale = 1">
	<title>Manage Parcel Page!</title>
	
	<link rel = "stylesheet" href = "manage.css">
	<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
	<link rel = "stylesheet" href = "http://unicons.iconscout.com/release/v4.0.0/css/line.css">
	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"> 
</head>
<body>
<jsp:useBean id="parcel" class="package1.parcelBean"></jsp:useBean>
	<navi1 class="sticky">
      			<a href="staff.html" class="logo"><i class='bx bxs-home'></i>ParcelPal</a>
      				<ul class="navlist">  
				        <li><a href="Add.jsp">Add Parcel</a></li>
				        <li><a href="ManageParcel.jsp" class="active">Manage Parcel</a></li>
				        <li><a href="snr.html">Print Receipt</a></li>
				        <li><a href="#contact">Report</a></li>
				        <li><a href="#faq">Manage Account</a></li>
     				</ul> 
			      <div class="nav-icons"> 
			<a href="#overlay"><i class='bx bx-log-out'></i>Logout</a>
		</div> 
    </navi1>
	
	<form method="post" action="manageParcelServlet">
		<div class="search-container">
		  		<label for="trackID"><h1>Enter Track ID :</h1></label>
		  		<input name = "trackID" type="text" id="track-id" placeholder="Enter Track ID...">
		  		<button type="submit">Search</button>
		</div>
	</form>
	
	<main class = "table">
		<section class = "table_header">
			<h1>Manage Parcel Details</h1>	
		</section>
		<section class = "table_body">
			<table>
				<thead>
					<tr>
						<th>Parcel ID</th>
						<th>Staff ID</th>
						<th>Track ID</th>
						<th>Courier Name</th>
						<th>Date Delivered</th>
						<th>Weight (Kg)</th>
						<th>Customer's Name</th>
						<th>Customer's Phone Number</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<%
					List<String> parcelIDs = parcel.getParcelIDs();
		        	List<String> staffIDs = parcel.getStaffIDs();
		        	List<String> trackIDs = parcel.getTrackIDs();
		        	List<String> courierNames = parcel.getCourierNames();
		        	List<String> dateDelivereds = parcel.getDateDelivereds();
		        	List<String> weights = parcel.getWeights();
		        	List<String> custNames = parcel.getCustNames();
		        	List<String> custPhoneNums = parcel.getCustPhoneNums();
		        	List<String> paymentStatuss = parcel.getPaymentStatuss();
		        	int loopSize = parcelIDs.size();

		            for (int i = 0; i < loopSize; i++) {
		                String parcelID = parcelIDs.get(i);
		                String staffID = staffIDs.get(i);
		                String trackID = trackIDs.get(i);
		                String courierName = courierNames.get(i);
		                String dateDelivered = dateDelivereds.get(i);
		                String weight = weights.get(i);
		                String custName = custNames.get(i);
		                String custPhoneNum = custPhoneNums.get(i);
		                String paymentStatus = paymentStatuss.get(i);
        		%>
				<tbody>
					<tr>
						<td><%= parcelID %></td>
	            		<td><%= staffID %></td>
	           			<td><%= trackID %></td>
	            		<td><%= courierName %></td>
			            <td><%= dateDelivered %></td>
			            <td><%= weight %></td>
			            <td><%= custName %></td>
			            <td><%= custPhoneNum %></td>
			     <% 
			     			if(paymentStatus.equalsIgnoreCase("PAID")){
			     %>
						<td>
							<p class = "status paid"><strong><%= paymentStatus %></strong>
						</td>
				 <%
			     			}
							else{
				 %>
						<td>
							<p class = "status unpaid"><strong><%= paymentStatus %></strong>
						</td>
				<%
		            		}
				%>	
						<td>
							<form action="editParcelServlet" method="post">
								<input type="hidden" name="trackID" value="<%= trackID %>">
								<button><i class="fa-solid fa-pen-to-square" aria-hidden="true"></i></button>
							</form>
							
							<form action="deleteParcelServlet" method="post">
								<input type="hidden" name="trackID" value="<%= trackID %>">
								<button><i class="fa fa-trash" aria-hidden="true"></i></button>
							</form>
						</td>
					</tr>
				</tbody>
				<%
					 }
		             if(loopSize==0){
				%>	
				<tbody>	
				<tr>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>-</td>
			        <td>None</td>
			    </tr>
			    </tbody>
			    
			    <%
		             }
			    %>
				</table>
		</section>
	</main>
	<div class="overlay" id="logout-overlay">
		<div class="popup">
			<h2>Are you sure you want to logout?</h2>
		    <div class="btn-group">
		    	<button class="btn cancel-btn" onclick="cancelLogout()">Cancel</button>
		        <button class="btn logout-confirm-btn" onclick="confirmLogout()">Logout</button>
		   	</div>
		</div>
	</div>
		
	<div class="logout-success-overlay" id="logout-success-overlay">
		<div class="logout-success-popup">
			<h2>You have successfully logged out!</h2>
		    <p id="countdown">Redirecting to the homepage in 3 seconds...</p>
		</div>
	</div>
			
	<script src="https://unpkg.com/scrollreveal@4.1.0/dist/scrollreveal.min.js"></script>
	<script src = "test6.js"></script>
</body>
</html>
    