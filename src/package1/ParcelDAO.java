package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParcelDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ep";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "monsterSQL123";

	public int generateParcelID() throws ClassNotFoundException, SQLException {
		String parcelID = null;
		int max = 0;
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    Statement stmt = con.createStatement();
	    String sql = "select parcelID, trackID from parcel";
	    ResultSet rs = stmt.executeQuery(sql);
	    while (rs.next()) {
	    	parcelID = rs.getString("parcelID");
	        if (max < Integer.parseInt(parcelID.substring(1)))
	        	max = Integer.parseInt(parcelID.substring(1));
	        }
	    stmt.close();
	    con.close();
	    return max;
	}
	
	public int addParcel(parcelBean parcel) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		PreparedStatement ps = con.prepareStatement("INSERT INTO parcel VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, parcel.getParcelID());
        ps.setString(2, parcel.getStaffID());
        ps.setString(3, parcel.getTrackID());
        ps.setString(4, parcel.getCourierName());
        ps.setString(5, parcel.getDateDelivered());
        ps.setDouble(6, parcel.getWeight());
        ps.setString(7, parcel.getCustName());
        ps.setString(8, parcel.getCustPhoneNum());
        ps.setString(9, parcel.getStatus());
        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();
        return rowsAffected;
	}
	
	public void parcelPaid(String parcelID) throws ClassNotFoundException, SQLException {
		String status ="PAID";
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String sql = "UPDATE parcel SET paymentStatus=? WHERE parcelID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, status);
		ps.setString(2, parcelID);
		ps.executeUpdate();
		ps.close();
	}
	
	public boolean checkParcel(String pID) throws ClassNotFoundException, SQLException {
		boolean check=false;
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM parcel WHERE parcelID = ?");
        ps.setString(1, pID);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            check = true;
        }

        rs.close();
        ps.close();
	    return check;
	}
	
	public void trackParcel(parcelBean parcel) throws ClassNotFoundException, SQLException {
		boolean check = false;
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM parcel WHERE trackID = ?");
	    ps.setString(1, parcel.getTrackID());
	    ResultSet rs = ps.executeQuery(); 
	    
	    while(rs.next()) {
	       check = true;
	 	   parcel.setParcelID(rs.getString("parcelID")); 
	 	   parcel.setStaffID(rs.getString("staffID")); 
	 	   parcel.setTrackID(rs.getString("trackID")); 
	 	   parcel.setCourierName(rs.getString("courierName")); 
	 	   parcel.setDateDelivered(rs.getString("dateDelivered")); 
	 	   parcel.setWeight(rs.getDouble("weight")); 
	 	   parcel.setCustName(rs.getString("custName")); 
	 	   parcel.setCustPhoneNum(rs.getString("custPhonenum")); 
	 	   parcel.setStatus(rs.getString("paymentStatus")); 
	    } 
	    
	    if(check==false)
	    {
	    	parcel.setTrackID(null);
	    }
	}
}