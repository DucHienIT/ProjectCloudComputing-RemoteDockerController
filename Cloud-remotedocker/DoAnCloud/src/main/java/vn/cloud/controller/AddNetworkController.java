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

import vn.cloud.config.CheckTime;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;

@WebServlet(urlPatterns = {"/addN"})
public class AddNetworkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//Lây các para
		String name = req.getParameter("nName");
		String server  = req.getParameter("server");
		String driver = req.getParameter("driver");
		HomeDao hd = new HomeDao();
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		String port = hd.maxPort();
		
		// Lấy thông tin của list server 
		
		//lấy list server 
		@SuppressWarnings("unchecked")
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		// lấy ip theo id
		
			try {
				hd.createNetwork(name,driver, server); //Gọi hamf tạo network
				System.out.println("create successfull !");
			} catch (JSchException e) {}
		
		req.setAttribute("listserver", listserver);
		resp.sendRedirect("admincontainer?server="+ Integer.toString(hd.getId(server)));  
		//resp.sendRedirect("home?server=1");
	}
}
