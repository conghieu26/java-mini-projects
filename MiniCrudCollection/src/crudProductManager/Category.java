package crudProductManager;

public enum Category {
	PENDING("Pending"),
	PROGRESS("Progress");
	
	private String type;
	
	Category(String type){
		this.type = type;
	}
	
	public String getType() {
		return type; 
	}
}
