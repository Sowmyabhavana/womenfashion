
package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Authentication;

public interface AuthenticationDao {
	public boolean saveorupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication getAuthentication(String authId);
	public List<Authentication> authenticationlist();
	
}