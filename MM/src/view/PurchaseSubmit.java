package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ProductController;
import controller.PurchaseController;
import model.Purchase;

/**
 * Servlet implementation class PurchaseSubmit
 */
@WebServlet("/PurchaseSubmit")
public class PurchaseSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Purchase P=new Purchase();
		PrintWriter out=response.getWriter();
		P.setEmployeeid(request.getParameter("eid"));
		P.setProductid(request.getParameter("pid"));
		P.setDateofpurchase(request.getParameter("dop"));
		P.setInvoiceno(request.getParameter("in"));
		P.setQtypurchase(request.getParameter("qp"));
		P.setRate(request.getParameter("rate"));
		P.setSuppliername(request.getParameter("sn"));
		P.setRemark(request.getParameter("rk"));
		boolean st=PurchaseController.purchaseProduct(P);
		out.println("<html>");
		if(st)
		{
			String status=ProductController.updateStock(Integer.parseInt(request.getParameter("pid")), Integer.parseInt(request.getParameter("qp")),"P");
			
			out.println(status+"Record Submitted  <a href='PurchaseView'>Purchase Product</a>");
			
		}
		  else
	       {out.println("Fail to Issue..<br><a href='PurchaseView'>Purchse Product</a>");}
	       out.println("</html>");  
	       out.flush();     
	}

}
