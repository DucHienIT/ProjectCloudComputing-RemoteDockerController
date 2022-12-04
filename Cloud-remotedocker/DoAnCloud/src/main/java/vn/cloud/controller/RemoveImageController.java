package vn.cloud.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.Config;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.ServerModel;
@WebServlet(urlPatterns = { "/removeimage" })
public class RemoveImageController extends HttpServlet {
	private static final long serialVersionUID = 3617282548154327398L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HomeDao hd = new HomeDao();
		String imageId = req.getParameter("imageid");
		String ec2ip ="";
		String server = req.getParameter("server");
		
		// lấy ip theo id
		int _id_server=Integer.parseInt(server);	
		ec2ip = hd.getIp(_id_server);
		
		try {
			hd.removeImage(imageId,ec2ip);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("image?server=" + server);
	}

}
