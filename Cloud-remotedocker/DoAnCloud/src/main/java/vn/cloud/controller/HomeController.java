package vn.cloud.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.CheckTime;
import vn.cloud.config.Config;
import vn.cloud.connection.DBconnect;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;
import vn.cloud.model.DetailModel;;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{	
		HomeDao hd = new HomeDao();
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
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
	
		//show các container
		if(info.getRole() == 0)
		{
			String name = "user" + Integer.toString(info.getId()) + "-";
			CheckTime check = new CheckTime();
			check.checkTimeContainner(name, ec2ip);
			  HomeDao p = new HomeDao(); 
			  List<DetailModel> newlist; 
			  try {
				newlist = p.getDetail(name, ec2ip);
				req.setAttribute("listC", newlist);
				
			} catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("server",server);
			req.setAttribute("listserver", listserver);
			resp.setHeader("Refresh", "60");
			RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
			rq.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("page404");
		}
	}
}
