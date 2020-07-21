package jabbour.models;

public class Country {
	private int id;
	private String name;
	private String population;
	private int CityId;
	
	/*fields for city  field to be able to show the columns 
	 * from my CityNationdetails view in sql query statment*/
	private String cityname;
	private String isCap;
	
	public Country() {
	}
	
	public Country(int id, String name, String population, int cityId) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.CityId = cityId;
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
	public String getPop() {
		return population;
	}
	public void setPop(String population) {
		this.population = population;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		this.CityId = cityId;
	}
	
	public String getCityname() {
		return cityname;
	}
	public void setCityName(String cityname) {
		this.cityname = cityname;
	}
	public String getIsCap() {
		return isCap;
	}
	public void setIsCap(String isCap) {
		this.isCap = isCap;
	}
	
}
