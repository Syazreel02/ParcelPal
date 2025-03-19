<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="styleForCT.css">
  <link rel="stylesheet" href="http://unicons.iconscout.com/release/v4.0.0/css/line.css">
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"> 
  
  <title>Customer's Tracking Parcel Page</title>
</head>
<body>
<header class = "sticky">
  	<a href = "welcome.html" class = logo><i class = 'bx bxs-home'></i>ParcelPal</a>
   
  	<ul class = "navlist"> 
   		<li><a href = "welcome.html" class = "active">Home</a></li> 
   		<li><a href="welcome.html#about">About Us</a></li>
   		<li><a href="welcome.html#organization">Organization</a></li>
   		<li><a href = "welcome.html#faq">FAQs</a></li> 
   		<li><a href = "welcome.html#contact">Contact Us</a></li> 
  	</ul> 
   
  	<div class = "nav-icons"> 
   		<a href = "Login.jsp"><i class='bx bx-log-in'></i>Login</a>
  	</div> 
</header>

	<div class="container">
    <div class="text">
      <h1>Track Your Parcel Here!</h1>
      <p>Enter Your Tracking ID</p>
    </div>
    
    <div class="search-bar">
      <form action = "CustomerTracking" method = "post">
        <input type="text" name="tID" placeholder="Search your tracking ID" required>
        <button type="submit"><i class='bx bx-search-alt-2'></i></button>
      </form>
    </div>
  </div>
  
	<script src = "https://unpkg.com/scrollreveal"></script>
	 
		 <!-- link to js --> 
		 <script src = "test5.js"></script>
</body>
</html>