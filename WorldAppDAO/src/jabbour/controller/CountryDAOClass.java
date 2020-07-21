package jabbour.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jabbour.models.ConnectionFactory;
import jabbour.models.Country;
import jabbour.models.CountryDAO;

public class CountryDAOClass implements CountryDAO {
	
	List<Country> ctryList;
	
	public CountryDAOClass() {
		ctryList = new ArrayList<Country>();
	}
	
	public List <Country> getAllCountries()  {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ViewCityNationDetails");
			//try to get each of columns from SQL City country view 
			
			List<Country> ctryList = new ArrayList<Country>();

			while(rs.next()) {
				Country c = new Country();
				c.setId(rs.getInt("CountryId"));
				c.setName(rs.getString("CountryName"));
				c.setPop(rs.getString("Population"));
				c.setCityId(rs.getInt("CityId"));				
				c.setCityname(rs.getString("City Name"));
				c.setIsCap(rs.getString("isCapital"));
				ctryList.add(c);
			}
			con.close();
			st.close();
			rs.close();
			return ctryList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}

	public Country getCountry(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Country WHERE CountryId="+ id);
			if(rs.next()) {
				Country c = new Country();
				c.setId(rs.getInt("CountryId"));
				c.setName(rs.getString("CityName"));
				c.setPop(rs.getString("Population"));
				c.setId(rs.getInt("CityId"));
				return c;
			}
			con.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

public boolean updateCountry(Country c) {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Country SET CountryName=?, Population=? WHERE CountryId=?");
			ps.setString(2, c.getName());
			ps.setString(3, c.getPop());
			ps.setInt(1, c.getId());
			
			
			int i = ps.executeUpdate();		
		if(i == 1) {
			return true;
		}
		con.close();
		ps.close();
		System.out.println("record updated.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void deleteCountry(Country c)  {
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM Country where CityId = ?");
			ps.setInt(1, c.getId());
			System.out.println("record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
