package vn.cloud.controller;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet(urlPatterns = {"/createimage"})
public class CreateImageController extends HttpServlet {
	private static final long serialVersionUID = 8417106439622885184L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String containerId = req.getParameter("cid");
		String name = req.getParameter("name").toLowerCase();
		System.out.println(containerId);
		System.out.println(name);
		HomeDao hd = new HomeDao();
		HttpSession session = req.getSession();
		String ec2ip ="";
		String server = req.getParameter("server");

		
		
		//lấy list server 
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");

		ec2ip = server;//hd.getIp(_id_server);


		
		try {
			hd.createImage(name, containerId,ec2ip);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("listserver", listserver);
		resp.sendRedirect("image?server=" + hd.getId(server));
		
	}

}
