package com.alore.challenge.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.challenge.dao.IHotelDao;
import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;

@Service
public class HotelBOImpl implements IHotelBO {
	@Autowired
	IHotelDao hotelDao;

	@Override
	public List<Hotel> getHotels(String search) throws Exception {
		List<Hotel> hotels = null;
		try {
			hotels = hotelDao.getHotels(search);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return hotels;
		
	}

	@Override
	public boolean addHotel( Hotel hotel) {
		// TODO Auto-generated method stub
		try {
			return hotelDao.addHotel(hotel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Boolean addComment(Comments comment) throws Exception {
		// TODO Auto-generated method stub
		try {
			return hotelDao.addComment(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}

}
