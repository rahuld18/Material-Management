package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employees;

/**
 * Servlet implementation class ProductView
 */
@WebServlet("/ProductView")
public class ProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession();
    	
		
		Employees A=(Employees)ses.getValue("SEMPLOYEE");
		

		
		try{
			
			@SuppressWarnings("unused")
			String s=(String)ses.getValue("LTIME").toString();
			
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("EmployeeLogin");
	    	}
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/categorysubcategory.js'></script>");
		out.println("<html>");
		
		
		out.println("<form action='ProductSubmit' method='post' enctype='multipart/form-data' >");
		out.println(" <table><caption> <b>Product Entry</b></caption><br><br>");

		out.println("<tr><td> <b><i>Employee ID: </b></i></td>  <td> <input type='text' name='peid' value='"+A.getEmployeeid()+"'> </td></tr>");
	
out.println("<tr><td> <b><i>Category: </b></i></td>  <td> <select name='pcategory' id='pcategory'> </select> </td></tr>");
		

		out.println("<tr><td> <b><i>Sub Category: </b></i></td>  <td> <select name='psubcategory' id='psubcategory'> <option>-subcategory-</option></select> </td></tr>");
		
		out.println("<tr><td> <b><i>Product Name: </b></i></td>  <td> <input type='text' name='pname'> </td></tr>");

		out.println("<tr><td> <b><i>Rate: </b></i></td>  <td> <input type='text' name='prate'> </td></tr>");

		out.println("<tr><td> <b><i>Stock: </b></i></td>  <td> <input type='text' name='pstock'> </td></tr>");

		out.println("<tr><td> <b><i>Model No.: </b></i></td>  <td> <input type='text' name='pmno'> </td></tr>");
		out.println("<tr><td> <b><i>Inventory Level : </b></i></td>  <td> <input type='text' name='pinventorylevel'> </td></tr>");
		out.println("<tr><td> <b><i>Photograph : </b></i></td>  <td> <input type='file' name='pph'> </td></tr>");
		out.println("</table>");
		out.println("<br><br> <input type='submit'> <input type='reset' > ");
		
		
		out.println("</form>");
		out.println("</html>");
	}

}
