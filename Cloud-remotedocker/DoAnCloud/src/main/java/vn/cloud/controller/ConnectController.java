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
import vn.cloud.model.ServerModel;


@WebServlet(urlPatterns = { "/connect" })
public class ConnectController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		HomeDao hd = new HomeDao();
		String port = hd.port(name);
		req.setAttribute("port",port);
		String publicip = "";
		String ec2ip ="";
		String server = req.getParameter("server");
		
		//lấy list server 
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		// lấy ip theo id
		int _id_server=Integer.parseInt(server);	
		ec2ip = hd.getIp(_id_server);
		for(ServerModel aModel: listserver) {
			System.out.println("ip: " + aModel.getIp_server());
		}
		
		try {
			publicip = hd.publicIprealtime(ec2ip);
			req.setAttribute("publicip", publicip);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rq = req.getRequestDispatcher("/views/connect.jsp");
		rq.forward(req, resp);
	}

}
