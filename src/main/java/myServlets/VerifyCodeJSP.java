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


@WebServlet("/verifycode")
public class VerifyCodeJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 res.setContentType("text/html");
	 PrintWriter out = res.getWriter();
	 HttpSession session= req.getSession();
	 EmailBean user= (EmailBean)session.getAttribute("authcode");
	 String code=req.getParameter("authcode");
	 if(code.equals(user.getCode())) {
		 out.print("<h3 style='color:green'>Verification Done</h3>");
		 HttpSession session1= req.getSession();
		 res.sendRedirect("login.html");
	 }else{
		 out.print("<h3 style='color:red'>Invalid Code !</h3>");
	 }
	}

}
