package vn.cloud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.cloud.dao.HomeAdminDao;
import vn.cloud.model.LoginModel;

@WebServlet(urlPatterns = {"/adminhome"})
public class HomeAdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		System.out.println(info.getRole());
		if(info.getRole() == 1)
		{
			HomeAdminDao hd =  new HomeAdminDao();
			List<LoginModel> list = hd.getAllUser();
			req.setAttribute("list", list);
			RequestDispatcher rq = req.getRequestDispatcher("/views/homeadmin.jsp");
			rq.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("page404");
		}
	}

}
