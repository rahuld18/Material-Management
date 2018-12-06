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
 * Servlet implementation class PurchaseView
 */
@WebServlet("/PurchaseView")
public class PurchaseView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession ses=request.getSession();

	
    	
		
		Employees A=(Employees)ses.getValue("SEMPLOYEE");
		

		try{
			
			String s=(String)ses.getValue("LTIME").toString();
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("EmployeeLogin");
	    	}
		
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/issue.js'></script>");
		
		
		
		out.println("<html>");
		out.println("<form action='PurchaseSubmit'  method='post'>");
		out.println("<table> <caption><b>Product Issue:</b></caption>");
		out.println("<tr><td><b>Employee Id:</b></td> <td><input type='text' name='eid' id='eid' value='"+A.getEmployeeid()+"'></td></tr>");
		

		out.println("<tr><td><b>Category Id:</b></td> <td><select name='cid' id='cid'></select></td></tr>");

		out.println("<tr><td><b>Subcategory Id:</b></td> <td><select  name='sid' id='sid'><option>-subcategory-</option></select></td></tr>");

		out.println("<tr><td><b>product Id:</b></td> <td><select  name='pid' id='pid'><option>-product-</option></select></td></tr>");
		out.println("<tr><td><b> Date Of Purchase:</b></td> <td><input type='date' name='dop' id='dop'></td></tr>");
		out.println("<tr><td><b>Supplier Name :</b></td> <td><input type='text' name='sn' id='sn'></td></tr>");

		out.println("<tr><td><b> Invoice no:</b></td> <td><input type='text' name='in' id='in'></td></tr>");
		out.println("<tr><td><b> Rate:</b></td> <td><input type='text' name='rate' id='rate'></td></tr>");
		out.println("<tr><td><b> Quantity Purchase:</b></td> <td><input type=hidden name='tid' ><input type='text' name='qp' id='qp'></td></tr>");
	

		out.println("<tr><td><b> Remark:</b></td> <td><input type='text' name='rk' id='rk'></td></tr>");
		out.println("<tr><td><input type=submit></td> <td><input type=reset></td></tr>");
		
		
		out.println("</table>");
		out.println("</html>");
		
		
		
	}

}
