package jabbour.models;

public class City {
	private int id;
	
	
	private String name;
	private String isCapital;
	
	public City() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsCapital() {
		return isCapital;
	}
	public void setIsCapital(String isCapital) {
		this.isCapital = isCapital;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", isCapital=" + isCapital + "]";
	}
	
}
