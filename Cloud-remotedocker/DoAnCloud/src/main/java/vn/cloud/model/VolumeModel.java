package vn.cloud.model;

public class VolumeModel {
private String driver;
private String name;
public VolumeModel(String driver,String name) {
	this.setName(name);
	this.setDriver(driver);
}
public String getDriver() {
	return driver;
}
public void setDriver(String driver) {
	this.driver = driver;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
