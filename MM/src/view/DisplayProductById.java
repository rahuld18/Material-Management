package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ProductController;

/**
 * Servlet implementation class DisplayProductById
 */
@WebServlet("/DisplayProductById")
public class DisplayProductById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProductById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/categorysubcategory.js'></script>");
		out.println("<html>");
		  try{
			    ResultSet rs=ProductController.displayById(Integer.parseInt(request.getParameter("cid")));
			    	 if(rs.next())
			    	 {
		out.println("<form action='FinalEditDeleteProduct' method='post' enctype='multipart/form-data' >");
		out.println("<table><tr><td>");
		out.println(" <table><caption> <b>Product Entry</b></caption><br><br>");

		out.println("<tr><td> <b><i>Employee ID: </b></i></td>  <td> <input type='text' name='peid' value='"+rs.getString(10)+"'> </td></tr>");

		out.println("<tr><td> <b><i>Product ID: </b></i></td>  <td> <input type='text' name='pid' value='"+rs.getString(1)+"'> </td></tr>");

		out.println("<tr><td> <b><i>Product Name: </b></i></td>  <td> <input type='text' name='pname' value='"+rs.getString(2)+"'> </td></tr>");

		out.println("<tr><td> <b><i>Rate: </b></i></td>  <td> <input type='text' name='prate' value='"+rs.getString(4)+"'> </td></tr>");

		out.println("<tr><td> <b><i>Stock: </b></i></td>  <td> <input type='text' name='pstock' value='"+rs.getString(5)+"'> </td></tr>");

		out.println("<tr><td> <b><i>Model No.: </b></i></td>  <td> <input type='text' name='pmno' value='"+rs.getString(3)+"'> </td></tr>");
		out.println("<tr><td> <b><i>Inventory Level : </b></i></td>  <td> <input type='text' name='pinventorylevel' value='"+rs.getString(6)+"'> </td></tr>");
		out.println("<tr><td> <b><i>Category::["+rs.getString(7)+"] </b></i> <input type=hidden name='oldcat' value='"+rs.getString(11)+"'></td>  <td> <select name='pcategory' id='pcategory'> </select> </td></tr>");
		

		out.println("<tr><td> <b><i>Sub Category::["+rs.getString(8)+"]</b></i><input type=hidden name='oldsubcat' value='"+rs.getString(12)+"'></td>  <td> <select name='psubcategory' id='psubcategory'> </select> </td></tr>");
		//out.println("<tr><td> <b><i>Photograph : </b></i></td>  <td> <input type='file' name='pph' value='"+rs.getString(9)+"'> </td></tr>");

		out.println("</table>");
		out.println("<br><br><input type='submit' value='Edit' name='btn'> <input type='submit' value='Delete' name='btn' > ");
		
		out.println("</td> <td>");
		out.println("<img src=/MM/eimages/"+rs.getString(9)+"  width=200 height=200 ><br><br>");
		out.println("<input type='file' name='pph'><br><br>");
		out.println("<input type='submit' value='Edit Picture' name='btn'></td></tr></table>");
		
		out.println("</form>");
		out.println("</html>");

	}
			    	 else
			    	 {out.print("Not Found....");
			    		 }
		  }catch(Exception e)
		  {
			  
			  System.out.println("display product "+e);
		  }
	}

}
