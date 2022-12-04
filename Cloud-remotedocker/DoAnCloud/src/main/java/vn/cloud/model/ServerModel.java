package vn.cloud.model;

public class ServerModel {
	private int id_server;
	private String ip_server;
	public ServerModel() {
		super();
	}
	public ServerModel(int id_server, String ip_server) {
		super();
		this.id_server = id_server;
		this.ip_server = ip_server;
	}
	public int getId_server() {
		return id_server;
	}
	public void setId_server(int id_server) {
		this.id_server = id_server;
	}
	public String getIp_server() {
		return ip_server;
	}
	public void setIp_server(String ip_server) {
		this.ip_server = ip_server;
	}
}
