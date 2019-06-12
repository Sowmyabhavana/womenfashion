package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Model.Category;


@Repository("categoryDao")
@Transactional

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
}

@Override
	public boolean saveorupdate(Category category) {
	sessionFactory.getCurrentSession().saveOrUpdate(category);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean delete(Category category) {
	sessionFactory.getCurrentSession().delete(category);
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public Category getCategory(String catId) {
	String q1="from Category where catId='"+catId+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<Category> list=(List<Category>)w.list();
	if(list==null || list.isEmpty())
{

		// TODO Auto-generated method stub
		return null;
	}
return list.get(0);
}
@Override
public List<Category> categorylist(){
List<Category> Categories=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Categories;

	}

}
