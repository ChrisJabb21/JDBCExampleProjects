package jabbour.main;

import jabbour.controller.CityDAOClass;
import jabbour.controller.CountryDAOClass;
import jabbour.models.City;
import jabbour.models.CityDAO;
import jabbour.models.Country;
import jabbour.models.CountryDAO;

public class MainClass {

	public static void main(String[] args) {
		CountryDAO CoDAO = new CountryDAOClass();
		CityDAO CityDAO = new CityDAOClass();
		
	
		//ask for input 
		
		//control flow into a while loop 
		// show a menu of choices for World Atlas DAO operation
		
		
		for (Country c : CoDAO.getAllCountries()) {
			System.out.println("Country [id=" + c.getId() + ", name=" + c.getName() + ", population (in est. millions)=" + c.getPop() + " | CityId=" + c.getCityId() + " , CityName="  + c.getCityname() + ", isCapital= "+ c.getIsCap() + "]");
		}
		
		for(City c: CityDAO.getAllCities()) {
			System.out.println("City [id=" + c.getId() + ", name=" + c.getName() + ", isCapital=" + c.getIsCapital() + "]");
		}
		
		System.out.println("*****************************");
		CityDAO.getCity(3);
		System.out.println("*****************************");
		
		for (City c : CityDAO.getAllCaptialCities()) {
			
			System.out.println("City [id=" + c.getId() + ", name=" + c.getName() + ", isCapital=" + c.getIsCapital() + "]");
		}
	}

}
