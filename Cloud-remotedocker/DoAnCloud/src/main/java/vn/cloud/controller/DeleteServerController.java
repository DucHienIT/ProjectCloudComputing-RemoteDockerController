package vn.cloud.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.Config;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;

@WebServlet(urlPatterns = {"/deleteserver"})
public class DeleteServerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		HomeDao hd = new HomeDao();
		try {
		String id_server = req.getParameter("server");
		System.out.println(id_server);
		hd.deleteServer(id_server);
		
		//cập nhật lại session
		ArrayList<ServerModel> listserver = new ArrayList<ServerModel>();
		try {
			HomeDao homeDao = new HomeDao();
			listserver = (ArrayList<ServerModel>) homeDao.getListServer();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		session.setAttribute("listserver", listserver);
		
		RequestDispatcher rq = req.getRequestDispatcher("/views/deleteserver.jsp");
		rq.forward(req, resp);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
