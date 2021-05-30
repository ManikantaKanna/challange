package com.alore.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.challenge.bo.IUserBO;
import com.alore.challenge.models.User;

@Service

public class UserServiceImp implements IUserService
{
	@Autowired
	IUserBO userBo;
	
	@Override
	public boolean addUser(User user) throws Exception {
		try {
			return userBo.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e ;
		}
		
	}
	
	@Override
	
	public boolean updateUser(User user) throws Exception {
		try {
			return userBo.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e ;
		}
		
	}
@Override
	
	public boolean deleteUser(User user) throws Exception {
		try {
			return userBo.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e ;
		}
		
	}
}
