package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.User;

public class UserDAO {

	public static void Save(User user)
	{
		HibernateUtil.getSession().saveOrUpdate(user);
	}
	
	public static List<User> List()
	{
		return HibernateUtil.getSession().createQuery("from User").getResultList();
	}
	
	public static User Verif(String mail, String pwd)
	{
		User users;
		try
		{
			
			Query query = HibernateUtil.getSession().createQuery("from User U where U.mail=? AND U.password=?");
			query.setParameter(0, mail);
			query.setParameter(1, pwd);
			users = (User) query.getSingleResult();
		}
		catch(Exception e)
		{
			users = null;
		}

		return users;
	}
}
