package customerapp.models;

import java.math.BigDecimal;

public class Order {
	
	private int orderNum;
	private int custNum;
	private int prodCode;
	private BigDecimal price;
	private int quantity;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getCustNum() {
		return custNum;
	}

	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

	public int getProdCode() {
		return prodCode;
	}

	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
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

	public Order(int orderNum, int custNum, int prodCode, BigDecimal price, int quantity) {
		super();
		this.orderNum = orderNum;
		this.custNum = custNum;
		this.prodCode = prodCode;
		this.price = price;
		this.quantity = quantity;
	}

	public Order(int custNum, int prodCode) {
		// TODO Auto-generated constructor 
		this.prodCode= prodCode;
		this.custNum = custNum;
	}

}
