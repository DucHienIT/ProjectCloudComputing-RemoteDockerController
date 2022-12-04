package vn.cloud.model;

public class ImageModel {
	private String repository;
	private String tag;
	private String imageId;
	private String created;
	private String size;

	public ImageModel() {
		super();
	}

	public ImageModel(String repository, String tag, String imageId, String created, String size) {
		super();
		this.repository = repository;
		this.tag = tag;
		this.imageId = imageId;
		this.created = created;
		this.size = size;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getImageId() {
		return imageId;	
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
