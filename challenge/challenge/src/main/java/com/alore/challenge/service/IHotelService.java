package com.alore.challenge.service;

import java.util.List;

import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;

public interface IHotelService {
	public List<Hotel> getHotels(String search) throws Exception;

	public boolean addHotel(Hotel hotel) throws Exception;

	public Boolean addComment(Comments requestData) throws Exception;
}
