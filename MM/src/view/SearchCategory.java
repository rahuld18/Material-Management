package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchCategory
 */
@WebServlet("/SearchCategory")
public class SearchCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<form action='DisplayCategoryById'>");
		out.println("<table>");
		out.println("<caption><b>Search Category By Id:</b></caption>");
		out.println("<tr><td>Category Id: </td><td><input type='text' name='cid'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit' value='search'>");
		out.println("</form>");
		out.println("</html>");
		out.flush();

	}

	

}
