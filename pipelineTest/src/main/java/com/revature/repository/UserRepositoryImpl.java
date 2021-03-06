package com.revature.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Stock;
import com.revature.model.User;
import com.revature.util.SessionFactory;

@Repository("ur2")
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("username"), username));
			Query<User> q = s.createQuery(cq);
			u = q.getSingleResult();
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		System.out.println(u);

		return u;
	}

//	@Override
//	public void newUser(User u) {
//		Session s = null;
//		Transaction tx = null;
//
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			s.save(u);
//			tx.commit();
//		} catch (HibernateException ex) {
//			ex.printStackTrace();
//		} finally {
//			s.close();
//		}
//
//		return;
//	}

	@Override
	public User getAllUsers(String username, String password) {
		User u = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			s.close();
		}

		return u;
	}

	public void newUser(String username, String password, double balance) {
		Session s = null;
		Transaction tx = null;

		User u = new User(username, password, balance);

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			s.close();
		}

		return;
	}

	@Override
	public void updateBalance(String username, double balance) {
		User x = null;
		Session s = null;
		Transaction tx = null;
		Session s2 = null;
		Transaction tx2 = null;

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			x = s.get(User.class, username);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			s.close();
		}
		double remain = x.getBalance() + balance;
		try {
			s2 = SessionFactory.getSession();
			tx2 = s2.beginTransaction();
			x.setBalance(remain);
			s2.update(x);
			tx2.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx2.rollback();
		}finally {
			s2.close();
		}
		return;
	}
	
}
