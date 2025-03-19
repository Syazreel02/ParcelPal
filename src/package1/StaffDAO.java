package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ep";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "monsterSQL123";
    
	public int addStaff(staffBean staff) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		PreparedStatement ps = con.prepareStatement("INSERT INTO staff VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, staff.getStaffID());
        ps.setString(2, staff.getStaffName());
        ps.setString(3, staff.getStaffPhoneNum());
        ps.setString(4, staff.getStaffEmail());
        ps.setString(5, staff.getStaffPass());
        
        int rowsAffected = ps.executeUpdate();
        ps.close();
		return rowsAffected;
	}
	
	public void loginStaff(staffBean staff) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		Statement stmt = con.createStatement(); 
		String sql = "SELECT staffID, staffPass FROM ep.staff where staffID='"+staff.getStaffID()+"'"; 
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) { 
			staff.setStaffID(rs.getString("staffID"));
			staff.setStaffPass(rs.getString("staffPass"));
		}
	}
	
	public int[] registerStaff(staffBean staff1, staffBean staff2) throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    int max = 0;
	    int t1 = 0;
	    int t2 = 0;
	    int t3 = 0;

	    Statement stmt = con.createStatement();
	    String sql = "SELECT * FROM staff";
	    ResultSet rs = stmt.executeQuery(sql);

	    while (rs.next()) {
	        staff1.setStaffID(rs.getString("staffID"));

	        if (max < Integer.parseInt(staff1.getStaffID().substring(6))) {
	            max = Integer.parseInt(staff1.getStaffID().substring(6));
	        }

	        staff1.setStaffName(rs.getString("staffName"));
	        staff1.setStaffPhoneNum(rs.getString("staffPhoneNum"));
	        staff1.setStaffEmail(rs.getString("staffEmail"));
	        staff1.setStaffPass(rs.getString("staffPass"));

	        if (staff2.getStaffName().equals(staff1.getStaffName())) {
	            t1 = 1;
	        }
	        if (staff2.getStaffPhoneNum().equals(staff1.getStaffPhoneNum())) {
	            t2 = 1;
	        }
	        if (staff2.getStaffEmail().equals(staff1.getStaffEmail())) {
	            t3 = 1;
	        }
	    }

	    rs.close();
	    stmt.close();
	    con.close();

	    int[] result = {max, t1, t2, t3};
	    return result;
	}

}
