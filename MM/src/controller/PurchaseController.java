package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import controller.DbHelper;
import model.Purchase;

public class PurchaseController
{

	public static boolean purchaseProduct(Purchase P)
	{

		try{
			  Connection cn=DbHelper.openConnection();
			  String query="insert into purchase(employeeid,productid,dateofpurchase,qtypurchase,suppliername,invoiceno,rate,remark) values('"+P.getEmployeeid()+"','"+P.getProductid()+"','"+P.getDateofpurchase()+"','"+P.getQtypurchase()+"','"+P.getSuppliername()+"','"+P.getInvoiceno()+"','"+P.getRate()+"','"+P.getRemark()+"')";
			  boolean st=DbHelper.executeUpdate(cn, query);
				 return(st); 
		}
		catch(Exception e)
			{
			System.out.println("Error:PurchaseProduct()"+e);
			}
		return(false);
		
	}
	
	public static ResultSet displayAll()
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from purchase";
			ResultSet rs=DbHelper.executeQuery(cn, query);
			return rs;
			
		}catch(Exception e)
		{
			
			System.out.println("Error:displayAll()"+e);
		}
		return null;
	}
	
	public static ResultSet displayById(int tid)
	{
		try{
		Connection cn=DbHelper.openConnection();
		String query="select Pc.transactionid,Pc.employeeid,Pc.productid,Pc.suppliername,Pc.invoiceno,Pc.qtypurchase,Pc.rate,Pc.dateofpurchase,Pc.remark from purchase Pc where Pc.transactionid="+tid;
		
		ResultSet rs=DbHelper.executeQuery(cn, query);
		return rs;
		}catch(Exception e)
		{
			System.out.println("Error:displayPurchaseById():"+e);
			
		}
		return null;
	}
	
}
