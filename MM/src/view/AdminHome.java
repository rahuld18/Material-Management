package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminModel;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
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
			AdminModel A=(AdminModel)ses.getValue("SADMIN");
	    	
			@SuppressWarnings("deprecation")
			String nav="<h4>"+A.getAdminname()+"["+A.getAdminid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=/MM/eimages/"+A.getPicture()+" width=25 height=25>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='AdminLogout'>Logout</a></h4><hr color='red'>";
	    	out.println(nav);
	    	
	    }catch(Exception e){
		    response.sendRedirect("AdminLogin");
		   
	    	
		    }
	    
	    
	    out.println("<table>");
	   
	    out.println("<tr><td valign='top'>");
        out.println("<a href='CategoryView' target='mw'>Add Category</a><br>");
        out.println("<a href='CategoryList' target='mw'>List Category</a><br>");
        out.println("<a href='SearchCategory' target='mw'>Search Category</a><br>");
        out.println("<a href='SubcategoryView' target='mw'>Add Sub-Category</a><br>");
        out.println("<a href='SubcategoryList' target='mw'>List Sub-Category</a><br>");
        out.println("<a href='SearchSubcategory' target='mw'>Search Sub-Category</a><br>");
        out.println("<a href='EmployeeView' target='mw'>Add Employee</a><br>");
        out.println("<a href='EmployeeList' target='mw'>List Employee</a><br>");
        out.println("<a href='SearchEmployee' target='mw'>Search Employee</a><br>");

	    out.print("</td>");
	    out.println("<td valign='top'><iframe name='mw' frameborder=0 width='800' height='800'></iframe></td>");
	    out.println("</html>");
	}

}
