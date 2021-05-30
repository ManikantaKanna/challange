package com.alore.challenge.bo;

import java.util.List;

import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;

public interface IHotelBO {

	public List<Hotel> getHotels(String search) throws Exception;

	public boolean addHotel(Hotel hotel) throws Exception;

	public Boolean addComment(Comments requestData)throws Exception;

	

}
