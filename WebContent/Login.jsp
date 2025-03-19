<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<meta name = "viewport" content = "width = device-width, initial-scale = 1"> 
<title>Staff Login</title>
	<link href='styleForLogin.css' rel='stylesheet'>
	<!-- box icons --> 
 	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"> 
 	<link rel="preconnect" href="https://fonts.googleapis.com"> 
 	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
 	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 
</head>
<body>
	<header class = "sticky">
  		<a href = "#home" class = logo><i class = 'bx bxs-home'></i>ParcelPal</a>
   
  		<ul class = "navlist"> 
   			<li><a href = "welcome.html">Home</a></li> 
   			<li><a href="welcome.html#about">About Us</a></li>
   			<li><a href="welcome.html#organization">Organization</a></li>
   			<li><a href = "welcome.html#faq">FAQs</a></li> 
   			<li><a href = "welcome.html#contact">Contact Us</a></li> 
 		</ul> 
   
		<div class = "nav-icons"> 
   			<a href = "welcome.html"><i class='bx bx-log-in-circle' ></i></a>
 		</div> 
 	</header>
 	
	<div class="actbody">
	<div class="box <%= session.getAttribute("invalid") == null ? "" : "invalid" %>">
		<div class="form-box login">
			<h2>Staff Login</h2>
			<form action="loginServlet" method="post">
				<div class="input-box">
					<span class="icon"><ion-icon name="person-circle-outline"></ion-icon></ion-icon>
					</span>
					<input type="text" name="userID" id="myInputA" maxlength="10" required>
					<label>Staff ID</label>
				</div>
				<div class="input-box">
					<span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
					<input type="password" name="pwd" id="myInputB" maxlength="20" required>
					<label>Password</label>
				</div>
				<div class="remember-forgot">
					<label><input type="checkbox">
					Remember me</label>
					<a href="#">Forgot Password?</a>
				</div>
				<button type="submit" class="btn">Login</button>
				<div class="login-register">
					<p>Don't have an account? 
						<a href="#" class="register-link" onclick="document.getElementById('myInputA').value = '', document.getElementById('myInputB').value = ''"">Register</a>
					</p>
				</div>
			</form>
			<div class="error-message" <%= session.getAttribute("invalid") == null ? "style=\"display: none;\"" : "" %>>
                Invalid credentials. Please try again.
            </div>
		</div>
		
		<div class="form-box register">
			<h2>Registration</h2>
			<form action="registerServlet" method="post">
				<div class="input-box">
					<span class="icon"><ion-icon name="happy-outline"></ion-icon></ion-icon>
					</span>
					<input name="StaffName" type="text" id="myInput1" minlength="4" maxlength="50" required>
					<label>Name</label>
				</div>
				<div class="input-box">
					<span class="icon"><ion-icon name="mail-outline"></ion-icon></ion-icon>
					</span>
					<input name="StaffEmail" type="email" id="myInput2" maxlength="20" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}">
					<label>Email</label>
				</div>
				<div class="input-box">
					<span class="icon"><ion-icon name="call-outline"></ion-icon></span>
					<input name="StaffPhoneNum" type="text" id="myInput3" maxlength="11" required pattern="^0[0-9]{9,10}$" title="Please enter a valid 10 or 11-digit phone number">
					<label>Phone Number</label>
				</div>
				<div class = "register-table">
					<table style= "width:100%">
						<tr>
							<td style= "width:50%">Password: </td>
							<td><input name="StaffPassword" type="password" id="myInput5" minlength="8" maxlength="20" required></td>
						</tr>
						<tr>
							<td style= "width:50%">Re-enter Password: </td>
							<td><input name="StaffCheckPassword" type="password" id="myInput6" minlength="8" maxlength="20" required></td>
						</tr>					
					</table>
				</div>
				<div class="remember-forgot">
					<label><input type="checkbox" id="myInput7">
					I agree to the terms & conditions</label>
				</div>
				<button type="submit" class="btn">Sign Up</button>
				<div class="login-register">
					<p>Already have an account? 
						<a href="#" class="login-link" onclick="document.getElementById('myInput1').value = '', document.getElementById('myInput2').value = '', document.getElementById('myInput3').value = '', document.getElementById('myInput5').value = '', document.getElementById('myInput6').value = '', document.getElementById('myInput7').on">Login</a>
					</p>
				</div>
			</form>
		</div>
	</div>
	</div>
	<script src="script.js"></script>
	<script>
	const header = document.querySelector("header");

	// Smooth scrolling for internal page links
	document.querySelectorAll('a[href^="#"]').forEach(anchor => {
	  anchor.addEventListener("click", function (e) {
	    e.preventDefault();

	    const target = document.querySelector(this.getAttribute("href"));
	    if (target) {
	      target.scrollIntoView({
	        behavior: "smooth"
	      });
	    }
	  });
	});

	window.addEventListener("scroll", function() {
	  header.classList.toggle("sticky", window.scrollY > 80);
	});

	const sr = ScrollReveal({
	  origin : 'top',
	  distance : '85px',
	  duration : 2500,
	  reset : true
	})
	</script>
	<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>