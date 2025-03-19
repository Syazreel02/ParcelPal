package package1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name="R4", urlPatterns= {"/loginServlet"} ) 
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		
		String sID = request.getParameter("userID");
        String pwd = request.getParameter("pwd");
        String staffID = null;
        String password = null;
        response.setContentType("text/html");
        staffBean staff = new staffBean();
		staff.setStaffID(sID);
		StaffDAO staffDAO = new StaffDAO();
		  
		try { 
			staffDAO.loginStaff(staff);
		} 
		catch (Exception e2) { 
				System.out.println(e2); 
		} 

		staffID = staff.getStaffID();
		password = staff.getStaffPass();
		       
        boolean isValidUser = validateUser(sID, pwd, staffID, password);

        if (isValidUser) {
            // Successful login
            // You can redirect to a welcome page or set a session to mark the user as logged in.
            response.sendRedirect("staff.html");
        } else {
            // Failed login
            // You can redirect back to the login page with an error message.
        	HttpSession session = request.getSession();
            session.setAttribute("invalid", true);
            response.sendRedirect("Login.jsp");
        }
	}
	
	private boolean validateUser(String sID, String pwd, String staffID, String password) {
        return sID.equals(staffID) && pwd.equals(password);
    }

}
