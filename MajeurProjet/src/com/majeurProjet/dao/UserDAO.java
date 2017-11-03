package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.State;
import com.majeurProjet.metier.User;

public class UserDAO {

	public static void SaveUpdateUser(User user)
	{
		HibernateUtil.getSession().saveOrUpdate(user);
	}
	
	public static List<User> ListUser()
	{
		return HibernateUtil.getSession().createQuery("from User").getResultList();
	}
	
	public static void DeleteUserById(int id_user)
	{
		User user = getUser(id_user);
		HibernateUtil.getSession().delete(user);
	}
	
	public static void DeleteUser(User user)
	{
		HibernateUtil.getSession().delete(user);
	}
	
	public static User getUser(int id_user)
	{
		User user;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM User U WHERE U.id=?");
			query.setParameter(0, id_user);
			user = (User) query.getSingleResult();
		}
		catch(Exception e)
		{
			user = null;
		}

		return user;
	}
	
	public static User getUserByMailPassword(String mail, String pwd)
	{
		try
		{
			return (User) HibernateUtil.getSession().createQuery("from User where mail=? and pwd=?")
					.setParameter(0, mail).setParameter(1, pwd).getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public static User getUserByMail(String mail)
	{
		try
		{
			return (User) HibernateUtil.getSession().createQuery("from User where mail=?")
					.setParameter(0, mail).getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	public static boolean userAlreadyExists(String email, String password) {
        if (getUserByMailPassword(email, password) != null) {
            return true;
        } else {
            return false;
        }
    }
	
	public static boolean userEmailAlreadyExists(String email) {
		if(getUserByMail(email) != null) {
			return true;
		}else {
			return false;
		}
		
	}

  
}
