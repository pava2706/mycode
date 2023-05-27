package servlet_login_validation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

import servlet_login_validation.dao.EmpDao;
import servlet_login_validation.dto.EmpDto;

@WebServlet("/login")
public class EmpLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		String email = req.getParameter("email");
		String fpwd = req.getParameter("pwd");
		//int fpwd = Integer.parseInt(pwd);

		EmpDao dao = new EmpDao();
		EmpDto d1 = dao.login(email);
		if (d1 != null) {
			if (d1.getPwd().equals(fpwd)) {
				resp.getWriter().print("<a href='http://www.facebook.com'>click</a>");
				resp.sendRedirect("http://www.facebook.com");
			} else {
				resp.getWriter().print("<h1> password incorrect please enter valid password</h1>");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			}
		} else {
			resp.getWriter().print(
					"<h1>User Account is not found,Please SIGNUP</h1><a href='signup.html'>click here to signup</a>");
		}
	}
}
