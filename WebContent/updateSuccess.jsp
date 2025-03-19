<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver"; %>
<%! String url = "jdbc:mysql://localhost:3306/ep"; %>
<%! String user = "root"; %>
<%! String psw = "monsterSQL123"; %>
<% 
String parcelID = request.getParameter("parcelID");
String staffID = request.getParameter("staffID"); 
String trackID = request.getParameter("trackID"); 
String courierName = request.getParameter("courierName"); 
String dateDelivered = request.getParameter("dateDelivered"); 
Double weight = Double.parseDouble(request.getParameter("weight")); 
String custName = request.getParameter("custName"); 
String custPhoneNum = request.getParameter("custPhoneNum"); 
String paymentStatus = request.getParameter("paymentStatus"); 

Connection con = null;
PreparedStatement ps =null;

	try{
		Class.forName(driverName);
		con = DriverManager.getConnection(url,user,psw);
		
		String sql = "UPDATE parcel SET staffID=?, trackID=?, courierName=?, dateDelivered=?, weight=?, custName=?, custPhoneNum=?, paymentStatus=? WHERE parcelID=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, staffID);
		ps.setString(2, trackID);
		ps.setString(3, courierName);
		ps.setString(4, dateDelivered);
		ps.setDouble(5, weight);
		ps.setString(6, custName);
		ps.setString(7, custPhoneNum);
		ps.setString(8, paymentStatus);
		ps.setString(9, parcelID); // Set the parcelID as the last parameter in the WHERE clause

		int i = ps.executeUpdate();
		if(i>0)
			out.print("Record Updated Successfully");
		else
			out.print("There is a problem in updating Record");
	}
	catch(SQLException ex) {
	    request.setAttribute("error", ex);
	    out.println(ex);
	}


%>