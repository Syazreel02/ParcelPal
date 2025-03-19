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
      ResultSet rs = stmt.executeQuery("SELECT staffID FROM staff");
      while (rs.next()) {
          String staffID = rs.getString("staffID");
       }
      rs.close();
      stmt.close();
      con.close();
   } catch (Exception e) {
      e.printStackTrace();
   }
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name = "viewport" content = "width = device-width, initial-scale = 1">
		
		<link rel = "stylesheet" href = "styleForAdd.css">
		<link rel = "stylesheet" href = "http://unicons.iconscout.com/release/v4.0.0/css/line.css">
		<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"> 
		
		<title>Add New Parcel's Information</title>
	</head>
<body>

<jsp:useBean id="staff" class="package1.staffBean"></jsp:useBean>
<div class = "container">
	<section class="sticky">
      	<a href="staff.html" class="logo"><i class='bx bxs-home'></i>ParcelPal</a>
      		<ul class="navlist">  
				<li><a href="Add.jsp" class="active">Add Parcel</a></li>
		        <li><a href="ManageParcel.jsp">Manage Parcel</a></li>
		        <li><a href="snr.html">Print Receipt</a></li>
		        <li><a href="#contact">Report</a></li>
		        <li><a href="#faq">Manage Account</a></li>
     		</ul> 
     		<div class="nav-icons"> 
			    <a href="#overlay"><i class='bx bx-log-out'></i>Logout</a>
			</div> 
    </section>	
	<div id="myModal" class="modal myModalFailure">
	  	<div class="modal-content">
		    <span class="close">&times;</span>
		    <h1>Insertion Failed!</h1>
	    	<p>Tracking ID already exist in database.</p>
	    	<p style="margin-bottom:20px">Please make sure that :</p>
	    	<ul>
	    		<li>Tracking ID must be unique</li>
	    	</ul>
	  	</div>
	</div>
	<div id="myModalSuccess" class="modal">
	  	<div class="modal-content">
		    <span class="close" id="closeBtnSuccess">&times;</span>
		    <h1>Insertion Successful!</h1>
	    	<p>The parcel has been added to the database.</p>
	    	<ul>
	    		<li>1. Parcel ID : <%= session.getAttribute("parcelID") %></li>
	    		<li>2. Staff ID : <%= session.getAttribute("staffID") %></li>
	    		<li>3. Tracking ID : <%= session.getAttribute("trackID") %></li>
	    		<li>4. Courier Name : <%= session.getAttribute("courierName") %></li>
	    		<li>5. Date Delivered : <%= session.getAttribute("deliveredDate") %></li>
	    		<li>6. Parcel's Weight : <%= session.getAttribute("weight") %></li>
	    		<li>7. Customer Name : <%= session.getAttribute("custName") %></li>
	    		<li>8. Customer Phone Number : <%= session.getAttribute("custPhoneNum") %></li>
	    		<li>9. Payment Status : <%= session.getAttribute("paymentStatus") %></li>
	    	</ul>
	  	</div>
	</div>
	
	<header>Add New Parcel's Information</header>
	
		<form action="addServlet" method="post">
			<div class = "form">
					<div class = "details">
						<span class = "title">Parcel's Details</span>
						
						<div class = "fields">
							<div class = "input-field">
								<label>Tracking ID : </label>
								<input type = "text" name = "TrackID" placeholder = "Enter the Tracking ID" maxlength="10" required>
							</div>
							
							<div class = "input-field">
								<label for = "cname">Courier Name :</label>
									<select id="cname" name="CourierName">
										<option value = "J&T">J&T</option>
										<option value = "POS LAJU">Pos Laju</option>
										<option value = "NINJAVAN">Ninjavan</option>
										<option value = "DHL">DHL</option>
										<option value = "PGEON">Pgeon</option>
										<option value = "GDEX">Gdex</option>
										<option value = "CITYLINK">Citylink</option>
										<option value = "LALAMOVE">Lalamove</option>
									</select>
							</div>
							
							<div class = "input-field">
								<label>Date Delivered : </label>
								<input type = "date" name = "Date" placeholder = "Select the date delivered" required>
							</div>
							
							<div class = "input-field">
								<label>Parcel's Weight (Kg): </label>
								<input type="text" name="Weight" placeholder="Enter the parcel's weight (eg. from 0.01 - 99.99)" required pattern="^(?!0(\.00?)?$)(?:\d{1,2}(?:\.\d{1,2})?|99(?:\.00?)?)$" title="Please enter a valid number (eg. from 0.01 - 99.99)">
							</div>
							
						</div>
					</div>
					
					<div class = "details2">
						<span class = "title">Customer's Details</span>
						
						<div class = "fields">
							<div class = "input-field">
								<label>Cutomer's Full Name : </label>
								<input type = "text" name="CustName" placeholder = "Enter the customer's full name" maxlength="30" required>
							</div>
							
							<div class = "input-field">
								<label>Customer's Phone Number : </label>
								<input type="text" name="CustPhone" placeholder="Enter the customer's phone number" maxlength="11" required pattern="^0[0-9]{9,10}$" title="Please enter a valid 10 or 11-digit phone number">
							</div>
							
							<div class = "input-field">
								<label for = "payment">Payment Status :</label>
									<select id="payment" name="Status" required>
										<option value = "UNPAID">Unpaid</option>
										<option value = "PAID">Paid</option>
									</select>
							</div>
						</div>
					</div>
					
					<div class = "details2">
						<span class = "title">Staff's Details</span>
						
						<div class = "fields">
							<div class = "input-field">
								<label for = "staffID">Staff's ID :</label>
									<select id="staffID" name="StaffID" required>
										<%
									        List<String> staffIDs = staff.getStaffIDs();
									        for (String staffID : staffIDs) {
									    %>
									        <option value="<%= staffID %>"><%= staffID %></option>
									    <%
									        }
									    %>
									</select>
							</div>
						</div>
						
						<div class="button-container">
  							<button class="submit-btn" name="Add Parcel" type="submit">
    							<span class="btnText">Submit</span>
    							<i class="uil uil-navigator"></i>
  							</button>
  							<button class="reset-btn" name="Clear Form" type="reset">
    							Reset
    							<i class="bx bx-reset"></i>
  							</button>
						</div>
					</div>
				</div>
		</form>
</div>
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
	<script>
	    // Get the value of the insertionFailed attribute from the query parameter
	    var urlParams = new URLSearchParams(window.location.search);
	    var insertionFailed = urlParams.get('insertionFailed');
	  
	    // Get the modal
	    var modal = document.getElementById("myModal");
	  
	    // Show the modal if the insertion failed
	    if (insertionFailed) {
	      modal.style.display = "block";
	    }
	  
	    // Get the close button (x)
	    var closeBtn = document.getElementsByClassName("close")[0];
	  
	    // Close the modal when the close button (x) is clicked
	    closeBtn.onclick = function() {
	      modal.style.display = "none";
	    };
	  
	    // Close the modal when the user clicks outside the modal
	    window.onclick = function(event) {
	      if (event.target == modal) {
	        modal.style.display = "none";
	      }
	    };
 	</script>
  	<script>
	    // Get the value of the insertionSuccess attribute from the query parameter
	    var urlParams = new URLSearchParams(window.location.search);
	    var insertionSuccess = urlParams.get('insertionSuccess');
	    
	    // Get the modal for successful insertion
	    var modalSuccess = document.getElementById("myModalSuccess");
	    
	    // Show the modal if the insertion was successful
	    if (insertionSuccess) {
	      modalSuccess.style.display = "block";
	    }
	    
	    // Get the close button (x) for successful modal
	    var closeBtnSuccess = document.getElementById("closeBtnSuccess");
	    
	    // Close the modal when the close button (x) for successful modal is clicked
	    closeBtnSuccess.onclick = function() {
	      modalSuccess.style.display = "none";
	    };
	    
	    // Close the modal when the user clicks outside the successful modal
	    window.onclick = function(event) {
	      if (event.target == modalSuccess) {
	        modalSuccess.style.display = "none";
	      }
	    };
	</script>
</body>
</html>