package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IssueController;


/**
 * Servlet implementation class DisplayIssueById
 */
@WebServlet("/DisplayIssueById")
public class DisplayIssueById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayIssueById() {
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
		out.println("<script src='asset/issue.js'></script>");
		out.println("<html>");
		 try{
			    ResultSet rs=IssueController.displayById(Integer.parseInt(request.getParameter("pid")));
			    System.out.println(rs.next()); System.out.println(rs.getString(5));
			    	 //if(rs.next())
			    	 {
		out.println("<form action='FinalEditDeleteIssue'  method='post'>");
		out.println("<table> <caption><b>Product Issue:</b></caption>");
		out.println("<tr><td><b>Transaction Id:</b></td> <td><input type='text' name='tid' id='tid' value='"+rs.getString(1)+"'></td></tr>");
		out.println("<tr><td><b>Employee Id:</b></td> <td><input type='text' name='eid' id='eid' value="+rs.getString(2)+"></td></tr>");
		

	out.println("<tr><td><b>Category Id:</b></td> <td><select name='cid' id='cid'></select></td></tr>");

		out.println("<tr><td><b>Subcategory Id:</b></td> <td><select  name='sid' id='sid'></select></td></tr>");

		out.println("<tr><td><b>product Id:["+rs.getString(3)+"]</b></td> <td><select  name='pid' id='pid'></select></td></tr>");
		out.println("<tr><td><b>Issue Date:</b></td> <td><input type='date' name='isd' id='isd' value='"+rs.getString(4)+"'></td></tr>");
		out.println("<tr><td><b> qty Issue:</b></td> <td><input type='text' name='qi' id='qi'  value='"+rs.getString(5)+"'></td></tr>");
		out.println("<tr><td><b> Purpose of Issue:</b></td> <td><input type='text' name='poi' id='poi' value="+rs.getString(6)+"></td></tr>");
		out.println("<tr><td><input type=submit value=Edit></td> <td><input type=Submit value=Delete></td></tr>");
			    	 
		out.println("</table></form></html>");
			    	 }
			    	 }catch(Exception e)
					  {
						  
						  System.out.println("display issueby id  "+e);
					  }

	}

}
