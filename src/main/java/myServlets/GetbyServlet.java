package myServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GetbyBean;

@WebServlet("/getbyp")
public class GetbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		GetbyBean gb = new GetbyBean();
		int pin = Integer.parseInt(req.getParameter("pincode"));
		String bg = req.getParameter("bloodGroup");
		gb.setPincode(pin);
		gb.setBloodg(bg);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>User Data</title>");
		out.println("<link rel='stylesheet' type='text/css' href='css/table.css'>");
		out.println(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println(
				"<link href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.2/font/bootstrap-icons.min.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<div class='row'>");
		List<GetbyBean> al = gb.getallrecord();
		if (al != null && !al.isEmpty()) {
			for (GetbyBean vb : al) {	
				out.println("<div class='col-md-6 col-sm-12'>");
				out.println("<div class='card card-custom'>");
				out.println("<div class='card-body'>");
				out.println("<div class='left'>");
				out.println("<h5 class='card-title'>"+vb.getFirstname()+" "+vb.getLastname()+"</h5>");
				out.println("<p><i class='bi bi-envelope'></i> "+ vb.getEmail() + "</p>");
				out.println("<p><i class='bi bi-telephone'></i>" + vb.getMobno() + "</p>");
				out.println("<i class='bi bi-gender-male'></i>" + vb.getGender() + "</p>");
				out.println("<i class='bi bi-calendar3'></i>" + vb.getAge() + "</p>");
				out.println("</div>");
				out.println("<div class='right'>");
				out.println("<i class='bi bi-droplet-fill text-danger'></i> <span class='text-danger'>" + vb.getBloodg() + "</span></p>");	
				out.println("<i class='bi bi-geo-alt'></i>" + vb.getCity() + "</p>");
				out.println("<i class='bi bi-house-door'></i> " + vb.getAddress() + "</p>");
				out.println("<i class='bi bi-flag'></i> " + vb.getState() + "</p>");
				out.println("<i class='bi bi-pin-map'></i>" + vb.getPincode() + "</p>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");	
			}
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
