
package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.womenfashionBackend.Dao.OrderItemsDao;
import com.niit.womenfashionBackend.Model.OrderItems;




@Repository("OrderItemsDao")
@Transactional

public class OrderItemsDaoImpl implements OrderItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	public OrderItemsDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(OrderItems orderitems) {
	sessionFactory.getCurrentSession().saveOrUpdate(orderitems);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(OrderItems orderitems) {
	sessionFactory.getCurrentSession().delete(orderitems);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public OrderItems getOrderItems(String oiId) {
	String q1="from OrderItems where oiId='"+oiId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<OrderItems> list=(List<OrderItems>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<OrderItems> orderitemslist(){
List<OrderItems> Orderitems=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Orderitems;

	}

}
