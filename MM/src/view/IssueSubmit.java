package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IssueController;
import controller.ProductController;
import model.Issue;

/**
 * Servlet implementation class IssueSubmit
 */
@WebServlet("/IssueSubmit")
public class IssueSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	Issue I=new Issue();
	PrintWriter out=response.getWriter();
	I.setProductid(request.getParameter("pid"));

	I.setEmployeeid(request.getParameter("eid"));

	I.setIssuedate(request.getParameter("isd"));

	I.setQtyissue(request.getParameter("qi"));;

	I.setPurposeofissue(request.getParameter("poi"));
//	boolean st=IssueController.issueProduct(I);
	out.println("<html>");
	
	/*
	if(st)
	{
		
		out.println("Product issue  <a href='IssueView'>Product Issue</a>");
		
	}
	  else
       {out.println("Fail to Issue..<br><a href='IssueView'>Product Issue</a>");}
       out.println("</html>");  
       out.flush();       
*/String status=ProductController.updateStock(Integer.parseInt(request.getParameter("pid")), Integer.parseInt(request.getParameter("qi")),"I");
char sts=status.charAt(0);
out.println("<html>");
if(sts=='1')
{
 boolean st = IssueController.issueProduct(I);
if(st){
out.println(status.substring(1));}
else{out.print("Fail to Submit Record...");}
}
else
{
	out.println(status.substring(1));	
}
	
 
	out.println("<br><a href='IssueView'>Issue another product..</a>");
 out.println("</html>");  
out.flush();   

	}

}
