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
 * Servlet implementation class IssueView
 */
@WebServlet("/IssueView")
public class IssueView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession ses=request.getSession();
		
	
    	
		
		@SuppressWarnings("deprecation")
		Employees A=(Employees)ses.getValue("SEMPLOYEE");
		
/*
		try{
			
			@SuppressWarnings("deprecation")
			String s=(String)ses.getValue("LTIME").toString();
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("EmployeeLogin");
	    	}
	*/	
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/issue.js'></script>");
		
		
		
		out.println("<html>");
		out.println("<form action='IssueSubmit'  method='post'>");
		out.println("<table> <caption><b>Product Issue:</b></caption>");
		out.println("<tr><td><b>Employee Id:</b></td> <td><input type='text' name='eid' id='eid' value="+A.getEmployeeid()+"></td></tr>");
		

		out.println("<tr><td><b>Category Id:</b></td> <td><select name='cid' id='cid'></select></td></tr>");

		out.println("<tr><td><b>Subcategory Id:</b></td> <td><select  name='sid' id='sid'><option>-subcategory-</option></select></td></tr>");

		out.println("<tr><td><b>product Id:</b></td> <td><select  name='pid' id='pid'><option>-product-</option></select></td></tr>");
		out.println("<tr><td><b>Issue Date:</b></td> <td><input type='date' name='isd' id='isd'></td></tr>");
		out.println("<tr><td><b> qty Issue:</b></td> <td><input type='text' name='qi' id='qi'></td></tr>");
		out.println("<tr><td><b> Purpose of Issue:</b></td> <td><input type='text' name='poi' id='poi'></td></tr>");
		out.println("<tr><td><input type=submit></td> <td><input type=reset></td></tr>");
		
		
		out.println("</table>");
		out.println("</html>");
		
		
	}

}
