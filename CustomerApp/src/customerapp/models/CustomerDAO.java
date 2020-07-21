package customerapp.models;

import java.util.List;

public interface CustomerDAO {
	
	
	//Crud operations.
	public List<Customer> getAllCustomers();
	public List<Customer> getExpensiveProductOrderByCust(Customer customer);

	
}
