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
 * Servlet implementation class deleteParcelServlet
 */
@WebServlet("/deleteParcelServlet")
public class deleteParcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteParcelServlet() {
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
		int i=0;
		
		String trackID = request.getParameter("trackID");
		String parcelID=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
			Statement stmt = con.createStatement();
			
			String sql = "SELECT trackID, parcelID FROM parcel where trackID = '"+trackID+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				i++;
				parcelID = rs.getString("parcelID");
			}
			
			if(i>0) {
				sql = "DELETE FROM receipt WHERE parcelID ='" + parcelID + "'";
				stmt.executeUpdate(sql);
				sql = "DELETE FROM parcel WHERE trackID ='" + trackID + "'";
				stmt.executeUpdate(sql);
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"UTF-8\">");
				out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
				out.println("<title>Data Successfully Deleted</title>");
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
				out.println("<h1>Data Successfully Deleted</h1>");
				out.println("<p>Your data has been successfully deleted.</p>");
				out.println("<button class=\"btn\" onclick=\"goToManageParcel()\">Go to ManageParcel.jsp</button>");
				out.println("</div>");
				out.println("<script>");
				out.println("function goToManageParcel() {");
				out.println("  window.location.href = \"ManageParcel.jsp\";");
				out.println("}");
				out.println("</script>");
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
		catch(Exception e2) {
			out.println("Track ID not found.");
		}
		out.close();
	}

}
