package vn.cloud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.cloud.dao.HomeAdminDao;

@WebServlet(urlPatterns = { "/deleteuser" })
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		Integer Id = Integer.parseInt(req.getParameter("Id"));
		HomeAdminDao had = new HomeAdminDao();
		had.delete(Id);
		resp.sendRedirect("adminhome");
	}
	}

