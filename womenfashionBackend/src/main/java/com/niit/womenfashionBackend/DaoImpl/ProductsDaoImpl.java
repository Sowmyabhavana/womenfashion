package com.niit.womenfashionBackend.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.ProductsDao;
import com.niit.womenfashionBackend.Model.Products;


@Repository("productsDao")
@Transactional

public class ProductsDaoImpl implements ProductsDao {
	@Autowired
	SessionFactory sessionFactory;
	public ProductsDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Products products) {
	sessionFactory.getCurrentSession().saveOrUpdate(products);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Products products) {
	sessionFactory.getCurrentSession().delete(products);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public Products getProducts(String proId) {
	String q1="from Products where proId='"+proId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Products> list=(List<Products>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Products> productslist(){
List<Products> Product=(List<Products>)sessionFactory.getCurrentSession().createCriteria(Products.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Product;

	}


public List<Products> getProductsById(String catId)
{
	String q1="from Products where catId='"+catId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Products> list=(List<Products>)w.list();
	if(list==null || list.isEmpty())
    {
		return null;
	}
    return list;
	
}

}
