package package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class staffBean {
	private String staffID = null;
	private String staffName = null;
	private String staffPhoneNum = null;
	private String staffEmail = null;
	private String staffPass = null;
	
	public staffBean() {}
	public staffBean(String staffID, String staffName, String staffPhoneNum, String staffEmail, String staffPass) {
		this.staffID = staffID;
		this.staffName = staffName;
		this.staffPhoneNum = staffPhoneNum;
		this.staffEmail = staffEmail;
		this.staffPass = staffPass;
	}
	public String getStaffID() {return staffID;}
	public String getStaffName() {return staffName;}
	public String getStaffPhoneNum() {return staffPhoneNum;}
	public String getStaffEmail() {return staffEmail;}
	public String getStaffPass() {return staffPass;}
	
	public void setStaffID(String staffID) {this.staffID=staffID;}
	public void setStaffName(String staffName) {this.staffName=staffName;}
	public void setStaffPhoneNum(String staffPhoneNum) {this.staffPhoneNum=staffPhoneNum;}
	public void setStaffEmail(String staffEmail) {this.staffEmail=staffEmail;}
	public void setStaffPass(String staffPass) {this.staffPass=staffPass;}
	
	public List<String> getStaffIDs() {
        List<String> staffIDs = new ArrayList<>();

        // Java code to connect to the database and retrieve staff IDs
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT staffID FROM staff");
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
}

