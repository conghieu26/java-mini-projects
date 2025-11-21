package ex;

public class Customer {
	private String id;
    private String name;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return id + " - " + name;
	}
  
}
