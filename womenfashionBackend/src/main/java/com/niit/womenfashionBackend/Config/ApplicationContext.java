package com.niit.womenfashionBackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.womenfashionBackend.Dao.AuthenticationDao;
import com.niit.womenfashionBackend.Dao.BillingDao;
import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Dao.CartItemsDao;
import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Dao.OrderItemsDao;
import com.niit.womenfashionBackend.Dao.OrdersDao;
import com.niit.womenfashionBackend.Dao.PayDao;
import com.niit.womenfashionBackend.Dao.ShippingDao;
import com.niit.womenfashionBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.BillingDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.CartDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.CartItemsdaoImpl;
import com.niit.womenfashionBackend.DaoImpl.CategoryDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.OrdersDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.PayDaoImpl;
import com.niit.womenfashionBackend.DaoImpl.ShippingDaoImpl;
import com.niit.womenfashionBackend.Model.Authentication;
import com.niit.womenfashionBackend.Model.Billing;
import com.niit.womenfashionBackend.Model.Cart;
import com.niit.womenfashionBackend.Model.CartItems;
import com.niit.womenfashionBackend.Model.Category;
import com.niit.womenfashionBackend.Model.OrderItems;
import com.niit.womenfashionBackend.Model.Orders;
import com.niit.womenfashionBackend.Model.Pay;
import com.niit.womenfashionBackend.Model.Products;
import com.niit.womenfashionBackend.Model.Shipping;
import com.niit.womenfashionBackend.Model.Supplier;
import com.niit.womenfashionBackend.Model.Users;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{

	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/project");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	
	
		public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
	    sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Orders.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Products.class);
		sessionBuilder.addAnnotatedClass(Users.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	System.out.println("printing session factory here : "+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("printing transactionManager factory here : "+transactionManager);
		return transactionManager;
	}
 


   	@Autowired
   	@Bean("categoryDao")
   	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
   	{
   		return new CategoryDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("authenticationDao")
   	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) 
   	{
   		return new AuthenticationDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("billingDao")
   	public BillingDao getBillingDao(SessionFactory sessionFactory) 
   	{
   		return new BillingDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("cartDao")
   	public CartDao getCartDao(SessionFactory sessionFactory) 
   	{
   		return new CartDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("cartitemsDao")
   	public CartItemsDao getCartitemsDao(SessionFactory sessionFactory) 
   	{
   		return new CartItemsdaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("ordersDao")
   	public OrdersDao getOrdersDao(SessionFactory sessionFactory) 
   	{
   		return new OrdersDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("orderitemsDao")
   	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) 
   	{
   		return new OrderItemsDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("shippingDao")
   	public ShippingDao getShippingDao(SessionFactory sessionFactory) 
   	{
   		return new ShippingDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("payDao")
   	public PayDao getPayDao(SessionFactory sessionFactory) 
   	{
   		return new PayDaoImpl(sessionFactory);
   	}
   	
}
     
   	