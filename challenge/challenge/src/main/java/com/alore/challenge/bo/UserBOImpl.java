package com.alore.challenge.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.challenge.dao.IuserDao;
import com.alore.challenge.models.User;
@Service
public class UserBOImpl implements IUserBO
{
	@Autowired
	IuserDao userDao;

	@Override
	public boolean addUser( User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			return userDao.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			return userDao.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	@Override
	
	public boolean deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			return userDao.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
}
