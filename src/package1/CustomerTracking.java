package package1; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
/* Servlet implementation class CustomerTracking */ 
@WebServlet(name="R1", urlPatterns= {"/CustomerTracking"} ) 
public class CustomerTracking extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
        
    /* @see HttpServlet#HttpServlet() */ 
    public CustomerTracking() { 
        super(); 
        // TODO Auto-generated constructor stub 
    } 
 
 /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */ 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
  // TODO Auto-generated method stub 
  response.getWriter().append("Served at: ").append(request.getContextPath()); 
 } 
 
 /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */ 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
  // TODO Auto-generated method stub 
  //doGet(request, response); 
   
  response.setContentType("text/html"); 
  PrintWriter out = response.getWriter(); 
   
  String tID = request.getParameter("tID");
  String parcelID=null; 
  String staffID = null;
  String trackID=tID; 
  String courierName=null; 
  String dateDelivered=null; 
  Double weight=0.0; 
  String custName=null; 
  String custPhoneNum=null; 
  String paymentStatus=null; 
  
  try { 
	  
   parcelBean parcel = new parcelBean(parcelID, trackID, dateDelivered, courierName, weight, custName, custPhoneNum, paymentStatus, staffID);
   ParcelDAO parcelDAO = new ParcelDAO();
   
   parcelDAO.trackParcel(parcel);
   parcelID = parcel.getParcelID(); 
   staffID = parcel.getStaffID();
   trackID = parcel.getTrackID(); 
   courierName = parcel.getCourierName(); 
   dateDelivered = parcel.getDateDelivered(); 
   weight = parcel.getWeight(); 
   custName = parcel.getCustName(); 
   custPhoneNum = parcel.getCustPhoneNum(); 
   paymentStatus = parcel.getStatus();
  
   if(tID.equalsIgnoreCase(trackID)) {
     out.println("<html><head><meta charset=\"UTF-8\"><title>Parcel Slip</title><link href='styleForCTServlet.css' rel='stylesheet'>"); 
     out.println("<style>");
     out.println("@media print {");
     out.println(".page {background:none; box-shadow:none; page-break-after:avoid; height:calc(100vh-3rem);}");
     out.println("body {background-color:#fff !important;}");
     out.println(".print {display: none;}");
     out.println(".home {display: none;}");
     out.println(".bottom-section {display: block !important;}}</style>");
     out.println("<script>");
     out.println("function GetPrint() {");
     out.println("window.onbeforeprint = function() {");
     out.println("var bottomSection = document.getElementsByClassName(\"bottom-section\")[0];");
     out.println("bottomSection.style.display = \"none\";};");
     out.println("window.onafterprint = function() {");
     out.println("var bottomSection = document.getElementsByClassName(\"bottom-section\")[0];");
     out.println("bottomSection.style.display = \"block\";};");
     out.println("window.print();");
     out.println("setTimeout(function() {window.close();}, 500);}</script>");
     out.println("</head><body>");
     
     out.println("<div class=\"page\" size=\"A4\">");
     out.println("<div class=\"top-section\">");
     out.println("<div class=\"address\">");
     out.println("<div class=\"address-content\">");
     out.println("<h2> ParcelPal </h2>");
     out.println("<p> Pusat Pelajar Pentadbiran, UiTM Tapah, 35400 Tapah Road, Perak </p> </div></div>");
     out.println("<div class=\"contact\"><div class=\"address\"><div class=\"contact-content\">");
     out.println("<div class=\"email\"> Email: <span class=\"span\">");
     out.println("parcelpal99@gmail.com </span> </div>");
     out.println("<div class=\"number\"> Number: <span class=\"span\">");
     out.println("05-406 7000 </span> </div>"); 
     out.println("</div></div></div></div>");      
     out.println("<div class=\"parcel\">Parcel ID:</div>");
     out.println("<div class=\"content-parcel\">"+parcelID+"</div>");
     out.println("<div class=\"table\">");
     out.println("<table><tr><th>#</th><th>Index</th><th>Detail</th></tr>");
     out.println("<tr><td>1</td><td>Tracking ID</td>");
     out.println("<td>"+trackID+"</td>");
     out.println("</tr><tr><td>2</td><td>Delivered Date</td>");
     out.println("<td>"+dateDelivered+"</td>");
     out.println("</tr><tr><td>3</td><td>Courier Name</td>");
     out.println("<td>"+courierName+"</td>");
     out.println("</tr><tr><td>4</td><td>Weight</td>");
     out.println("<td>"+weight+" KG</td>");
     out.println("</tr><tr><td>5</td><td>Customer Name</td>");
     out.println("<td>"+custName+"</td>");
     out.println("</tr><tr><td>6</td><td>Phone Number</td>");
     out.println("<td>"+custPhoneNum+"</td>");
     out.println("</tr><tr><td>7</td><td>Service Charge</td>");
     out.println("<td>RM1.00</td></tr></table></div>");
     out.println("<div class=\"bottom-section\">");
     out.println("<div id=\"payment-status-container\">");
     out.println("<div class=\"status-content\"><h4>Payment Status:</h4>");
     if(paymentStatus.equalsIgnoreCase("paid"))
       out.println("<p class=\"status paid\"></p></div></div>");
     else
       out.println("<p class=\"status free\"></p></div></div>");
     out.println("<div><img src=\"uitm.png\" alt=\"Italian Trulli\">");
     out.println("<p class=\"tnx\"> Thank You for Using Our Service!</p></div></div></div>");
     out.println("<div class=\"print\"><button type=\"button\" class=\"btn-print\" onclick=\"GetPrint()\">Print</button></div>");
     out.println("<a href=\"CustomerTrack.jsp\"><div class=\"home\"><button type=\"button\" class=\"btn-home\" onclick=\"CustomerTrack.jsp\">Return</button>");
     out.println("</div></a></body></html>");
   }
 
   else { 
	   out.println("<html>");
	   out.println("<head>");
	   out.println("  <meta charset=\"UTF-8\">");
	   out.println("  <title>Parcel Slip</title>");
	   out.println("  <link rel=\"stylesheet\" href=\"styleForCTServlet.css\">");
	   out.println("  <style>");
	   out.println("    @media print {");
	   out.println("    .page {");
	   out.println("      background: none;");
	   out.println("      box-shadow: none;");
	   out.println("      page-break-after: avoid;");
	   out.println("      height: calc(100vh - 3rem);");
	   out.println("    }");
	   out.println("    body {");
	   out.println("      background-color: #fff !important;");
	   out.println("    }");
	   out.println("    .print {");
	   out.println("      display: none;");
	   out.println("    }");
	   out.println("    .bottom-section {");
	   out.println("      display: block !important;");
	   out.println("    }");
	   out.println("  }");
	   out.println("  </style>");
	   out.println("  <script>");
	   out.println("  function GetPrint() {");
	   out.println("    window.onbeforeprint = function() {");
	   out.println("      var bottomSection = document.getElementsByClassName(\"bottom-section\")[0];");
	   out.println("      bottomSection.style.display = \"none\";");
	   out.println("    };");
	   out.println("    window.onafterprint = function() {");
	   out.println("      var bottomSection = document.getElementsByClassName(\"bottom-section\")[0];");
	   out.println("      bottomSection.style.display = \"block\";");
	   out.println("    };");
	   out.println("    window.print();");
	   out.println("    setTimeout(function() {");
	   out.println("      window.close();");
	   out.println("    }, 500);");
	   out.println("  }");
	   out.println("  </script>");
	   out.println("</head>");
	   out.println("<body>");
	   out.println("  <div class=\"page\" size=\"A4\">");
	   out.println("    <div class=\"top-section2\">");
	   out.println("      <div class=\"address\">");
	   out.println("        <div class=\"address-content\">");
	   out.println("          <h2> ParcelPal </h2>");
	   out.println("          <p> Tapah Road, 35400 Tapah Road, Perak, Pusat Pelajar, UiTM Tapah, 35000 Tapah, Perak </p>");
	   out.println("        </div>");
	   out.println("      </div>");
	   out.println("      <div class=\"contact\">");
	   out.println("        <div class=\"address\">");
	   out.println("          <div class=\"contact-content\">");
	   out.println("            <div class=\"email\"> Email: <span class=\"span\">parcelpal99@gmail.com</span> </div>");
	   out.println("            <div class=\"number\"> Number: <span class=\"span\">011-2086 3651</span> </div>");
	   out.println("          </div>");
	   out.println("        </div>");
	   out.println("      </div>");
	   out.println("    </div>");
	   out.println("    <div class=\"parcel\">Tracking ID:</div>");
	   out.println("    <div class=\"content-parcel2\">Not Found!</div>");
	   out.println("    <div class=\"error\">The Entered Tracking ID Cannot Be Found.</div>");
	   out.println("    <div class=\"recommend\">Please Enter Another Tracking ID!</div>");
	   out.println("    <div class=\"bottom-section\">");
	   out.println("      <div>");
	   out.println("        <img class=\"img\" src=\"uitm.png\" alt=\"Italian Trulli\">");
	   out.println("        <p class=\"tnx\"> Thank You for Using Our Service!</p>");
	   out.println("      </div>");
	   out.println("    </div>");
	   out.println("    <a href=\"CustomerTrack.jsp\">");
	   out.println("      <div class=\"home2\">");
	   out.println("        <button type=\"button\" class=\"btn-home\">RETURN</button>");
	   out.println("      </div>");
	   out.println("    </a>");
	   out.println("  </div>");
	   out.println("</body>");
	   out.println("</html>");

   }
  } catch (Exception e2) { 
  System.out.println(e2); 
  } 
  out.close(); 
   
   
 } 
 
}