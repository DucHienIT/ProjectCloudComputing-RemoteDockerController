package vn.cloud.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import vn.cloud.config.Config;

public class DBconnect {
	String serverName = Config.ipServer1; // thầy thay đổi địa chỉ ip public của ec2
	String dbName = Config.databaseName; // tên database đã import
	String portNumber = "1433"; 
	String instance = "";
	String userID = Config.userSql; //tài khoản kết nối sql
	String password = Config.pasSql; // mật khẩu tài khoản kết nối sql
	public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    } 	
	public static void main(String[] args) {
		try {
			System.out.println(new DBconnect().getConnection());
	}catch(Exception e) {
		}
	}

}
