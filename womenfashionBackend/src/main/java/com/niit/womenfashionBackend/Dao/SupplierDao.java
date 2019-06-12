package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Supplier;
public interface SupplierDao {
	public boolean saveorupdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier getSupplier(String suppId);
	public List<Supplier> supplierlist();
	
}