package vn.cloud.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.Config;
import vn.cloud.connection.DBconnect;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;

@WebServlet(urlPatterns = {"/create"})
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		
		//lấy list server 
		@SuppressWarnings("unchecked")
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		if(info.getRole() == 0)
		{
			req.setAttribute("listserver", listserver);
			RequestDispatcher rq = req.getRequestDispatcher("/views/create.jsp");
			rq.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("page404");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String os = req.getParameter("os");
		String ram  = req.getParameter("ram");
		String cpu = req.getParameter("cpu");
		HomeDao hd = new HomeDao();
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		String port = hd.maxPort();
		String cname = "user" +Integer.toString(info.getId()) +"-" + os + "-" + port;
		String ec2ip ="";
		String server = req.getParameter("server");
		// Lấy thông tin của list server 
		
		//lấy list server 
		@SuppressWarnings("unchecked")
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		// lấy ip theo id
		int _id_server=Integer.parseInt(server);	
		ec2ip = hd.getIp(_id_server);
		
		if(os.equals("Ubuntu"))
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
		}
		hd.insertCreate(cname, info.getId(), ram, cpu, port);
		req.setAttribute("listserver", listserver);
		resp.sendRedirect("home?server="+ server);
		//resp.sendRedirect("home?server=1");
	}
}
