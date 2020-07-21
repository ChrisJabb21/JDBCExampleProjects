package customerapp.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customerapp.models.ConnectionManager;
import customerapp.models.Order;
import customerapp.models.OrderDAO;

public class OrderDAOClass implements OrderDAO {

	@Override
	public void deleteOrder(Order o) {
		Connection con = ConnectionManager.getConnection();
		// Delete orders based on product id for specific customer.
		try {
		String query = "DELETE Orders FROM((Orders\r\n" + 
				"inner join Product on Orders.ProductCode= Product.ProductCode)\r\n" + 
				" inner join Customer ON Orders.CustomerNumber = Customer.CustomerNumber)\r\n" + 
				"where Orders.CustomerNumber=? and Orders.ProductCode=?;"; 
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,o.getCustNum());
		pstmt.setInt(2,o.getProdCode());
		
		pstmt.executeUpdate();
		
		System.out.println("records deleted");
		
		con.close();
		pstmt.close();

		} catch (Exception e) {
			System.out.println("Error occured when trying to delete record.");
			e.printStackTrace();
			
		}
		finally {
			System.out.println("Connections closing...");
		}
	}
}
