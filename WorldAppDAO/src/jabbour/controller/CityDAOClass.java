package jabbour.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jabbour.models.ConnectionFactory;
import jabbour.models.City;
import jabbour.models.CityDAO;

public class CityDAOClass implements CityDAO {
List<City> cityList;
	
	public CityDAOClass() {
		cityList = new ArrayList<City>();
	}
	 
	public List <City> getAllCities()  {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM City inner join Country on City.CityId = Country.CityId ");
			List<City> cityList= new ArrayList<City>();

			while(rs.next()) {
				City c = new City();
				c.setId(rs.getInt("CityId"));
				c.setName(rs.getString("Name"));
				c.setIsCapital(rs.getString("IsCapital"));
				cityList.add(c);
			}
			con.close();
			st.close();
			rs.close();
			return cityList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	/***
	 * Get All Captial cities from the city table
	 * Return cityList
	 * 
	 */
	
	public List <City> getAllCaptialCities()  {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM City Where IsCapital='Y'");
			List<City> cityList= new ArrayList<City>();

			while(rs.next()) {
				City c = new City();
				c.setId(rs.getInt("CityId"));
				c.setName(rs.getString("Name"));
				c.setIsCapital(rs.getString("IsCapital"));
				//c.setId(rs.getString("CountryID"));

				cityList.add(c);
			}
			con.close();
			st.close();
			rs.close();
			return cityList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
	
	

	@Override
	public City getCity(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM City WHERE CityId= "+ id);
			if(rs.next()) {
				City city = new City();
				city.setId(rs.getInt("CityId"));
				city.setName(rs.getString("Name"));
				city.setIsCapital(rs.getString("IsCapital"));
				System.out.println("entered id: "+ id + " ");
				System.out.println(city.toString());
				return city;
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

	public boolean updateCity(City c) {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE City SET CityName=?, IsCapital=? WHERE CityId=?");
			ps.setString(2, c.getName());
			ps.setString(3, c.getIsCapital());
			ps.setInt(1, c.getId());
			
			
			int i = ps.executeUpdate();		
		if(i == 1) {
			return true;
		}
		con.close();
		ps.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public void deleteCity(City c)  {
		// TODO Auto-generated method stub
		
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM City where CityId = ?");
			ps.setInt(1, c.getId());
			System.out.println("record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
