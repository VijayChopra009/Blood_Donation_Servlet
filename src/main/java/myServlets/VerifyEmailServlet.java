package myServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EmailBean;
import myjava.SendEmail;



@WebServlet("/verify")
public class VerifyEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		String email=req.getParameter("email");
			SendEmail sm= new SendEmail();
			String code=sm.random();
			
			EmailBean user= new EmailBean(email,code);
			boolean test= sm.sendEmail(user);
			
			if(test) {
				HttpSession session=req.getSession();
				session.setAttribute("authcode",user);
				res.sendRedirect("verify.html");
			}
	}

}
