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
import model.Employees;

/**
 * Servlet implementation class DisplayPurchaseById
 */
@WebServlet("/DisplayPurchaseById")
public class DisplayPurchaseById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPurchaseById() {
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

	
    	
		
		@SuppressWarnings("unused")
		Employees A=(Employees)ses.getValue("SEMPLOYEE");
		
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/issue.js'></script>");
		 try{
			    ResultSet rs=PurchaseController.displayById(Integer.parseInt(request.getParameter("cid")));
			    	 if(rs.next())
			    	 {
		
		

		out.println("<html>");
		out.println("<form action='FinalEditDeletePurchase'  method='post'>");
		out.println("<table> <caption><b>Product Issue:</b></caption>");
		
		
		out.println("<tr><td><b>Transaction Id:</b></td> <td><input type='text' name='eid' id='eid' value="+rs.getString(1)+"></td></tr>");
		
		out.println("<tr><td><b>Employee Id:</b></td> <td><input type='text' name='eid' id='eid' value="+rs.getString(2)+"></td></tr>");
		

		out.println("<tr><td><b>Category Id:</b></td> <td><select name='cid' id='cid'></select></td></tr>");

		out.println("<tr><td><b>Subcategory Id:</b></td> <td><select  name='sid' id='sid'></select></td></tr>");

		out.println("<tr><td><b>product name:</b></td> <td><select  name='pid' id='pid' value="+rs.getString(3)+" ></select></td></tr>");
		out.println("<tr><td><b> Date Of Purchase:</b></td> <td><input type='date' name='dop' id='dop' value="+rs.getString(8)+"></td></tr>");
		out.println("<tr><td><b>Supplier Name :</b></td> <td><input type='text' name='sn' id='sn' value="+rs.getString(4)+"></td></tr>");

		out.println("<tr><td><b> Invoice no:</b></td> <td><input type='text' name='in' id='in' value="+rs.getString(5)+"></td></tr>");
		out.println("<tr><td><b> Rate:</b></td> <td><input type='text' name='rate' id='rate' value="+rs.getString(7)+"></td></tr>");
		out.println("<tr><td><b> Quantity Purchase:</b></td> <td><input type='text' name='qp' id='qp' value="+rs.getString(6)+"></td></tr>");
	

		out.println("<tr><td><b> Remark:</b></td> <td><input type='text' name='rk' id='rk' value="+rs.getString(9)+"></td></tr>");
		out.println("<tr><td><input type=submit></td> <td><input type=reset></td></tr>");
		
		
		out.println("</table>");
		out.println("</html>");
			    	 }
   	 else
   	 {out.print("Not Found....");
   		 }

}catch(Exception e)
{
System.out.println("display purchase "+e);

}

	}

}
