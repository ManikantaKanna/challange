package com.alore.challenge.resource;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alore.challenge.models.Comments;
import com.alore.challenge.models.Hotel;
import com.alore.challenge.service.IHotelService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelResource extends BaseResource {

	@Autowired
	private IHotelService hotelService;

	@GetMapping("/gethotels")

//	@RequestParam("search") String search,
//	@RequestParam("rating") String rating
	// to be added in arguments of below meathod
	public ResponseEntity<?> getHotels(@RequestParam("search") String search   ) {
		List <Hotel> data = new ArrayList<Hotel>();
		try {
			data = hotelService.getHotels(search);
			if (data.size() > 0) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No Hotels found",HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}

	}

	@PostMapping("/addhotel")
	public ResponseEntity<?> addHotel(@RequestBody Hotel requestData) {

		Boolean status;
		try {
			status =  hotelService.addHotel(requestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		if (status)
		return new ResponseEntity<>("success" , HttpStatus.OK);
		else
			return new ResponseEntity<>("failed to add hotel" , HttpStatus.OK);
	}
	@PostMapping("/addcomment")
	public ResponseEntity<?> addComment(@RequestBody Comments requestData) {

		Boolean status;
		try {
			status =  hotelService.addComment(requestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		if (status)
		return new ResponseEntity<>("success" , HttpStatus.OK);
		else
			return new ResponseEntity<>("failed to add hotel" , HttpStatus.OK);
	}

}


