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

    public static boolean passwordCorrespondToUser(String email, String password) {
        if (getUserByMailPassword(email, password) != null) {
            return true;
        } else {
            return false;
        }
    }
}
