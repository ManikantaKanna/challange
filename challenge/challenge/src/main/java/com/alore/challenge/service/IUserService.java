package com.alore.challenge.service;

import com.alore.challenge.models.User;

public interface IUserService 
{
	public boolean addUser(User user) throws Exception;

	public boolean updateUser(User user) throws Exception;

	public boolean deleteUser(User user) throws Exception;
}
