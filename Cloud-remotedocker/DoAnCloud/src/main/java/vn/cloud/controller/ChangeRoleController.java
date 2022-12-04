package vn.cloud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.cloud.dao.HomeAdminDao;
import vn.cloud.model.LoginModel;

@WebServlet(urlPatterns = { "/changerole" })
public class ChangeRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		if(info.getRole() ==1)
		{
			req.setAttribute("Id", req.getParameter("Id"));
		RequestDispatcher rq = req.getRequestDispatcher("/views/changerole.jsp");
		rq.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		Integer Id = Integer.parseInt(req.getParameter("Id")) ;
		String role = req.getParameter("role");
		Integer roles = null;
		System.out.println(role);
		if(role.equals("Admin"))
		{
			roles = 1;
		}
		if(role.equals("User"))
		{
			roles = 0;
		}
		System.out.println(roles);
		HomeAdminDao had = new HomeAdminDao();
		had.changeRole(roles, Id);
		resp.sendRedirect("adminhome");
	}

}
