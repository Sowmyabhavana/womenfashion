package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.womenfashionBackend.Dao.UsersDao;
import com.niit.womenfashionBackend.Model.Users;

@Repository("usersDao")
@Transactional

public class UsersDaoImpl implements UsersDao {
	@Autowired
	SessionFactory sessionFactory;

	public UsersDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdate(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(Users users) {
		sessionFactory.getCurrentSession().delete(users);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Users getUsers(String useId) {
		String q1 = "from Users where useId='" + useId + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Users> list = (List<Users>) w.list();
		if (list == null || list.isEmpty()) {

			// TODO Auto-generated method stub
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Users> userslist() {
		List<Users> User = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return User;

	}

	@Override
	public Users isValidate(String EmailId, String Password) {
		String q1 = "from Users where useEmailId='" + EmailId + "' and usePassword='" + Password + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Users> list = (List<Users>) w.list();
		if (list == null || list.isEmpty()) {

			// TODO Auto-generated method stub
			return null;
		}
		return list.get(0);
	}

	public Users getUsersbyemail(String useId) {
		String q1 = "from Users where useEmailId='" +useId+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Users> list = (List<Users>) w.list();
		if (list == null || list.isEmpty()) {

			// TODO Auto-generated method stub
			return null;
		}
		return list.get(0);
	}

}
