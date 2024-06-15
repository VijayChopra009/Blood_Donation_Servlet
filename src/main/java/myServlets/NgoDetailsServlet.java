package myServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.NgoDetailBean;

@WebServlet("/ngo")
public class NgoDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<html><body>");
		NgoDetailBean nb= new NgoDetailBean();
		nb.setDate(req.getParameter("date"));
		nb.setAddress(req.getParameter("address"));
		nb.setCity(req.getParameter("city"));
		nb.setPincode(Integer.parseInt(req.getParameter("pincode")));
		nb.setState(req.getParameter("state"));
		nb.setContact(Long.parseLong(req.getParameter("contact")));
		nb.setDetails(req.getParameter("details"));
		if(nb.ngoverify()) {
			HttpSession session = req.getSession();
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req,res);
		}else {
			out.print("<center><h3 style='color:red'>Error Occured <h3></center> ");
			RequestDispatcher rd = req.getRequestDispatcher("/ngo.html");
			rd.include(req,res);
		}
		out.print("</body></html>");
		}
		
}
