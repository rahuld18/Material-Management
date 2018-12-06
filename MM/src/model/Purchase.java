package model;

public class Purchase 
{
private int transactionid;

private String employeeid;

private String productid;
private String suppliername;
private String invoiceno;
private String qtypurchase;
private String rate;
private String dateofpurchase;

private String remark;

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

public String getSuppliername() {
	return suppliername;
}

public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}

public String getInvoiceno() {
	return invoiceno;
}

public void setInvoiceno(String invoiceno) {
	this.invoiceno = invoiceno;
}

public String getQtypurchase() {
	return qtypurchase;
}

public void setQtypurchase(String qtypurchase) {
	this.qtypurchase = qtypurchase;
}

public String getRate() {
	return rate;
}

public void setRate(String rate) {
	this.rate = rate;
}

public String getDateofpurchase() {
	return dateofpurchase;
}

public void setDateofpurchase(String dateofpurchase) {
	this.dateofpurchase = dateofpurchase;
}

public String getRemark() {
	return remark;
}

public void setRemark(String remark) {
	this.remark = remark;
}
}
