package com.alore.challenge.dao;

import java.util.List;

import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;

public interface IHotelDao {

	public List<Hotel> getHotels(String search) throws Exception;

	public boolean addHotel(Hotel hotel);

	public Boolean addComment(Comments requestData) throws Exception;

	public Boolean updateHotelRating(int rating, int hotelId) throws Exception;

	public int getAvgRating(int hotelId, int userRating) throws Exception;

	 

	

}
