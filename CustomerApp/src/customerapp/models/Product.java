package customerapp.models;

import java.math.BigDecimal;

public class Product {

	private int productCode;
	private String productName;
	private BigDecimal price;
	private int quantity;
	
	public int getProductCode() {
		return productCode;
	}


	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
	public Product(int productCode, String productName, BigDecimal price, int quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(int productCode, String productName, int quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}

}
