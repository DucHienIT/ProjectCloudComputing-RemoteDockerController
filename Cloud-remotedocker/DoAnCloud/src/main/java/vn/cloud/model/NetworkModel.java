package vn.cloud.model;

public class NetworkModel {

	private String networkId;
	private String name;
	private String driver;
	private String scope;
	public NetworkModel(String network, String name, String driver, String scope) {
		super();
		this.networkId = network;
		this.name = name;
		this.driver = driver;
		this.scope = scope;
	}
	public NetworkModel() {
		super();
	}
	public String getNetwork() {
		return networkId;
	}
	public void setNetwork(String network) {
		this.networkId = network;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}
