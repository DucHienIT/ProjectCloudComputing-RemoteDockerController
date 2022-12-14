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
@WebServlet(urlPatterns = { "/removeV" })
public class RemoveVolumeController extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HomeDao hd = new HomeDao();
		String vname = req.getParameter("vname");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		String ec2ip = "";
		String server = req.getParameter("server");
		
		//lấy list server 
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		// lấy ip theo id
		//int _id_server=Integer.parseInt(server);	
		ec2ip =server; //hd.getIp(_id_server);

		try {
			hd.remvoVolume(vname, ec2ip);
			//hd.updateRemove(cid);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (info.getRole() == 0) {
			resp.sendRedirect("home?server=" + hd.getId(server));
		} else {
			resp.sendRedirect("admincontainer?server=" + hd.getId(server));
		}
	}
}
