package jabbour.models;

import java.util.List;

public interface CountryDAO {
	public Country getCountry(int id);
	public List<Country> getAllCountries();
	public boolean updateCountry(Country c);
	public void deleteCountry(Country c);
	

}
