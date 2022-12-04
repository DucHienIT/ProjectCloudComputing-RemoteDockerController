package vn.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.cloud.connection.DBconnect;
import vn.cloud.model.HistoryModel;
import vn.cloud.model.LoginModel;


public class HomeAdminDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<LoginModel> getAllUser() {
		List<LoginModel> list = new ArrayList<LoginModel>();
	
		String sql = "select * from info";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				list.add(new LoginModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch (Exception e) {

	}
		return list;
	}
	public void changeRole(int role,int Id) {
		String sql = "update info set role = ? where Id = ?";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role);
			ps.setInt(2, Id);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
	public void changepassword(String password,int Id) {
		String sql = "update info set password = ? where Id = ?";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, Id);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
	public void delete(int Id) {
		String sql = "delete info where Id = ?";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
	public List<HistoryModel> getallhistory ()
	{
		List<HistoryModel> list = new ArrayList<HistoryModel>();
		// câu truy vấn
		String sql = "select * from containers order by port desc";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				list.add(new HistoryModel(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
		} catch (Exception e) {

		}
		return list;
	}
}
