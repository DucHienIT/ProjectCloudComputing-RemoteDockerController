package vn.cloud.controller;

import java.io.IOException;
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
import vn.cloud.dao.HomeDao;
import vn.cloud.model.ImageModel;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;

@WebServlet(urlPatterns = { "/image" })
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1329619935494948047L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HomeDao hd = new HomeDao();
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		
		if (info.getRole() == 0) {
			String name = "user" + Integer.toString(info.getId()) + "-";
			String ec2ip ="";
			String server = req.getParameter("server");
			
			//lấy list server 
			ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
			
			// lấy ip theo id
			int _id_server=Integer.parseInt(server);	
			ec2ip = hd.getIp(_id_server);
			
			CheckTime check = new CheckTime();
			check.checkTimeContainner(name, ec2ip);
			List<ImageModel> list;
			try {
				//test
				System.out.println("name: "+name+", ec2ip: "+ec2ip);
				//--test
				list = hd.listImage(name,ec2ip);
				req.setAttribute("listI", list);
				
				//test
				for(ImageModel imageModel : list ) {
					 System.out.println("image tim duoc la: "+ imageModel.getRepository());	
				}
				//--test
				
			} catch (JSchException e) {
				e.printStackTrace();
			}
			req.setAttribute("server",server);
			req.setAttribute("listserver", listserver);
			resp.setHeader("Refresh", "60");
			RequestDispatcher rq = req.getRequestDispatcher("/views/image.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("page404");
		}
	}

}
