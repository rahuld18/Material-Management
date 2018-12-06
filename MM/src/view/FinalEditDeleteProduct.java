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
 * Servlet implementation class FinalEditDeleteProduct
 */
@WebServlet("/FinalEditDeleteProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class FinalEditDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		try{
			Products P=new Products();
			String btn=request.getParameter("btn");
		if("Edit".equalsIgnoreCase(btn))
		{
			P.setProductid(Integer.parseInt(request.getParameter("pid")));
			P.setProductname(request.getParameter("pname"));
			

			P.setModelno(request.getParameter("pmno"));

			P.setRate(Long.parseLong(request.getParameter("prate")));

			P.setStock(Long.parseLong(request.getParameter("pstock")));

			P.setInventorylevel(request.getParameter("pinventorylevel"));
			if(request.getParameter("pcategory").equals("-Category-") )//&& request.getParameter("psubcategory").equals(""))
			{	
			/*P.setCategory(request.getParameter("pcategory"));

			P.setSubcategory(request.getParameter("psubcategory"));
			*/
				P.setCategory(request.getParameter("oldcat"));

				P.setSubcategory(request.getParameter("oldsubcat"));
				}
			else
			{
				
				P.setCategory(request.getParameter("pcategory"));

				P.setSubcategory(request.getParameter("psubcategory"));
			}
			
			P.setEmployeeid(Integer.parseInt(request.getParameter("peid")));

			ProductController.editRecord(P);

			
		} 
		else if("Delete".equalsIgnoreCase(btn))
   	 {  int pid=Integer.parseInt(request.getParameter("pid"));
	    ProductController.deleteRecord(pid);
		 
		 }
		
		else if("Edit picture".equalsIgnoreCase(btn))
   	 {  int eid=Integer.parseInt(request.getParameter("pid"));
   	 Part P1=request.getPart("pph");
        FileUpload F=new FileUpload(P1,"C:/Users/rahul/workspace/MM/WebContent/eimages");
     
        ProductController.editPicture(eid,F.filename);
		 
		 } 
		
		response.sendRedirect("ProductList");
		
	}catch(Exception e)
		{
		out.println("FinalEditDelete() "+e);
		
		
	} out.print("</html>");

}
}
