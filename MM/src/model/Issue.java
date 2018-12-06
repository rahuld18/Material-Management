package model;

public class Issue
{

	
	private int transactionid;
	private String employeeid;
	private String productid;
	private String issuedate;
	private String qtyissue;
	private String purposeofissue;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	
	public String getPurposeofissue() {
		return purposeofissue;
	}
	public void setPurposeofissue(String purposeofissue) {
		this.purposeofissue = purposeofissue;
	}
	public String getQtyissue() {
		return qtyissue;
	}
	public void setQtyissue(String qtyissue) {
		this.qtyissue = qtyissue;
	}
	
}
