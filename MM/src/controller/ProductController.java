package controller;

import java.sql.Connection;
import java.sql.ResultSet;


import model.Products;

public class ProductController {

	public static boolean addNewRecord(Products P)
	{
		
		try{
			  Connection cn=DbHelper.openConnection();
			  String query="insert into products (productname,modelno,rate,stock,inventorylevel,category,subcategory,photograph,employeeid)values('"+P.getProductname()+"','"+P.getModelno()+"','"+P.getRate()+"','"+P.getStock()+"','"+P.getInventorylevel()+"','"+P.getCategory()+"','"+P.getSubcategory()+"','"+P.getPhotograph()+"','"+P.getEmployeeid()+"')";

		boolean st=DbHelper.executeUpdate(cn, query);
		 return(st);
		}
		catch(Exception e)
			{
			System.out.println("Error:addNewRecord()"+e);
			}
		return(false);
	}
	public static ResultSet displayAll()
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from products";
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
		String query="select P.productid,P.productname,P.modelno,P.rate,P.stock,P.inventorylevel,(select C.categoryname from category C where C.categoryid=P.category),(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategory),P.photograph,P.employeeid,P.category,P.subcategory from products P where P.productid="+cid;
		ResultSet rs=DbHelper.executeQuery(cn, query);
		return rs;
		}catch(Exception e)
		{
			System.out.println("Error:displayProductById():"+e);
			
		}
		return null;
	}



public static boolean editRecord(Products  P)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="update products set productname='"+P.getProductname()+"',employeeid='"+P.getEmployeeid()+"',inventorylevel='"+P.getInventorylevel()+"',modelno='"+P.getModelno()+"',rate='"+P.getRate()+"',stock='"+P.getStock()+"',category='"+P.getCategory()+"',subcategory='"+P.getSubcategory()+"' where productid="+P.getProductid();
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
  String query="delete from products where productid="+pid;
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:deleteRecord()"+e);
	}
return(false);
	
}

public static boolean editPicture(int pid,String pic)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="update products set photograph='"+pic+"' where productid="+pid;
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:editPicture()"+e);
	}
return(false);
	
}
public static ResultSet GetAllProduct(int sid)
{
	
	try{
		Connection cn=DbHelper.openConnection();
		ResultSet rs=DbHelper.executeQuery(cn, "Select * from products where subcategory="+sid);
		return(rs);
		
		
	}catch(Exception e){
	 System.out.println("GetAllProduct():"+e);	
	}
	return(null);
}

public static String updateStock(int pid,int qty,String status)
{
	try {
		Connection cn=DbHelper.openConnection();
		ResultSet rs=displayById(pid);
		 String pname="";
		 int stock=0;
		 int level=0;
		 if(rs.next())
		 {  
		 stock=Integer.parseInt(rs.getString(5));

		 level=Integer.parseInt(rs.getString(6));
		pname=rs.getString(2);
		}
		 if(status.equalsIgnoreCase("I"))
		 {
			 if(stock>=qty)
			   { String query="update products set stock=stock-"+qty+" where productid="+pid;
			      boolean st=DbHelper.executeUpdate(cn, query);
			    if(stock<level)
			  {
			  return("1 Warning:Only "+(stock-qty)+" quantity is left for product "+pname+"<br>Stock :"+(stock-qty)+" Level:"+level);	  
			  }
			  else
			  {return("1 Stock Updated in Product "+pname+"<br>Stock :"+(stock-qty)+" Level:"+level);
			  }
			  
			  } 
			  else
			  {
			  return("0 Stock is Less for Product "+pname+"<br>Stock :"+stock+" Level:"+level);	  
			  }
			}
			
			else  if(status.equalsIgnoreCase("P"))
			  {
				String query="update products set stock=stock+"+qty+" where productid="+pid;
			      boolean st=DbHelper.executeUpdate(cn, query);
			      return("Stock Updated in Product "+pname+"<br>Stock :"+(stock+qty)+" Level:"+level);	
			  }
			
			 
		 
	}catch(Exception e)
	{
	System.out.println("Error:updateStock()"+e);
	}
return("0");
}

}

