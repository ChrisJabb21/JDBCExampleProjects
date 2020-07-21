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
import customerapp.models.Product;
import customerapp.models.ProductDAO;

public class ProductDAOClass implements ProductDAO {
	
	List<Product> prodList;
	
	public ProductDAOClass() {
		prodList = new ArrayList<Product>(); 

	}
	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		try {
		String query = "UPDATE Product SET Quantity=? Where ProductName=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, p.getQuantity());
		pstmt.setString(2, p.getProductName());
		
		int i = pstmt.executeUpdate();
		
		if(i == 1) {
			System.out.println("record updated");
			return true;
		}
		else {
			System.out.println("update failed");	
		}
		con.close();
		pstmt.close();		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			System.out.println("Connection closed...");
		}
		
		return false;

		

		// TODO Auto-generated method stub
		
	}
	
	
	
	


}
