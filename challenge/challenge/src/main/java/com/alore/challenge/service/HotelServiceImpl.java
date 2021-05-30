package com.alore.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.challenge.bo.IHotelBO;
import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	IHotelBO hotelBo;
	
	@Override
	public List<Hotel> getHotels(String search) throws Exception {
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {
			hotels = hotelBo.getHotels(search);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e ;
		}
		return hotels;
		
	}

	@Override
	public boolean addHotel(Hotel hotel) throws Exception {
		try {
			return hotelBo.addHotel(hotel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e ;
		}
		
	}

	@Override
	public Boolean addComment(Comments requestData) throws Exception {
		// TODO Auto-generated method stub
		try {
			return hotelBo.addComment(requestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e ;
		}
		
	}

	
}
