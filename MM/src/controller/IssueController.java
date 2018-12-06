package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Issue;


public class IssueController
{
	public static boolean issueProduct(Issue I)
	{

		try{
			  Connection cn=DbHelper.openConnection();
			  String query="insert into issue(employeeid,productid,issuedate,qtyissue,purposeofissue) values('"+I.getEmployeeid()+"','"+I.getProductid()+"','"+I.getIssuedate()+"','"+I.getQtyissue()+"','"+I.getPurposeofissue()+"')";
			  boolean st=DbHelper.executeUpdate(cn, query);
				 return(st); 
		}
		catch(Exception e)
			{
			System.out.println("Error:IssueProduct()"+e);
			}
		return(false);
	 
	}
	
	public static ResultSet displayAll()
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from issue";
			ResultSet rs=DbHelper.executeQuery(cn, query);
			return rs;
			
		}catch(Exception e)
		{
			
			System.out.println("Error:displayAll()"+e);
		}
		return null;
	}
	
	public static ResultSet displayById(int cid)
	{
		try{
		Connection cn=DbHelper.openConnection();
		String query="select I.transactionid,I.employeeid,I.productid,I.issuedate,I.qtyissue,I.purposeofissue from issue I where I.transactionid="+cid;
		
		ResultSet rs=DbHelper.executeQuery(cn, query);
		return rs;
		}catch(Exception e)
		{
			System.out.println("Error:displayIssueById():"+e);
			
		}
		return null;
	}
	

public static boolean editRecord(Issue I)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="update issue set employeeid='"+I.getEmployeeid()+"',productid='"+I.getProductid()+"',issuedate='"+I.getIssuedate()+"',purposeofissue='"+I.getPurposeofissue()+"',qtyissue='"+I.getQtyissue()+" where transactionid="+I.getTransactionid();
  System.out.println(query);
 boolean st=DbHelper.executeUpdate(cn, query);
return(st);
 
}
catch(Exception e)
	{
	System.out.println("Error:editRecord()"+e);
	}
return(false);
	
}

public static boolean deleteRecord(int pid)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="delete from issue where transactionid="+pid;
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:deleteRecord()"+e);
	}
return(false);
	
}

	

}
