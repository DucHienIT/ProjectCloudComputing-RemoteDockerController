package vn.cloud.model;

public class HistoryModel {
	private String cname;
	private int userid;
	private int port;
	private String ram;
	private String cpu;
	private String status;
	public HistoryModel() {
		super();
	}
	public HistoryModel(String cname, int userid, int port, String ram, String cpu, String status) {
		super();
		this.cname = cname;
		this.userid = userid;
		this.port = port;
		this.ram = ram;
		this.cpu = cpu;
		this.status = status;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
