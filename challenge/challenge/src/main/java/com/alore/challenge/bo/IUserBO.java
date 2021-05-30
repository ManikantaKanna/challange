package com.alore.challenge.bo;

import com.alore.challenge.models.User;

public interface IUserBO 
{

	public boolean addUser(User user) throws Exception ;
	
	public boolean updateUser(User user) throws Exception ;

	public boolean deleteUser(User user) throws Exception;

	
	
}
