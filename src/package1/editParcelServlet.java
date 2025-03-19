package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editParcelServlet
 */
@WebServlet("/editParcelServlet")
public class editParcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editParcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		   
		String tID = request.getParameter("trackID");
		String parcelID=null; 
		String staffID=null;
		String trackID=null; 
		String courierName=null;
		String[] courier = {"J&T", "POS LAJU", "NINJAVAN", "DHL", "PGEON", "GDEX", "CITYLINK", "LALAMOVE"};
		String dateDelivered=null; 
		Double weight=null; 
		String custName=null; 
		String custPhoneNum=null; 
		String paymentStatus=null;
		int i=0, j=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123"); 
			    
				Statement stmt = con.createStatement(); 
				String sql = "select * from parcel where trackID ='"+tID+"'"; 
				ResultSet rs = stmt.executeQuery(sql); 
			    
				while(rs.next()) { 
					parcelID = rs.getString("parcelID"); 
					staffID = rs.getString("staffID"); 
					trackID = rs.getString("trackID"); 
					courierName = rs.getString("courierName"); 
					dateDelivered = rs.getString("dateDelivered"); 
					weight = rs.getDouble("weight"); 
					custName = rs.getString("custName"); 
					custPhoneNum = rs.getString("custPhoneNum"); 
					paymentStatus = rs.getString("paymentStatus"); 
				} 
				if(tID.equals(trackID)) {
					sql = "select staffID from staff order by staffID"; 
					ResultSet rs2 = stmt.executeQuery(sql);
					while(rs2.next()) {  
						i++;
					}
					String staffIDs[]=new String[i];
					ResultSet rs3 = stmt.executeQuery(sql);
					while(rs3.next()) { 
						staffIDs[j]=rs3.getString("staffID");
						j++;
					}
					
					out.println("<html>");
					out.println("<head>");
					out.println("<meta charset='UTF-8'>");
					out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
					out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
					out.println("<link rel='stylesheet' href='displayUpdate.css'>");
					out.println("<link rel='stylesheet' href='http://unicons.iconscout.com/release/v4.0.0/css/line.css'>");
					out.println("<link rel='stylesheet' href='https://unpkg.com/boxicons@latest/css/boxicons.min.css'>");
					out.println("<title>Display For Update Page</title>");
					out.println("</head>");
					out.println("<body>");

					out.println("<div class='container'>");
					out.println("<section class='sticky'>");
					out.println("<a href='staff.html' class='logo'><i class='bx bxs-home'></i>ParcelPal</a>");
					out.println("<ul class='navlist'>");
					out.println("<li><a href='Add.jsp'>Add Parcel</a></li>");
					out.println("<li><a href='ManageParcel.jsp' class='active'>Manage Parcel</a></li>");
					out.println("<li><a href='snr.html'>Print Receipt</a></li>");
					out.println("<li><a href='#contact'>Report</a></li>");
					out.println("<li><a href='#faq'>Manage Account</a></li>");
					out.println("</ul>");
					out.println("<div class='nav-icons'>");
					out.println("<a href='#overlay'><i class='bx bx-log-out'></i>Logout</a>");
					out.println("</div>");
					out.println("</section>");

					out.println("<header>Display The Data For Update Process</header>");

					out.println("<form action='updateSuccess.jsp' class='reveal-form'>");
					out.println("<div class='form'>");
					out.println("<div class='details'>");
					out.println("<span class='title'>Parcel's Details</span>");

					out.println("<div class='fields'>");
					out.println("<div class='input-field'>");
					out.println("<label>Parcel ID:</label>");
					out.println("<p>"+ parcelID +"</p>");
					out.println("<input type='hidden' name='parcelID' value='"+ parcelID +"'>");
					out.println("</div>");

					out.println("<div class='input-field'>");
					out.println("<label for='cname'>Courier Name :</label>");
					out.println("<select id='cname' name='courierName'>");
					for (int a = 0; a < 8; a++) {
						if (courierName.equalsIgnoreCase(courier[a]))
							out.println("<option value='" + courier[a] + "' selected>" + courier[a] + "</option>");
						else
							out.println("<option value='" + courier[a] + "'>" + courier[a] + "</option>");
					}
					out.println("</select>");
					out.println("</div>");

					out.println("<div class='input-field'>");
					out.println("<label>Date Delivered :</label>");
					out.println("<input type='date' name='dateDelivered' value='" + dateDelivered + "' placeholder='Select the date delivered' required>");
					out.println("</div>");

					out.println("<div class='input-field'>");
					out.println("<label>Parcel's Weight (Kg):</label>");
					out.println("<input type='text' name='weight' value='" + weight + "' placeholder='Enter the parcel's weight' required pattern='^\\d{1,3}(\\.\\d{1,2})?$' title='Please enter a valid number (eg. from 0 - 999.99)'>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");

					out.println("<div class='details2'>");
					out.println("<span class='title'>Customer's Details</span>");

					out.println("<div class='fields'>");
					out.println("<div class='input-field'>");
					out.println("<label>Customer's Full Name :</label>");
					out.println("<input type='text' name='custName' value='" + custName + "' maxlength='30' minlength='5' placeholder='Enter the customer's full name' required>");
					out.println("</div>");

					out.println("<div class='input-field'>");
					out.println("<label>Customer's Phone Number :</label>");
					out.println("<input type='text' name='custPhoneNum' value='" + custPhoneNum + "' maxlength='11' required pattern='[0-9]{10-11}' placeholder='Enter the customer's phone number'>");
					out.println("</div>");

					out.println("<div class='input-field'>");
					out.println("<label for='payment'>Payment Status :</label>");
					out.println("<select id='payment' name='paymentStatus' required>");
					if(paymentStatus.equalsIgnoreCase("PAID")) {
						out.println("<option value='PAID' selected>PAID");
						out.println("<option value='UNPAID'>UNPAID");
					}
					else {
						out.println("<option value='PAID'>PAID");
						out.println("<option value='UNPAID' selected>UNPAID");
					}
					out.println("</select>");
					out.println("</div>");

					out.println("<div class='input-field'>");
					out.println("<label>Track ID :</label>");
					out.println("<input type='text' name='trackID' value='" + trackID + "' maxlength='10' placeholder='Enter the tracking ID' required>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");

					out.println("<div class='details2'>");
					out.println("<span class='title'>Staff's Details</span>");

					out.println("<div class='fields'>");
					out.println("<div class='input-field'>");
					out.println("<label for='staffID'>Staff's ID :</label>");
					out.println("<select id='staffID' name='staffID'>");
					for (int a = 0; a < i; a++) {
						if (staffID.equalsIgnoreCase(staffIDs[a])) {
						    out.println("<option value='" + staffIDs[a] + "' selected>" + staffIDs[a] + "</option>");
						} else {
						    out.println("<option value='" + staffIDs[a] + "'>" + staffIDs[a] + "</option>");
						}
					}
					out.println("</select>");
					out.println("</div>");
					out.println("</div>");

					out.println("<div class='button-container'>");
					out.println("<button class='submit-btn' type='submit' name='update'>");
					out.println("<span class='btnText'>Update</span>");
					out.println("<i class='bx bxl-upwork'></i>");
					out.println("</button>");
					out.println("<button class='reset-btn' type='reset'>");
					out.println("Reset");
					out.println("<i class='bx bx-reset'></i>");
					out.println("</button>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
					out.println("</form>");
					out.println("</div>");

					out.println("<div class='overlay' id='logout-overlay'>");
					out.println("<div class='popup'>");
					out.println("<h2>Are you sure you want to logout?</h2>");
					out.println("<div class='btn-group'>");
					out.println("<button class='btn cancel-btn' onclick='cancelLogout()'>Cancel</button>");
					out.println("<button class='btn logout-confirm-btn' onclick='confirmLogout()'>Logout</button>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");

					out.println("<div class='logout-success-overlay' id='logout-success-overlay'>");
					out.println("<div class='logout-success-popup'>");
					out.println("<h2>You have successfully logged out!</h2>");
					out.println("<p id='countdown'>Redirecting to the homepage in 3 seconds...</p>");
					out.println("</div>");
					out.println("</div>");

					out.println("<script src='https://unpkg.com/scrollreveal@4.1.0/dist/scrollreveal.min.js'></script>");
					out.println("<script src='test6.js'></script>");
					out.println("</body>");
					out.println("</html>");
				}
				else {
					out.println("<html>");
					out.println("<head>");
					out.println("<meta charset=\"UTF-8\">");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
					out.println("<title>Tracking ID Not Found</title>");
					out.println("<style>");
					out.println("body {");
					out.println("  font-family: Arial, sans-serif;");
					out.println("  background-color: #f7f7f7;");
					out.println("  margin: 0;");
					out.println("  padding: 0;");
					out.println("  display: flex;");
					out.println("  justify-content: center;");
					out.println("  align-items: center;");
					out.println("  height: 100vh;");
					out.println("}");
					out.println(".container {");
					out.println("  text-align: center;");
					out.println("  padding: 30px;");
					out.println("  border-radius: 8px;");
					out.println("  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);");
					out.println("  background-color: #ffffff;");
					out.println("}");
					out.println("h1 {");
					out.println("  font-size: 28px;");
					out.println("  margin-bottom: 15px;");
					out.println("  color: #444444;");
					out.println("}");
					out.println("p {");
					out.println("  font-size: 18px;");
					out.println("  margin-bottom: 30px;");
					out.println("  color: #666666;");
					out.println("}");
					out.println(".btn {");
					out.println("  padding: 10px 20px;");
					out.println("  font-size: 16px;");
					out.println("  text-transform: uppercase;");
					out.println("  border: none;");
					out.println("  border-radius: 4px;");
					out.println("  background-color: #007bff;");
					out.println("  color: #ffffff;");
					out.println("  cursor: pointer;");
					out.println("  transition: background-color 0.3s ease;");
					out.println("}");
					out.println(".btn:hover {");
					out.println("  background-color: #0056b3;");
					out.println("}");
					out.println("</style>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div class=\"container\">");
					out.println("<h1>Tracking ID Not Found</h1>");
					out.println("<p>We're sorry, but the tracking ID you entered was not found.</p>");
					out.println("<button class=\"btn\" onclick=\"goBack()\">Go Back</button>");
					out.println("</div>");
					out.println("<script>");
					out.println("function goBack() {");
					out.println("  window.location.href = \"ManageParcel.jsp\";");
					out.println("}");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				}
		}
		catch (Exception e2) { 
			System.out.println(e2); 
		}
		out.close();
	}

}
