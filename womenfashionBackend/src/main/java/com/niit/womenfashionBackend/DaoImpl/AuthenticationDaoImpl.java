package com.niit.womenfashionBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.womenfashionBackend.Dao.AuthenticationDao;
import com.niit.womenfashionBackend.Model.Authentication;

@Repository("authenticationDao")
@Transactional

public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdate(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Authentication getAuthentication(String authId) {
		String q1 = "from Authentication where authId='" + authId + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Authentication> list = (List<Authentication>) w.list();
		if (list == null || list.isEmpty()) {

			// TODO Auto-generated method stub
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Authentication> authenticationlist() {
		List<Authentication> Authentications = (List<Authentication>) sessionFactory.getCurrentSession()
				.createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Authentications;

	}

}
