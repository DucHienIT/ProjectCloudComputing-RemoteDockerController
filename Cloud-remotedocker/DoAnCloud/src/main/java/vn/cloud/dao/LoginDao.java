package vn.cloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.cloud.connection.DBconnect;
import vn.cloud.model.LoginModel;

public class LoginDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public LoginModel Login(String username,String password) {
		// câu truy vấn
		String sql = "select * from info where username = ? and password = ?";
		try {
			// kết nối sql
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				// gắn giá trị bằng kết quả query và trả về
				return new LoginModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
		} catch (Exception e) {

		}
		return null;
	}
}
