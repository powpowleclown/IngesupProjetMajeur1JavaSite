package com.majeurProjet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Role;

public class RoleDAO {

	private static Map<Integer,Role> roleDB = new ConcurrentHashMap<Integer, Role>();
	private static AtomicInteger idCounter = new AtomicInteger();
	
	public static List<Role> getAllRole()
	{
		return new ArrayList<Role>(roleDB.values());
	}
	public static void SaveUpdateRole(Role role)
	{
		HibernateUtil.getSession().saveOrUpdate(role);
	}
	
	public static List<Role> ListRole()
	{
		return HibernateUtil.getSession().createQuery("from Role").getResultList();
	}
	
	public static void DeleteRoleById(int id_role)
	{
		Role role = getRole(id_role);
		HibernateUtil.getSession().delete(role);
	}
	
	public static void DeleteRole(Role role)
	{
		HibernateUtil.getSession().delete(role);
	}
	
	public static Role getRole(int id_role)
	{
		Role role;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Role R WHERE R.id=?");
			query.setParameter(0, id_role);
			role = (Role) query.getSingleResult();
		}
		catch(Exception e)
		{
			role = null;
		}

		return role;
	}
	
	public static Role getRoleUser()
	{
		Query query = HibernateUtil.getSession().createQuery("from Role R where R.name=?");
		query.setParameter(0, "User");
		return (Role) query.getSingleResult();
		 
	}
}
