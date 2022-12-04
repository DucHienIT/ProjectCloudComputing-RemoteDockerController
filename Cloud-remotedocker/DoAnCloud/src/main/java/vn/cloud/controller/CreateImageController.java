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
		
		// lấy ip theo id
		int _id_server=Integer.parseInt(server);	
		ec2ip = hd.getIp(_id_server);
		
//		ArrayList<ServerModel> listserver = new ArrayList<ServerModel>();
//		try {
//			HomeDao homeDao = new HomeDao();
//			listserver = (ArrayList<ServerModel>) homeDao.getListServer();
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		int _id_server=Integer.parseInt(server);	
//		
//		for (ServerModel _server  : listserver) {
//			  int id_server=_server.getId_server();
//			  //String _id_server =_String.valueOf(id_server);
//		      if(id_server==_id_server) {
//		    	  String ip_server=_server.getIp_server();
//		    	  ec2ip=ip_server;
//		    	  System.out.println(id_server);
//		    	  System.out.println(_id_server);
//		    	  System.out.println(ec2ip);
//		    	  break;
//		      }
//		    }
		
		try {
			hd.createImage(name, containerId,ec2ip);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("listserver", listserver);
		resp.sendRedirect("image?server=" + server);
		
	}

}
