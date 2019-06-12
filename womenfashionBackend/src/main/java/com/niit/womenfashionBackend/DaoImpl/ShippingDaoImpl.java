
package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.womenfashionBackend.Dao.ShippingDao;
import com.niit.womenfashionBackend.Model.Shipping;


@Repository("ShippingDao")
@Transactional

public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	SessionFactory sessionFactory;
	public ShippingDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Shipping shipping) {
	sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Shipping shipping) {
	sessionFactory.getCurrentSession().delete(shipping);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public Shipping getShipping(String shipId) {
	String q1="from Shipping where shipId='"+shipId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Shipping> list=(List<Shipping>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Shipping> shippinglist(){
List<Shipping> Shippings=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Shippings;

	}

}
