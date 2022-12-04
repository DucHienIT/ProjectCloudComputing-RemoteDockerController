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

@WebServlet(urlPatterns = {"/addserver"})
public class AddServerController extends HttpServlet {
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
		String ip_server = req.getParameter("ip_server");
		hd.insertServer(ip_server);
		
		ArrayList<ServerModel> listserver = new ArrayList<ServerModel>();
		try {
			listserver = (ArrayList<ServerModel>) hd.getListServer();
		}
		catch (Exception e) {
			System.out.println(e);
		}	
		session.setAttribute("listserver", listserver);	
		}
		catch (Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rq = req.getRequestDispatcher("/views/addserver.jsp");
		rq.forward(req, resp);
	}

}
