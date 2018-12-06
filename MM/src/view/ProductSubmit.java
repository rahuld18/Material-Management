package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.ProductController;
import model.Products;

/**
 * Servlet implementation class ProductSubmit
 */
@WebServlet("/ProductSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class ProductSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	Products P=new Products();
	PrintWriter out=response.getWriter();
	P.setProductname(request.getParameter("pname"));

	P.setModelno(request.getParameter("pmno"));

	P.setRate(Long.parseLong(request.getParameter("prate")));

	P.setStock(Long.parseLong(request.getParameter("pstock")));

	P.setInventorylevel(request.getParameter("pinventorylevel"));
	P.setCategory(request.getParameter("pcategory"));

	P.setSubcategory(request.getParameter("psubcategory"));
	P.setEmployeeid(Integer.parseInt(request.getParameter("peid")));

	//P.setPhotograph(request.getParameter("pph"));
	
	 Part P1=request.getPart("pph");
     FileUpload F=new FileUpload(P1,"C:/Users/rahul/workspace/MM/WebContent/eimages");
     P.setPhotograph(F.filename);
	
	boolean st=ProductController.addNewRecord(P);
	out.println("<html>");
	if(st)
	{
		out.println("<br>Record Inserted <a href='ProductView'>Add more Employee</a> ");
		
	}
	else
	{
		

		out.println("Record is not Inserted  <a href='ProductView'>Add more Employee</a>");
	}
	
	}

}
