package jabbour.models;

import java.util.List;

public interface CityDAO {
	public City getCity(int id);
	public List<City> getAllCities();
	public boolean updateCity(City city);
	public void deleteCity(City city);
	//Extra method for getting all Nation capital cities
	public List<City> getAllCaptialCities();
}
