package com.alore.challenge.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alore.challenge.models.User;
import com.alore.challenge.service.IUserService;
@RestController
@RequestMapping(value = "/user")
public class UserResource extends BaseResource

{
	@Autowired
	private IUserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User requestData) {

		Boolean status;
		try {
			status =  userService.addUser(requestData);
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
	
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User requestData) {

		Boolean status;
		try {
			status =  userService.updateUser(requestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		if (status)
		return new ResponseEntity<>("success" , HttpStatus.OK);
		else
			return new ResponseEntity<>("failed to update user" , HttpStatus.OK);
	}
	@PostMapping("/deleteUser")
	public ResponseEntity<?> deleteUser(@RequestBody User requestData) {

		Boolean status;
		try {
			status =  userService.deleteUser(requestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		if (status)
		return new ResponseEntity<>("success" , HttpStatus.OK);
		else
			return new ResponseEntity<>("failed to update user" , HttpStatus.OK);
	}

}
