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
import beans.HospitalDetailsBean;
import beans.HospitalUpdateBean;

@WebServlet("/hospitallogin")
public class HospitalLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		out.print("<html><body>");
		HospitalDetailsBean hd= new HospitalDetailsBean();
		hd.setEmail(req.getParameter("email"));
		hd.setPassword(req.getParameter("password"));
		
		if(hd.hospitaldetail()) {
			HttpSession session = req.getSession();
			session.setAttribute("email",hd.getEmail());
			session.setAttribute("name",hd.getName());
			session.setAttribute("id",hd.getId());
			session.setAttribute("A",hd.getA_positive());
			session.setAttribute("An",hd.getA_negative());
			session.setAttribute("B",hd.getB_positive());
			session.setAttribute("Bn",hd.getB_negative());
			session.setAttribute("AB",hd.getAB_positive());
			session.setAttribute("ABn",hd.getAB_negative());
			session.setAttribute("O",hd.getO_positive());
			session.setAttribute("On",hd.getO_negative());
			RequestDispatcher rd = req.getRequestDispatcher("/hospitalwelcome.jsp");
			rd.include(req,res);
		}else {
			out.print("<center><h3 style='color:red'>Invalid email and password! <h3></center> ");
			RequestDispatcher rd = req.getRequestDispatcher("/hospitallogin.html");
			rd.include(req,res);
		}
		out.print("</body></html>");
	}

}
