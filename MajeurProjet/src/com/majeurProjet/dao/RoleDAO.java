package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.User;

public class RoleDAO {

	public static Role getRoleUser()
	{
		Query query = HibernateUtil.getSession().createQuery("from Role R where R.name=?");
		query.setParameter(0, "User");
		return (Role) query.getSingleResult();
		 
	}
}
