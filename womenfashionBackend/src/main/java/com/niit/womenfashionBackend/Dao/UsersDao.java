package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Users;
public interface UsersDao {
	public boolean saveorupdate(Users users);
	public boolean delete(Users users);
	public Users getUsers(String useId);
	public Users getUsersbyemail(String useId);
	public List<Users> userslist();
	public Users isValidate(String EmailId,String Password);
	
}