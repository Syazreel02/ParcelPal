<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="styleForReceipt.css">
  <link rel="stylesheet" href="http://unicons.iconscout.com/release/v4.0.0/css/line.css">
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"> 
  
  <title>Customer's Tracking Parcel Page</title>
</head>
<body>
  
  <header class = "sticky">
  <a href = "staff.html" class = logo><i class = 'bx bxs-home'></i>ParcelPal</a>
   
  <ul class = "navlist">  
   <li><a href="Add.jsp">Add Parcel</a></li>
   <li><a href="#organization">Manage Parcel</a></li>
   <li><a href = "snr.html" class="active" >Print Receipt</a></li>
   <li><a href = "#contact">Report</a></li>
   <li><a href = "#faq">Manage Account</a></li>
  </ul> 
   
  <div class = "nav-icons"> 
   <a href = "#overlay"><i class='bx bx-log-out' ></i>Logout</a>
  </div> 
 </header>
  
  <div class="container">
    <div class="text">
      <h1>Print The Receipt!</h1>
      <p>Enter The Following Parcel ID :</p>
    </div>
    
    <div class="search-bar">
      <form action = "DisplayReceipt" method = "post">
        <input type="text" name = "pID" placeholder="Search the parcel ID" maxlength="10">
        <button type="submit"><i class='bx bx-search-alt-2'></i></button>
      </form>
    </div>
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
	 	
		<script src = "https://unpkg.com/scrollreveal"></script>
	 
		 <!-- link to js --> 
		 <script src = "test5.js"></script>
	
</body>
</html>
