package vn.cloud.config;

public class Config {
	
	  public static String ipServer1 = "3.229.202.186"; // thay đổi ip bằng ip public trên ec2 chứa database 
	  public static String userSql = "SA"; // thay đổi tài khoản đăng nhập sql container 
	  public static String pasSql = "MatKhau*123"; // thay đổi mật khẩu đăng nhập sql container //

	public static String privatekeyPath = "/usr/local/tomcat/webapps/DoAnCloud.pem" //Địa chỉ của file pem trong máy EC2 AWS
	public static String databaseName = "usercloud";

	/*
	 * public static String ipServer1 = "DESKTOP-V2MH4TM"; // thay đổi ip bằng ip public trên ec2 chứa database
	 * public static String userSql = "sa"; // thay đổi tài khoản đăng nhập sql container
	 * public static String pasSql = "duc2112002"; // thay đổi mật khẩu đăng nhập sql container //
	 * public static String privatekeyPath = "C:\\Users\\tranc\\cloud\\newubuntu1.pem"; // thay đổi path của key ec2
	 *  
	 * public static String privatekeyPath = "/usr/local/tomcat/webapps/DoAnCloud.pem";
	 * public static String databaseName = "usercloud";
	 * 
	 */
	  
	  

}
