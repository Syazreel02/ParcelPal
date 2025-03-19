package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReceiptDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ep";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "monsterSQL123";

    public String generateReceiptID() throws ClassNotFoundException, SQLException {
    	String rid = null;
    	int max=0;
    	Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    Statement stmt = con.createStatement();
	    String sql = "SELECT receiptID FROM receipt";
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
        	rid = rs.getString("receiptID");
        	if(max<Integer.parseInt(rid.substring(3)))
        		max=Integer.parseInt(rid.substring(3));
        }
	    
	    rid = "RPX" + (max+1);
	    return rid;
    }
    
    public void addReceipt(receiptBean receipt) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement ps = con.prepareStatement("INSERT INTO receipt VALUES (?, ?, ?, ?)");
        ps.setString(1, receipt.getReceiptID());
        ps.setString(2, receipt.getParcelID());
        ps.setString(3, receipt.getReceiptDate());
        ps.setDouble(4, receipt.getServiceCharge());
        ps.executeUpdate();

        ps.close();
    }
}
