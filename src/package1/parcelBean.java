package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class parcelBean {
	private String parcelID;
    private String trackID;
    private String courierName;
    private String dateDelivered;
    private double weight;
    private String custName;
    private String custPhoneNum;
    private String status;
    private String staffID;
	
	
	public parcelBean() {}
	public parcelBean(String parcelID, String trackID, String dateDelivered, String courierName, double weight, String custName, String custPhoneNum, String status, String staffID) {
		this.parcelID = parcelID;
		this.trackID = trackID;
		this.courierName = courierName;
		this.dateDelivered = dateDelivered;
		this.weight = weight;
		this.custName = custName;
		this.custPhoneNum = custPhoneNum;
		this.status = status;
		this.staffID = staffID;
	}
    
    // Getters and setters

	public String getParcelID() {return parcelID;}
    
    public void setParcelID(String parcelID) {this.parcelID = parcelID;}

    public String getTrackID() {return trackID;}

    public void setTrackID(String trackID) {this.trackID = trackID;}

    public String getCourierName() {return courierName;}

    public void setCourierName(String courierName) {this.courierName = courierName;}

    public String getDateDelivered() {return dateDelivered;}

    public void setDateDelivered(String dateDelivered) {this.dateDelivered = dateDelivered;}

    public double getWeight() {return weight;}

    public void setWeight(double weight) {this.weight = weight;}

    public String getCustName() {return custName;}

    public void setCustName(String custName) {this.custName = custName;}

    public String getCustPhoneNum() {return custPhoneNum;}

    public void setCustPhoneNum(String custPhoneNum) {this.custPhoneNum = custPhoneNum;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getStaffID() {return staffID;}

    public void setStaffID(String staffID) {this.staffID = staffID;}
    
    public List<String> getParcelIDs() {
        List<String> parcelIDs = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT parcelID FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                parcelIDs.add(rs.getString("parcelID"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parcelIDs;
    }
    
    public List<String> getStaffIDs() {
        List<String> staffIDs = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT staffID FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                staffIDs.add(rs.getString("staffID"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return staffIDs;
    }
    
    public List<String> getTrackIDs() {
        List<String> trackIDs = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT trackID FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                trackIDs.add(rs.getString("trackID"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trackIDs;
    }
    
    public List<String> getCourierNames() {
        List<String> courierNames = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT courierName FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                courierNames.add(rs.getString("courierName"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courierNames;
    }
    
    public List<String> getDateDelivereds() {
        List<String> dateDelivereds = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT dateDelivered FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                dateDelivereds.add(rs.getString("dateDelivered"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateDelivereds;
    }
    
    public List<String> getWeights() {
        List<String> weights = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT weight FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                weights.add(rs.getString("weight"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weights;
    }
    
    public List<String> getCustNames() {
        List<String> custNames = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT custName FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                custNames.add(rs.getString("custName"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return custNames;
    }
    
    public List<String> getCustPhoneNums() {
        List<String> custPhoneNums = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT custPhonenum FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                custPhoneNums.add(rs.getString("custPhonenum"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return custPhoneNums;
    }
    
    public List<String> getPaymentStatuss() {
        List<String> paymentStatuss = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT paymentStatus FROM parcel ORDER BY CAST(SUBSTRING(parcelID, 2) AS SIGNED)");
            while (rs.next()) {
                paymentStatuss.add(rs.getString("paymentStatus"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paymentStatuss;
    }
}
