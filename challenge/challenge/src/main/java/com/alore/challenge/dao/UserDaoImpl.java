package com.alore.challenge.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alore.challenge.models.User;

@Repository
public class UserDaoImpl implements IuserDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public boolean addUser(User user) throws Exception 
	{
		// TODO Auto-generated method stub
		String sqlCmd = "INSERT  into user (user_id,user_name,password,gendre,city) values (?,?,?,?,?)";
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
	    rows = jdbcTemplate.update(sqlCmd, new Object[] { user.getId(), user.getName(),user.getPassword(), user.getGender(),user.getCity() });
	    if (rows == 1) 
	    {
			return true;
		    }
		return false;
	}
	
	@Override
	public boolean updateUser(User user) throws Exception 
	{
		// TODO Auto-generated method stub
		String sqlCmd = "Update user set user_name=? , password=? , WHERE user_id=?";
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
	    rows = jdbcTemplate.update(sqlCmd, new Object[] { user.getName(),user.getPassword(),  user.getId()});
	    if (rows == 1) 
	    {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteUser(User user) throws Exception 
	{
		// TODO Auto-generated method stub
		String sqlCmd = "Delete from user WHERE user_id=?";
		int rows = 0;
//	    KeyHolder holder = new GeneratedKeyHolder();
	    rows = jdbcTemplate.update(sqlCmd, new Object[] { user.getId()});
	    if (rows == 1) 
	    {
			return true;
		}
		return false;
	}
	
}
