package customerapp.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import customerapp.models.ConnectionManager;
import customerapp.models.Customer;
import customerapp.models.CustomerDAO;

public class CustomerDAOClass implements CustomerDAO {
	
	List<Customer> custList;
	
	public CustomerDAOClass() {
		custList = new ArrayList<Customer>(); 
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		String query = "SELECT Customer.CustomerNumber, Customer.CustomerName, Orders.ProductCode, Product.ProductName, Product.Price\r\n" + 
				"FROM ((Orders\r\n" + 
				" inner join Customer ON Orders.CustomerNumber = Customer.CustomerNumber)\r\n" + 
				"inner join Product on Orders.ProductCode= Product.ProductCode) ORDER BY CustomerNumber;";
		Connection con = ConnectionManager.getConnection();
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		List<Customer> custList = new ArrayList<Customer>(); 
		
		while (rs.next()) {
			Customer c= new Customer(); 
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setId(rs.getInt(3));
				c.setProdName(rs.getString(4));
				c.setPrice(rs.getBigDecimal(5));
				custList.add(c);
		}
		con.close();
		stmt.close();
		rs.close();
		return custList;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
		}

	public List<Customer> getExpensiveProductOrderByCust(Customer customer) {
		

	Connection con = ConnectionManager.getConnection();
	try {
		String query = "SELECT CustomerNumber, CustomerName, ProductName, MAX(Price) as 'Most Expensive Product Ordered'\r\n" + 
				"FROM ((Orders inner join Product on Product.ProductCode = Orders.ProductCode)\r\n" + 
				"inner join Customer on Customer.CustomerNumber = Orders.CustomerNumber);";

		Statement stmt = con.prepareStatement(query);

		con.close();
		stmt.close();

		} catch (Exception e) {
		e.printStackTrace();
		
	}
		// TODO Auto-generated method stub
		return null;
	}
}