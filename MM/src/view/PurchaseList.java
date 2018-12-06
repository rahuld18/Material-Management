package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.PurchaseController;

/**
 * Servlet implementation class PurchaseList
 */
@WebServlet("/PurchaseList")
public class PurchaseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	
		HttpSession ses=request.getSession();
		try{
			@SuppressWarnings("deprecation")
			String s=(String)ses.getValue("LTIME").toString();
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("EmployeeLogin");
	    	}*/
		try{
			
			
			PrintWriter out=response.getWriter();
			
			ResultSet rs=PurchaseController.displayAll();
			if(rs.next()){
			
			out.println("<html> <table border=1>");
			out.println("<tr> <th><b>Transcation Id</b></th> <th><b>Employee  ID</b></th> <th><b>Product ID</b></th> <th><b>Supplier Name</b></th> <th><b>Invoice No</b></th> <th><b>quantity Purchase</b></th><th><b>Rate</b></th> <th><b>Date of Purchase</b></th> <th><b>Remark</b></th> <th><b>Update</b></th> </tr>");
			
			do{
			out.println("<tr> <td><b>"+rs.getString(1)+"</b></td><td><b>"+rs.getString(2)+"</b></td><td><b>"+rs.getString(3)+"</b></td> <td><b>"+rs.getString(4)+"</b></td> <td><b>"+rs.getString(5)+"</b></td> <td><b>"+rs.getString(6)+"</b></td><td><b>"+rs.getString(7)+"</b></td> <td><b>"+rs.getString(8)+"</b></td><td><b>"+rs.getString(9)+"</b></td><td><a href=DisplayPurchaseById?cid="+rs.getString(1)+">Edit/delete</a> </td></tr>");
			}while(rs.next());

			out.println("</table>");
			}
			else
	 	   {
	 		   out.println("No Record Found..."); 
	 	   }
			out.println("</html>");
			}catch(Exception e)
			{
				
				System.out.println("Purchase list "+e);	
			}
		

	}

}
