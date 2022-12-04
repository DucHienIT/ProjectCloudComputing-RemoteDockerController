package vn.cloud.model;

public class DetailModel {
	private String id;
	private String image;
	private String command;
	private String created;
	private String status;
	private String ports;
	private String name;
	public DetailModel() {
		super();
	}
	public DetailModel(String id, String image, String command, String created, String status, String ports,
			String name) {
		super();
		this.id = id;
		this.image = image;
		this.command = command;
		this.created = created;
		this.status = status;
		this.ports = ports;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPorts() {
		return ports;
	}
	public void setPorts(String ports) {
		this.ports = ports;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
 
}
