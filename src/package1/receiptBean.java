package package1;

public class receiptBean {
	private String receiptID = null;
	private String parcelID = null;
	private String receiptDate = null;
	private Double serviceCharge = null;
	
	public receiptBean() {}
	public receiptBean(String receiptID, String parcelID, String receiptDate, Double serviceCharge) {
		this.receiptID = receiptID;
		this.parcelID = parcelID;
		this.receiptDate = receiptDate;
		this.serviceCharge = serviceCharge;
	}
	public String getReceiptID() {return receiptID;}
	public String getParcelID() {return parcelID;}
	public String getReceiptDate() {return receiptDate;}
	public Double getServiceCharge() {return serviceCharge;}
	
	public void setReceiptID(String receiptID) {this.receiptID=receiptID;}
	public void setParcelID(String parcelID) {this.parcelID=parcelID;}
	public void setReceiptDate(String receiptDate) {this.receiptDate=receiptDate;}
	public void setServiceCharge(Double serviceCharge) {this.serviceCharge=serviceCharge;}
}
