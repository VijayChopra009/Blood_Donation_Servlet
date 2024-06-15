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

import beans.DonorLoginBean;


//@WebServlet(name = "someThing", urlPatterns = {"/login"})
@WebServlet("/login")
public class DonorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		out.print("<html><body>");
		DonorLoginBean lb = new DonorLoginBean();
		lb.setEmail(req.getParameter("email"));
		lb.setPassword(req.getParameter("password"));
		
		if(lb.lverify()) {
			HttpSession session = req.getSession();
			session.setAttribute("email",lb.getEmail());
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.forward(req,res);
		}else {
			out.print("<center><h3 style='color:red'>Invalid email and password! <h3></center> ");
			RequestDispatcher rd = req.getRequestDispatcher("/donorlogin.html");
			rd.include(req,res);
		}
		out.print("</body></html>");
	}

}
