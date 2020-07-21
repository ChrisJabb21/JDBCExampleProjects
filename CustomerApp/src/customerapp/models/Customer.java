package customerapp.models;

import java.math.BigDecimal;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String city; 
	private String country;

	private String prod_name;
	private int prod_code;
	private BigDecimal price;
	
	private BigDecimal max_purchase;
	
	public Customer() {
		
	}
	
	
	public Customer(String name,String prod_name, BigDecimal max_purchase) {
		this.name = name;
		this.prod_name = prod_name;
		this.max_purchase = max_purchase;
		}
		
	
public Customer(String name,String prod_name,BigDecimal price, BigDecimal max_purchase) {
	this.name = name;
	this.prod_name = prod_name;
	this.price = price;		
	this.max_purchase = max_purchase;
	}
	
public Customer(String name) {
	this.name = name;
	}
	
	
//Constructor for join table

	public Customer(int id, String name, String address, String city, String country, String prod_name, int prod_code,
		BigDecimal price) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.city = city;
	this.country = country;
	this.prod_name = prod_name;
	this.prod_code = prod_code;
	this.price = price;
}

	public Customer(int id) {
		this.id = id;
		// TODO Auto-generated constructor stub
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public void setProdName(String name) {
		this.prod_name = name;
		// TODO Auto-generated method stub
		
	}
	public void setPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		this.price = price;
		
		
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Customer | name= " + name + ", | ProductCode=" + id + " | ProductName= " + prod_name + " | Price=$"
				+ price + " |";
	}

	public BigDecimal getMax_purchase() {
		return max_purchase;
	}

	public void setMax_purchase(BigDecimal max_purchase) {
		this.max_purchase = max_purchase;
	}
	

}
