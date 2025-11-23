package crudProductManager;

public enum Category {
	PENDING("pending"),
	PROCESSING("processing");
	
	private String type;
	
	Category(String type) {
		this.type = type;
	}
	
	public String getCategory() {
		return this.type;
	}
}
