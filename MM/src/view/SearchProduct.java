package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession ses=request.getSession();
		try{
			@SuppressWarnings("deprecation")
			String s=(String)ses.getValue("LTIME").toString();
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("EmployeeLogin");
	    	}
		
PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<form action='DisplayProductById'>");
		out.println("<table>");
		out.println("<caption><b>Search Product By Id:</b></caption>");
		out.println("<tr><td>Product Id: </td><td><input type='text' name='cid'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit' value='search'>");
		out.println("</form>");
		out.println("</html>");
		out.flush();

	}

}
