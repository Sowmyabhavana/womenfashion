package com.niit.womenfashionBackend.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.BillingDao;
import com.niit.womenfashionBackend.Model.Billing;



@Repository("BillingDao")
@Transactional

public class BillingDaoImpl implements BillingDao {
	@Autowired
	SessionFactory sessionFactory;
	public BillingDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Billing billing) {
	sessionFactory.getCurrentSession().saveOrUpdate(billing);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Billing billing) {
	sessionFactory.getCurrentSession().delete(billing);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public Billing getBilling(String bilId) {
	String q1="from Billing where bilId='"+bilId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Billing> list=(List<Billing>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Billing> billinglist(){
List<Billing> Billings=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Billings;

	}

}

