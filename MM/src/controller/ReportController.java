package controller;

import java.sql.Connection;
import java.sql.ResultSet;
public class ReportController {
	public static ResultSet ReportProductWiseIssuePurchaseBetweenTwoDates(int productid,String status,String datefrom,String dateto)
	{try{
		  Connection cn=DbHelper.openConnection();
		  String q="";
		  if(status.equalsIgnoreCase("Issue")){
		   q="select I.*,(select E.employeename from employees E where E.employeeid=I.employeeid) as iempname,(select P.productname from products P where P.productid=I.productid) as ipname,(select E.photograph from employees E where E.employeeid=I.employeeid) as iepicture,(select P.photograph from products P where P.productid=I.productid) as ippicture from issue I where I.issuedate between '"+datefrom+"' and '"+dateto+"'";
		  
		  }
		  else{
			  q = "select PR.*,(select P.dateofpurchase from purchase P where P.productid=PR.productid) as purchasedate,(select P.transactionid from purchase P where P.productid=PR.productid) as ptransactionid,(select E.employeename from employees E where E.employeeid=PR.employeeid) as pempname,(select P.productname from products P where P.productid=PR.productid) as ppname,(select E.photograph from employees E where E.employeeid=PR.employeeid) as pepicture,(select P.photograph from products P where P.productid=PR.productid) as pppicture from purchase PR where PR.dateofpurchase between '"+datefrom+"' and '"+dateto+"' ";
		 System.out.println(q);
		  }
		  ResultSet rs=DbHelper.executeQuery(cn, q);
		  return(rs);
		  
		}
		catch(Exception e){System.out.println("Error:addNewRecord()"+e);}
		return(null);
		}

	public static ResultSet ReportEmployeeWiseProductWiseBetweenTwoDates(int eid,String status,String datefrom,String dateto)
	{try{
		  Connection cn=DbHelper.openConnection();
		  String q="";
		  if(status.equalsIgnoreCase("Issue")){
		   q="select I.*,(select E.employeename from employees E where E.employeeid=I.employeeid) as iempname,(select P.productname from products P where P.productid=I.productid) as ipname,(select E.photograph from employees E where E.employeeid=I.employeeid) as iepicture,(select P.photograph from products P where P.productid=I.productid) as ippicture from issue I where I.issuedate between '"+datefrom+"' and '"+dateto+"'";
		  
		  }
		  else{
			  q = "select PR.*,(select P.dateofpurchase from purchase P where P.productid=PR.productid) as purchasedate,(select P.transactionid from purchase P where P.productid=PR.productid) as ptransactionid,(select E.employeename from employees E where E.employeeid=PR.employeeid) as pempname,(select P.productname from products P where P.productid=PR.productid) as ppname,(select E.photograph from employees E where E.employeeid=PR.employeeid) as pepicture,(select P.photograph from products P where P.productid=PR.productid) as pppicture from purchase PR where PR.dateofpurchase between '"+datefrom+"' and '"+dateto+"' and  (select E.employeeid from employees E where E.employeeid=PR.employeeid)";
		 System.out.println(q);
		  }
		  ResultSet rs=DbHelper.executeQuery(cn, q);
		  return(rs);
		  
		}
		catch(Exception e){System.out.println("Error:addNewRecord()"+e);}
		return(null);
		}


}

