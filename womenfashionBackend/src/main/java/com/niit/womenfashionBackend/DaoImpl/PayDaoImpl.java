
package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.PayDao;
import com.niit.womenfashionBackend.Model.Pay;



@Repository("payDao")
@Transactional

public class PayDaoImpl implements PayDao {
	@Autowired
	SessionFactory sessionFactory;
	public PayDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Pay pay) {
	sessionFactory.getCurrentSession().saveOrUpdate(pay);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Pay pay) {
	sessionFactory.getCurrentSession().delete(pay);
		// TODO Auto-generated method stub
		return true;
	}
@Override
public Pay getPay(String paId) {
	String q1="from Pay where paId='"+paId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Pay> list=(List<Pay>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Pay> paylist(){
List<Pay> Payment=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Payment;

	}

}
