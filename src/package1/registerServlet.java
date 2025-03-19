package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet(name="R5", urlPatterns= {"/registerServlet"} ) 
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		PrintWriter out = response.getWriter();
		String staffName= request.getParameter("StaffName");
        String staffEmail = request.getParameter("StaffEmail");
        String staffPhoneNum = request.getParameter("StaffPhoneNum");
        String staffPassword = request.getParameter("StaffPassword");
        String staffCheckPassword = request.getParameter("StaffCheckPassword");
        response.setContentType("text/html");
        String staffID = null;
        String sid = null;
        String se = null;
        String spn= null;
        String sn = null;
        
        int t1=0,t2=0,t3=0;
        
        staffBean staff1 = new staffBean(sid, sn, spn, se, null);
        staffBean staff2 = new staffBean(staffID, staffName, staffPhoneNum, staffEmail, null);
        StaffDAO staffDAO = new StaffDAO();
        int rowsAffected=0;
		
        if(staffPassword.equals(staffCheckPassword)) {
			try {
				int[] result = staffDAO.registerStaff(staff1, staff2);
			    int max = result[0];
			    t1 = result[1];
			    t2 = result[2];
			    t3 = result[3];
				
		        staffID = "CG00120" + (max+1);
		        
		        staffBean staff3 = new staffBean(staffID, staffName, staffPhoneNum, staffEmail, staffPassword);
		        
		        if(t1==0&&t2==0&&t3==0) {
			        rowsAffected = staffDAO.addStaff(staff3);
		        }

		        if (rowsAffected > 0) {
		        	out.println("<html>");
		        	out.println("<head>");
		        	out.println("<meta charset=\"ISO-8859-1\">");
		        	out.println("<title>Registration Successful</title>");
		        	out.println("<link rel=\"stylesheet\" href=\"successR.css\">");
		        	out.println("</head>");
		        	out.println("<body>");
		        	out.println("<div class=\"container\">");
		        	out.println("<div class=\"message\">");
		        	out.println("<h1>Registration Successful!</h1>");
		        	out.println("<p>Congratulations, your registration is successful.</p>");
		        	out.println("<p><label style=\"color:'blue'\">staff ID </label>= "+ staffID +"</p>");
		        	out.println("<a href=\"Login.jsp\" class=\"proceed-btn\">Proceed to Login</a>");
		        	out.println("</div>");
		        	out.println("</div>");
		        	out.println("</body>");
		        	out.println("</html>");

		        } else {
		            // Database insertion failed
		        	out.println("<html>");
		        	out.println("<head>");
		        	out.println("<meta charset=\"ISO-8859-1\">");
		        	out.println("<link rel=\"stylesheet\" href=\"failR.css\">");
		        	out.println("</head>");
		        	out.println("<body>");
		        	out.println("<div class=\"container\">");
		        	out.println("<div class=\"message\">");
		        	out.println("<h1>Registration Failed</h1>");
		        	out.println("<p>Sorry, the information you entered already belongs to a registered user.</p>");
		        	if(t1==1||t2==1||t3==1) {
		        		out.println("<ul class=\"error-list\">");
			        	if(t1==1) 
			        		out.println("<li>Staff Name already exist in the system.</li>");
			        	if(t2==1) 
			        		out.println("<li>Staff Phone Number already used.</li>");
			        	if(t3==1) 
			        		out.println("<li>Staff Email already used.</li>");
			        	out.println("</ul>");
					}
		        	out.println("<a href=\"Login.jsp#register\" class=\"return-btn\">Return to Register</a>");
		        	out.println("</div>");
		        	out.println("</div>");
		        	out.println("</body>");
		        	out.println("</html>");
		        }
			}
			catch (Exception e2) {
				// Database insertion failed
	        	out.println("<html>");
	        	out.println("<head>");
	        	out.println("<meta charset=\"ISO-8859-1\">");
	        	out.println("<link rel=\"stylesheet\" href=\"failR.css\">");
	        	out.println("</head>");
	        	out.println("<body>");
	        	out.println("<div class=\"container\">");
	        	out.println("<div class=\"message\">");
	        	out.println("<h1>Registration Failed</h1>");
	        	out.println("<p>Sorry, the information you entered already belongs to a registered user.</p>");
	        	if(t1==1||t2==1||t3==1) {
	        		out.println("<ul class=\"error-list\">");
		        	if(t1==1) 
		        		out.println("<li>Staff Name already exist in the system.</li>");
		        	if(t2==1) 
		        		out.println("<li>Staff Phone Number already used.</li>");
		        	if(t3==1) 
		        		out.println("<li>Staff Email already used.</li>");
		        	out.println("</ul>");
				}
	        	out.println("<a href=\"Login.jsp#register\" class=\"return-btn\">Return to Register</a>");
	        	out.println("</div>");
	        	out.println("</div>");
	        	out.println("</body>");
	        	out.println("</html>");
		    }
        }
        else
        {
        	out.println("<html>");
        	out.println("<head>");
        	out.println("<meta charset=\"ISO-8859-1\">");
        	out.println("<title>Password Mismatch</title>");
        	out.println("<link rel=\"stylesheet\" href=\"mismatchR.css\">");
        	out.println("</head>");
        	out.println("<body>");
        	out.println("<div class=\"container\">");
        	out.println("<div class=\"message\">");
        	out.println("<h1>Password and Reenter Password Not Match</h1>");
        	out.println("<p>Please make sure the passwords entered are the same.</p>");
        	out.println("<a href=\"Login.jsp#register\" class=\"return-btn\">Return to Register</a>");
        	out.println("</div>");
        	out.println("</div>");
        	out.println("</body>");
        	out.println("</html>");
        }
        out.close();
	}

}
