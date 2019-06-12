package com.niit.womenfashionBackend.DaoImpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.CartItemsDao;
import com.niit.womenfashionBackend.Model.CartItems;


@Repository("cartitemsDao")
@Transactional

public class CartItemsdaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	public CartItemsdaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(CartItems cartitems) {
	sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(CartItems cartitems) {
	sessionFactory.getCurrentSession().delete(cartitems);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public CartItems getCartItems(String cariId) {
	String q1="from CartItems where cariId='"+cariId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<CartItems> list=(List<CartItems>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<CartItems> cartitemslist(){
List<CartItems> Cartitems=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Cartitems;

	}
public List<CartItems> cartitemslist(String id)
{
	String q1="from CartItems where carId='"+id+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<CartItems> list=(List<CartItems>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list;
}

}
