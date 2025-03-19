package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

@WebServlet(name = "R2", urlPatterns = {"/DisplayReceipt"})
public class DisplayReceipt extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayReceipt() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String searchName = request.getParameter("pID");
        String rid = null;
        String pid = null;
        LocalDate dt = null;
        String date = null;
        Double sc = null;
        boolean found=false;
        boolean exist = false;
        
        StringBuilder output = new StringBuilder();

        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep", "root", "monsterSQL123");
            Statement stmt = con.createStatement();
            ParcelDAO parcelDAO = new ParcelDAO();
            found=parcelDAO.checkParcel(searchName);
            
            output.append("<html><head>");
            output.append("<link href='styleForReceiptServlet.css' rel='stylesheet'>");
            output.append("</head><body>");
            output.append("<div class=\"page\" size=\"A4\">");
            output.append("<div class=\"top-section\">");
            output.append("<div class=\"address\">");
            output.append("<div class=\"address-content\">");
            output.append("<h2><b>ParcelPal</b></h2>");
            output.append("<p><b>Pusat Pelajar Pentadbiran, UiTM Tapah, 35400 Tapah Road, Perak</b></p>");
            output.append("</div>");
            output.append("</div>");
            output.append("<div class=\"contact\">");
            output.append("<div class=\"address\">");
            output.append("<div class=\"contact-content\">");
            output.append("<div class=\"email\"><b>Email : </b><span class=\"span\"><b>parcelpal99@gmail.com</b></span></div>");
            output.append("<div class=\"number\"><b>Number :</b><span class=\"span\"><b>05-406 7000</b></span></div>");
            output.append("</div>");
            output.append("</div>");
            output.append("</div>");
            output.append("</div>");

        
            if(found==true) {
            	pid = searchName;
            	parcelDAO.parcelPaid(pid);
            	receiptBean receipt = new receiptBean();
            	ReceiptDAO receiptDAO = new ReceiptDAO();
            	String sql = "SELECT * FROM receipt WHERE parcelID = '" + pid + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                	rid = rs.getString("receiptID");
                	pid = rs.getString("parcelID");
                	dt = rs.getDate("receiptDate").toLocalDate();
                	sc = rs.getDouble("serviceCharge");
                	exist = true;
                }
                if(exist==false) {
	                rid = receiptDAO.generateReceiptID();
	            	dt = LocalDate.now();
	            	date = dt.toString();
	            	sc=1.00;
	                receipt = new receiptBean(rid, pid, date, sc);
	                receiptDAO.addReceipt(receipt);
                }
                output.append("<div class=\"receipt\">Receipt ID: ").append(rid).append("</div>");

                output.append("<div class=\"table\">");
                output.append("<table>");
                output.append("<tr>");
                output.append("<th>#</th>");
                output.append("<th>Index</th>");
                output.append("<th>Detail</th>");
                output.append("</tr>");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedDate = dt.format(formatter);
                DecimalFormat df = new DecimalFormat("#0.00");
                String formattedSC = df.format(sc);
                output.append("<tr>");
                output.append("<td>1</td>");
                output.append("<td>Parcel ID</td>");
                output.append("<td>").append(pid).append("</td>");
                output.append("</tr>");
                output.append("<tr>");
                output.append("<td>2</td>");
                output.append("<td>Receipt Date</td>");
                output.append("<td>").append(formattedDate).append("</td>");
                output.append("</tr>");
                output.append("<tr>");
                output.append("<td>3</td>");
                output.append("<td>Service Charge (RM)</td>");
                output.append("<td>").append(formattedSC).append("</td>");
                output.append("</tr>");

                output.append("</table>");
                output.append("</div>");
                output.append("<div class=\"bottom-section\">");
                output.append("<div id=\"payment-status-container\">");
                output.append("<div class=\"status-content\">");
                output.append("<h4>Payment Status:</h4>");
                output.append("<p class=\"status paid\"></p>");
                output.append("</div>");
                output.append("</div>");
                output.append("<div>");
                output.append("<img src=\"uitm.png\" alt=\"Italian Trulli\">");
                output.append("<p class=\"tnx\"><b>Thank You for Using Our Service!</b></p>");
                output.append("</div>");
                output.append("</div>");

                output.append("<div class=\"print\">");
                output.append("<button type=\"button\" class=\"btn-print\" onclick=\"GetPrint()\">Print</button>");
                output.append("</div>");
                
                output.append("<div class=\"home\">");
                output.append("<button type=\"button\" class=\"btn-home\" onclick=\"GoHome()\">Home</button>");
                output.append("</div>");
                
                output.append("<script>");
                output.append("function GetPrint() {");
                output.append("var topSection = document.getElementsByClassName(\"top-section\")[0];");
                output.append("var bottomSection = document.getElementsByClassName(\"bottom-section\")[0];");
                output.append("var receiptId = document.getElementsByClassName(\"receipt\")[0].outerHTML;");
                output.append("var table = document.getElementsByClassName(\"table\")[0].outerHTML;");
                output.append("var printContent = topSection.outerHTML + receiptId + table + bottomSection.outerHTML;");
                output.append("var originalContent = document.body.innerHTML;");
                output.append("document.body.innerHTML = printContent;");
                output.append("window.print();");
                output.append("document.body.innerHTML = originalContent;");
                output.append("}");
                
                output.append("function GoHome() {");
                output.append("window.location.href = \"printreceipt.jsp\";");
                output.append("}");
                output.append("</script>");
            }

            else {
            	output.append("<div class=\"no-receipt\">No receipt found for the provided parcel ID!</div>");
            	output.append("<div class=\"incorrect-id\">Please make sure to enter the parcel ID correctly!</div>");
                
                output.append("<div class=\"home1\">");
                output.append("<button type=\"button\" class=\"btn-home\" onclick=\"GoHome()\">Home</button>");
                output.append("</div>");
                
                output.append("<script>");
                output.append("function GetPrint() {");
                output.append("var topSection = document.getElementsByClassName(\"top-section\")[0];");
                output.append("var bottomSection = document.getElementsByClassName(\"bottom-section\")[0];");
                output.append("var receiptId = document.getElementsByClassName(\"receipt\")[0].outerHTML;");
                output.append("var table = document.getElementsByClassName(\"table\")[0].outerHTML;");
                output.append("var printContent = topSection.outerHTML + receiptId + table + bottomSection.outerHTML;");
                output.append("var originalContent = document.body.innerHTML;");
                output.append("document.body.innerHTML = printContent;");
                output.append("window.print();");
                output.append("document.body.innerHTML = originalContent;");
                output.append("}");

                output.append("function GoHome() {");
                output.append("window.location.href = \"printreceipt.jsp\";");
                output.append("}");
                output.append("</script>");
            }
            output.append("</body></html>");

            out.println(output.toString());

            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}
