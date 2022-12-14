package vn.cloud.model;

public class NetworkModel {

	private String networkId;
	private String name;
	private String driver;
	private String scope;
	
	public NetworkModel() {
		super();
	}
	 
	public NetworkModel(String networkId, String name, String driver, String scope) {
		super();
		this.networkId = networkId;
		this.name = name;
		this.driver = driver;
		this.scope = scope;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
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
