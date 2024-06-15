package myServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DonorRegisterBean;

@WebServlet("/register")
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		DonorRegisterBean rb = new DonorRegisterBean();
		rb.setFirstname(req.getParameter("firstname").trim());
		rb.setLastname(req.getParameter("lastname").trim());
		rb.setEmail(req.getParameter("email").trim());
		rb.setPassword(req.getParameter("password"));
		rb.setMobno(Long.parseLong(req.getParameter("mobno").trim()));
		rb.setGender(req.getParameter("gender"));
		rb.setAge(Integer.parseInt(req.getParameter("age").trim()));
		rb.setBloodg(req.getParameter("bloodGroup").trim());
		rb.setState(req.getParameter("state").trim());
		rb.setAddress(req.getParameter("address").trim());
		rb.setCity(req.getParameter("city").trim());
		rb.setPincode(Integer.parseInt(req.getParameter("pincode").trim()));
		rb.setLocation(req.getParameter("live_loc").trim());
		
		if(rb.registerverify()) {
			out.print("<h3 style='color:green'>Registration successfull ...</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("/donorlogin.html");
			rd.include(req, res);
		}else {
			out.print("<br><h3 style='color:red'>Invalid Data inserted registeration not Completed !</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("/donorregister.html");
			rd.include(req, res);
		}
		
	}

}
