package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IssueController;
import model.Issue;

/**
 * Servlet implementation class FinalEditDeleteIssue
 */
@WebServlet("/FinalEditDeleteIssue")
public class FinalEditDeleteIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteIssue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		try{
			String btn=request.getParameter("btn");
			Issue I=new Issue();
			if("Edit".equalsIgnoreCase(btn))
			{
			I.setProductid(request.getParameter("pid"));

			I.setEmployeeid(request.getParameter("eid"));

			I.setIssuedate(request.getParameter("isd"));

			I.setQtyissue(request.getParameter("qi"));;

			I.setPurposeofissue(request.getParameter("poi"));

		IssueController.editRecord(I);
			}
			else if("Delete".equalsIgnoreCase(btn))
		   	 {  int pid=Integer.parseInt(request.getParameter("tid"));
			    IssueController.deleteRecord(pid);
				 
				 }
			
			response.sendRedirect("IssueList");
			}catch(Exception e)
			{
			out.println("FinalEditDelete() "+e);
			
			
		} out.print("</html>");


			}

		

		
	}


