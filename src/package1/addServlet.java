package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addServlet
 */
@WebServlet(name="R3", urlPatterns= {"/addServlet"} ) 
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
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
	    PrintWriter out = response.getWriter();
	    String trackID = request.getParameter("TrackID");
	    String deliveredDate = request.getParameter("Date");
	    String courierName = request.getParameter("CourierName");
	    Double weight = Double.parseDouble(request.getParameter("Weight"));
	    String custName = request.getParameter("CustName");
	    String custPhoneNum = request.getParameter("CustPhone");
	    String paymentStatus = request.getParameter("Status");
	    String staffID = request.getParameter("StaffID");
	    int max = 0;
	    String parcelID = null;
	    
		    
        
	    try {
	    	ParcelDAO parcelDAO = new ParcelDAO();
	    	
	    	max = parcelDAO.generateParcelID();
	        parcelID = "P" + (max + 1);
	        
	        // Create Parcel object
	        parcelBean parcel = new parcelBean(parcelID, trackID, deliveredDate, courierName, weight, custName, custPhoneNum, paymentStatus, staffID);

	        int rowsAffected = parcelDAO.addParcel(parcel);

	        if (rowsAffected > 0) {
	            // Database insertion was successful
	        	HttpSession session = request.getSession();
	            session.setAttribute("parcelID", parcelID);
	            session.setAttribute("staffID", staffID);
	            session.setAttribute("trackID", trackID);
	            session.setAttribute("courierName", courierName);
	            session.setAttribute("deliveredDate", deliveredDate);
	            session.setAttribute("weight", weight);
	            session.setAttribute("custName", custName);
	            session.setAttribute("custPhoneNum", custPhoneNum);
	            session.setAttribute("paymentStatus", paymentStatus);

	            //request.getRequestDispatcher("Add.jsp?insertionSuccess=true").forward(request, response);
	            response.sendRedirect("Add.jsp?insertionSuccess=true");
	        } else {
	            // Database insertion failed
	            response.sendRedirect("Add.jsp?insertionFailed=true");
	        }
	    } catch (Exception e2) {
	        response.sendRedirect("Add.jsp?insertionFailed=true");
	    }
	    out.close();
	}


}
