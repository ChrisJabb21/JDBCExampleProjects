package jabbour.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
    public static Connection getConnection()
    {
      try {
    	  
    	  String config = "src/worldapp.properties";
    	  DriverManager.registerDriver(new Driver());
          //Create Properties object
          Properties props = new Properties();
    	  
    	  //Obtain input stream from config and read and load into props object
    	  FileInputStream fis = new FileInputStream(config);
    	  props.load(fis);
    	  
    	  	// store the values of the property key as a string to use for DB connection 
    	  	String driv = props.getProperty("DRIVER");
			String url = props.getProperty("URL");
			String user = props.getProperty("USER");
			String pass = props.getProperty("PASS");
			
			// initialize driver and create a connection passing in values from config file. 
			Class.forName(driv);
			Connection conn = DriverManager.getConnection(url,user,pass);
    	  
			fis.close();

            return conn;
      }
      catch (SQLException | IOException | ClassNotFoundException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
}
