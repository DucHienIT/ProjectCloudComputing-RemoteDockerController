package vn.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.cloud.connection.DBconnect;
import vn.cloud.model.LoginModel;

public class RegisterDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public LoginModel checkExits(String username) {
		// câu truy vấn
		String sql = "select * from info where username = ?";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				// gắn giá trị bằng kết quả query và trả về
				return new LoginModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
		} catch (Exception e) {

		}
		return null;
	}
	public void register(int Id,String username,String pass)
	{
		String sql = "insert into info values(?,?,?,0)";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);;
			ps.setString(2, username);
			ps.setString(3, pass);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
	
	public int maxId()
	{
		String sql = "select Max(Id) as max from info";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// gắn giá trị bằng kết quả query và trả về
				return  rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}
	public static void main(String[] args) {
		RegisterDao rs = new RegisterDao();
		System.out.println(rs.maxId());
	}
}
