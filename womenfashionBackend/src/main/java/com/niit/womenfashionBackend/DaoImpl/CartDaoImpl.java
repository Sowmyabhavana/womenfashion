package com.niit.womenfashionBackend.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Model.Cart;


@Repository("cartDao")
@Transactional

public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Cart cart) {
	sessionFactory.getCurrentSession().saveOrUpdate(cart);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Cart cart) {
	sessionFactory.getCurrentSession().delete(cart);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public Cart getCart(String carId) {
	String q1="from Cart where carId='"+carId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Cart> list=(List<Cart>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Cart> cartlist(){
List<Cart> Carts=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Carts;

	}

}
