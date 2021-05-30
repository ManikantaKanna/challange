package com.alore.challenge.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;


@Repository
public class HotelDao implements IHotelDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Hotel> getHotels(String search) throws Exception {
		System.out.print("in dao of get hotels");
		
		
		String sqlCmd = "select * from hotels";
		
		if(search.length()>0)
		{
			sqlCmd = sqlCmd + " where hotel_name like  '" + search+"%'";
		}
		 
		List<Map<String, Object>> rows = null;
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {
		rows = jdbcTemplate.queryForList(sqlCmd, new Object[] {});
		if (!rows.isEmpty()) {
			for (int i = 0; i < rows.size(); i++) {
				Hotel hotel = new Hotel();
				hotel.setId((int) rows.get(i).get("hotel_id"));
				hotel.setName((String) rows.get(i).get("hotel_name"));
				hotel.setAvailableRooms((int) rows.get(i).get("available_rooms"));
				
				hotels.add(hotel);
			}
			}
		} catch (Exception e) {
			throw e;
		}
		return hotels;
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		String sqlCmd = "INSERT  into hotels (hotel_id, hotel_name, location_id,  address, available_rooms, rating) values (?,?,?,?,?,?)";
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
		
		
	    rows = jdbcTemplate.update(sqlCmd, new Object[] { hotel.getId(), hotel.getName(), hotel.getLocationId(), hotel.getAdress(), hotel.getAvailableRooms(),0 });
	    
	    hotel.getAmenetyId().forEach( amenetyId -> {
		    insertAmenities(hotel, amenetyId);

	    });
	    
	    
	    if (rows == 1) {
			return true;
		    }
	    return false;
	}

	private void insertAmenities(Hotel hotel, Integer amenetyId) {
		String sqlCmd = "INSERT  into hotel_amenety_map_tbl (hotel_id, ameneties_id) values (?,?)";
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
		
		
	    rows = jdbcTemplate.update(sqlCmd, new Object[] { hotel.getId(), amenetyId});
	    
	}

	@Override
	public Boolean addComment(Comments comment) throws Exception {
		// TODO Auto-generated method stub
		String sqlCmd = "INSERT  into comments (hotel_id, user_id, comment, rating) values (?,?,?,?)";
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
	    rows = jdbcTemplate.update(sqlCmd, new Object[] { comment.getHotelId(), comment.getUser().getId(), comment.getComment(), comment.getRating() });
	    int rating = getAvgRating(rows, rows);
	    updateHotelRating(rating, comment.getHotelId());
	    if (rows == 1) 
	    {
			return true;
		    }
	    return false;
	}
	@Override
	
	public Boolean updateHotelRating(int rating, int hotelId) {
		String sqlCmd = "update  hotels set  rating = "+ rating + " where hotel_id = " + hotelId ;
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
		rows = jdbcTemplate.update(sqlCmd, new Object[] {  });
		if (rows == 1) {
			return true;
		}
		return false;
	}
	@Override
	
	public int  getAvgRating(int hotelId, int  userRating) {
		String sqlCmd = "select rating from comments where hotel_id = ? ";

//	    KeyHolder holder = new GeneratedKeyHolder();
		List<Map<String, Object>> rows = null;
		rows = jdbcTemplate.queryForList(sqlCmd, new Object[] { hotelId });
		int avgValue = userRating;
		if (!rows.isEmpty()) {
			for (int i = 0; i < rows.size(); i++) {
				avgValue += (int) rows.get(i).get("rating");
			}
		}
		avgValue = avgValue/(rows.size() + 2);
		
		return avgValue;

	}

	

}
