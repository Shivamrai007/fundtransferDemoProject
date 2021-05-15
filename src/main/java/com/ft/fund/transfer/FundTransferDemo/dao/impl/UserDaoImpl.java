package com.ft.fund.transfer.FundTransferDemo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ft.fund.transfer.FundTransferDemo.dao.UserDao;
import com.ft.fund.transfer.FundTransferDemo.model.User;

/**
 * @author shivam.rai
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 *
	 */
	public User doLogin(User user) {
		User getUser2 = new User();
		getUser2.setId(0);
		
			String userName = user.getUsername();
			String password = user.getPassword();
			Session currentSession = sessionFactory.openSession();
			currentSession.beginTransaction();
			
			Query query = currentSession.createQuery("from User where username=:username");
			query.setParameter("username", userName);
			
			List<User> userList = query.list();
			
			User getUser = userList.get(0);
			
			if (getUser != null && getUser.getPassword().equals(password)) {
				return getUser;
			}
	
			
			return getUser2;
		
	}

	/**
	 *
	 */
	public User getUserByUserId(int userId) {

	
			Session currentSession = sessionFactory.openSession();
			//currentSession.beginTransaction();
			Query query  = currentSession.createQuery("from User where id=:id");
					query.setParameter("id", userId);
					
			List<User> userList = query.list();
			User getUser = userList.get(0);
			
			if (userList.isEmpty()) {
				return null;
			}
		
		return getUser;
	}

}