package myServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		out.print("<html><body>");
		HttpSession session = req.getSession(false);
		String email = (String)session.getAttribute("email");
		out.print("<h1>Welcome  "+email+"</h1><br><br>");
		out.print("</body></html>");
		
	}

}
