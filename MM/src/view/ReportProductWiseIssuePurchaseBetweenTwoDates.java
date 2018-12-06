package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportProductWiseIssuePurchaseBetweenTwoDates
 */
@WebServlet("/ReportProductWiseIssuePurchaseBetweenTwoDates")
public class ReportProductWiseIssuePurchaseBetweenTwoDates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportProductWiseIssuePurchaseBetweenTwoDates() {
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
		
		out.println("<script src='asset/productreport.js'></script>");
		
		
		   out.println("<html>");
		   out.println("<center><table>");
		   out.println("<tr><td><b>Category Id:</b></td> <td><select name='cid' id='cid'></select></td></tr>");

			out.println("<tr><td><b>Subcategory Id:</b></td> <td><select  name='sid' id='sid'><option>-subcategory-</option></select></td></tr>");

		   out.println("<tr><td><select id=pid><option>-Choose Product-</option></select></td><td><select id=status><option>Issue/Purchase</option><option>Issue</option><option>Purchase</option></select></td><td>From:<input type=date id=datefrom></td><td>To:<input type=date id=dateto></td><td><input type='submit' value='Search' id='searchbtn'></tr>");
		   out.println("</table>");
		   out.println("<br><div id='result'></div></center></html>");
			  
		   out.println("</table></html>");
		   out.close();
		   
	}

}
