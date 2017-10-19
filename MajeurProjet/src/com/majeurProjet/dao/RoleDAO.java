package com.majeurProjet.dao;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Role;

public class RoleDAO {

	public static Role getRoleUser()
	{
		Query query = HibernateUtil.getSession().createQuery("from Role R where R.name=?");
		query.setParameter(0, "User");
		return (Role) query.getSingleResult();
		 
	}
}
