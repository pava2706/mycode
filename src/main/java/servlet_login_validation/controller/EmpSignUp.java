package servlet_login_validation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_login_validation.dao.EmpDao;
import servlet_login_validation.dto.EmpDto;

@WebServlet("/signup")
public class EmpSignUp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		//int pwd=Integer.parseInt(pwd1);

		EmpDto dto = new EmpDto();
		dto.setName(name);
		dto.setEmail(email);
		dto.setPwd(pwd);

		EmpDao dao = new EmpDao();
		String msg = dao.create(dto);
		resp.getWriter().print(msg);

	}

}
