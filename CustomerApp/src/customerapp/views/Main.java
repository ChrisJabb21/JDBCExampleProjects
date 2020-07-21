package customerapp.views;
import customerapp.controllers.*;
import customerapp.models.*;

public class Main {


	public static void main(String[] args) {
		 int prod_code = 0,qty = 0;
		 int cust_num =3;
		 
		//declare our dao helper class objects 
		 //invoke our class methods for project requirements
		 CustomerDAO customerDao= new CustomerDAOClass(); 
		 ProductDAO productDao = new ProductDAOClass();
		 OrderDAO orderDao = new OrderDAOClass();
		 
		 for(Customer c : customerDao.getAllCustomers()) {
			 System.out.println(c.toString());
		 }
		 
		    
		 prod_code= 5;
		 String p_name = "Gaming Headphones";
 		 qty= 5;  //65; //current value
			//Changing quantity

		 Product product = new Product(prod_code, p_name, qty);
		 productDao.updateProduct(product);
		 
		 
		 cust_num = 3; //John Doe
		 prod_code = 6; //Premium Sun Glasses

		 Order order = new Order(cust_num,prod_code);
		 orderDao.deleteOrder(order);
		 
		 /*
		  * Bonus problem with expensive product
		  *  
		  *  status not working in java and sql errors | works in sql statement
		  
		 
		 
		 int customerInp = 1;
		 Customer customer = new Customer(customerInp);
		 customerDao.getExpensiveProductOrderByCust(customer);
		 */
		 
	}
}
