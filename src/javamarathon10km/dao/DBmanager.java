package javamarathon10km.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javamarathon10km.domain.Hotel;


public class DBmanager {
	private String driver = "com.mysql.jdbc.Driver";
	private String sql = "select * from hotels where price<=";
	private String url = "jdbc:mysql://localhost/data1?useSSL=false";
	private String user = "hoge";
	private String password = "adeba255@";
	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	
	ArrayList<Hotel> hotelList = new ArrayList<>();

	public ArrayList<Hotel> serchResult(int price) {
		try {
			Class.forName(driver); // ドライバ登録処理

			// DB接続処理
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			// sql文
			rs = statement.executeQuery(sql + price + ";");
			
			while (rs.next()) {
				Hotel hotel=new Hotel();
				hotel.setId	(rs.getInt("id"));
				hotel.setAreaName(rs.getString("area_name"));
				hotel.setHotelName(rs.getString("hotel_name"));
				hotel.setAddress(rs.getString("address"));
				hotel.setNearestStation(rs.getString("nearest_station"));
				hotel.setPrice(rs.getInt("price"));
				hotel.setParking(rs.getString("parking"));
				hotelList.add(hotel);	
			}
		} catch (SQLException e) {
			System.out.println("SQLEROOR");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERORR");	
		}

		return hotelList;
		
	}

		
	}
	


