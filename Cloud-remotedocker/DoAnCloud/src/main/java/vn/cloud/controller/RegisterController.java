package vn.cloud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.cloud.dao.RegisterDao;
import vn.cloud.model.LoginModel;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("username");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		if(!pass.equals(repass))
		{
			req.setAttribute("mess",1);
			RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
			rq.forward(req, resp);
		}
		else
		{
			RegisterDao  rg = new RegisterDao();
			LoginModel a = rg.checkExits(name);
			if(a== null)
			{
				int id = rg.maxId() + 1;
				rg.register(id, name, pass);
				resp.sendRedirect("login");
				
			}
			else
			{
				req.setAttribute("mess", 2);
				RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
				rq.forward(req, resp);
			}
		}
	}

	}
