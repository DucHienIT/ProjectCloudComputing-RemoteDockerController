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

import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;

@WebServlet(urlPatterns = {"/createV"})
public class CreateVolumeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String vname= req.getParameter("vname");
		//String ram  = req.getParameter("ram");
		//String cpu = req.getParameter("cpu");
		HomeDao hd = new HomeDao();
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		String port = hd.maxPort();
		String cname = "user" +Integer.toString(info.getId()) +"-" + vname;
		String ec2ip ="";
		String server = req.getParameter("server");
		// Lấy thông tin của list server 
		
		//lấy list server 
		@SuppressWarnings("unchecked")
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		// lấy ip theo id 
		int _id_server=hd.getId(server);	
		ec2ip = hd.getIp(_id_server);
		try {
			hd.createVolume(cname, ec2ip, info.getId());
			//hd.createContainer(cname,"sonvo123/os:ubuntu", ram, cpu, port,ec2ip ,info.getId());
//			System.out.println("ec2_ip: "+ ec2ip);
			System.out.println("create successfull !");}  catch (JSchException e) {
			e.printStackTrace();
		}
		/*if(os.equals("Ubuntu"))
		{
			try {
				hd.createContainer(cname,"sonvo123/os:ubuntu", ram, cpu, port,ec2ip ,info.getId());
				
				
				System.out.println("ec2_ip: "+ ec2ip);
				System.out.println("create successfull !");
			} catch (JSchException e) { 
				e.printStackTrace();
			}
		}
		if(os.equals("Centos"))
		{
			try {
				hd.createContainer(cname,"sonvo123/os:centos", ram, cpu, port,ec2ip,info.getId());
			} catch (JSchException e) {
				e.printStackTrace();
			}
		}*/
		//hd.insertCreate(cname, info.getId(), ram, cpu, port);
		req.setAttribute("listserver", listserver);
		resp.sendRedirect("home?server="+ server);
		//resp.sendRedirect("home?server=1");
	}

}
