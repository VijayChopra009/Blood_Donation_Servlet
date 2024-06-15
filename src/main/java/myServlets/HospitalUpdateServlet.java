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

import beans.DonorRegisterBean;
import beans.HospitalUpdateBean;

@WebServlet("/updatehospital")
public class HospitalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		HospitalUpdateBean hu=new HospitalUpdateBean();
		hu.setEmail(req.getParameter("email"));
		hu.setName(req.getParameter("name"));
		hu.setA_positive(Integer.parseInt(req.getParameter("aPositive")));
		hu.setB_positive(Integer.parseInt(req.getParameter("bPositive")));
		hu.setAB_positive(Integer.parseInt(req.getParameter("abPositive")));
		hu.setO_positive(Integer.parseInt(req.getParameter("oPositive")));
		hu.setA_negative(Integer.parseInt(req.getParameter("aNegative")));
		hu.setB_negative(Integer.parseInt(req.getParameter("bNegative")));
		hu.setAB_negative(Integer.parseInt(req.getParameter("abNegative")));
		hu.setO_negative(Integer.parseInt(req.getParameter("oNegative")));
		
		if(hu.updatehospital()) {
			HttpSession session = req.getSession();
			session.setAttribute("email",hu.getEmail());
			session.setAttribute("name",hu.getName());
			session.setAttribute("A",hu.getA_positive());
			session.setAttribute("An",hu.getA_negative());
			session.setAttribute("B",hu.getB_positive());
			session.setAttribute("Bn",hu.getB_negative());
			session.setAttribute("AB",hu.getAB_positive());
			session.setAttribute("ABn",hu.getAB_negative());
			session.setAttribute("O",hu.getO_positive());
			session.setAttribute("On",hu.getO_negative());
			out.print("<h3 style='color:green'>updated  successfull ...</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("/updatehospital.jsp");
			rd.include(req, res);
		}else {
			out.print("<br><h3 style='color:red'>Error !</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("/hospitalwelcome.jsp");
			rd.include(req, res);
		}
		
	}

}
