

package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Dao.OrdersDao;
import com.niit.womenfashionBackend.Model.Category;
import com.niit.womenfashionBackend.Model.Orders;


@Repository("ordersDao")
@Transactional

public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	SessionFactory sessionFactory;
	public OrdersDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Orders orders) {
	sessionFactory.getCurrentSession().saveOrUpdate(orders);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Orders orders) {
	sessionFactory.getCurrentSession().delete(orders);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public Orders getOrders(String ordId) {
	String q1="from Orders where ordId='"+ordId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Orders> list=(List<Orders>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Orders> orderslist(){
List<Orders> Order=(List<Orders>)sessionFactory.getCurrentSession().createCriteria(Orders.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Order;

	}

}
