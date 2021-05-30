package com.alore.challenge.dao;

import com.alore.challenge.models.User;

public interface IuserDao {

	public boolean addUser(User user) throws Exception;

	public boolean updateUser(User user) throws Exception;

	public boolean deleteUser(User user) throws Exception;

}
