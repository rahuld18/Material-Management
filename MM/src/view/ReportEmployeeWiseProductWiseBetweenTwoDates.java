package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportEmployeeWiseProductWiseBetweenTwoDates
 */
@WebServlet("/ReportEmployeeWiseProductWiseBetweenTwoDates")
public class ReportEmployeeWiseProductWiseBetweenTwoDates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportEmployeeWiseProductWiseBetweenTwoDates() {
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
		out.println("<script src='asset/employeereport.js'></script>");
		
		out.println("<html>");
		  out.println("<center><table>");
		out.println("<tr><td><b>Employee Name:</b></td><td><select id=eid><option>-Employee Name-</option><select></td>");

		out.println("<td><select id=status><option>-Purchase/Issue-</option><option>Issue</option><option>Purchase</option><select></td>  <td>From:<input type=date id=datefrom></td><td>To:<input type=date id=dateto></td><td><input type='submit' value='Search' id='searchbtn'></td> </tr>");		
		

		out.println("</center></table>");
		out.println("<br><div id='result'></div></html>");
		
	}

}
