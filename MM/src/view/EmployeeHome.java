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
 * Servlet implementation class EmployeeHome
 */
@WebServlet("/EmployeeHome")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  

		PrintWriter out = response.getWriter();	 
	    out.println("<html>");
	    try{
	    	HttpSession ses=request.getSession();
	    	
			@SuppressWarnings("deprecation")
			Employees A=(Employees)ses.getValue("SEMPLOYEE");
	    	
			@SuppressWarnings("deprecation")
			
			String nav="<h4>"+A.getEmployeename()+"["+A.getEmployeeid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=/MM/eimages/"+A.getPhotograph()+" width=25 height=25>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='EmployeeLogout'>Logout</a></h4><hr color='red'>";
			
			out.println(nav);
	    	
	    }catch(Exception e){
		    response.sendRedirect("EmployeeLogin");
		   
	    	
		    }
	    
	    
		
	    out.println("<table>");
	   
	    out.println("<tr><td valign='top'>");
        out.println("<a href='ProductView' target='mw'>Add Product</a><br>");
        out.println("<a href='ProductList' target='mw'>List Product</a><br>");
        out.println("<a href='SearchProduct' target='mw'>Search Product</a><br>");
        
        out.println("<a href='IssueView' target='mw'> Issue Product</a><br>");
        out.println("<a href='IssueList' target='mw'>List Issue</a><br>");

        out.println("<a href='PurchaseView' target='mw'> Purchase Product</a><br>");
        out.println("<a href='PurchaseList' target='mw'>List Purchase</a><br>");
       
	    out.print("</td>");
	    out.println("<td valign='top'><iframe name='mw' frameborder=0 width='800' height='800'></iframe></td>");
	    out.println("</html>");
		
	}

}
