package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Pay;
public interface PayDao {
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String paId);
	public List<Pay> paylist();
	
}