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

import controller.ProductController;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession ses=request.getSession();
		try{
			@SuppressWarnings("deprecation")
			String s=(String)ses.getValue("LTIME").toString();
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("EmployeeLogin");
	    	}
		
		try{
			
		
		PrintWriter out=response.getWriter();
		
		ResultSet rs=ProductController.displayAll();
		if(rs.next()){
		
		out.println("<html> <table border=1>");
		out.println("<tr> <th><b>Name</b></th> <th><b>Rate</b></th> <th><b>Stock</b></th> <th><b>Model No</b></th> <th><b>Inventory Level</b></th> <th><b>Category<br>SubCategory</b></th> <th><b>Photograph</b></th>   <th><b>Employee id</b></th>  <th><b>Update</b></th> </tr>");
		
		do{
		out.println("<tr> <td><b>"+rs.getString(2)+"</b></td> <td><b>"+rs.getString(4)+"</b></td> <td><b>"+rs.getString(5)+"</b></td> <td><b>"+rs.getString(3)+"</b></td> <td><b>"+rs.getString(6)+"</b></td> <td><b>Category="+rs.getString(7)+"<br>Subcategory="+rs.getString(8)+"</b></td> <td><img width =30 height=30 src=/MM/eimages/"+rs.getString(9)+"></td> <td>"+rs.getString(10)+"</td> <td><a href=DisplayProductById?cid="+rs.getString(1)+">Edit/delete</a> </td></tr>");
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
			
			System.out.println("Product list "+e);	
		}
	
	}

}
