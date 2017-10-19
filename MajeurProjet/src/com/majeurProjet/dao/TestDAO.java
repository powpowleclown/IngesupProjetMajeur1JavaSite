package com.majeurProjet.dao;

import java.util.List;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Test;

public class TestDAO {

	public static void Save(Test t)
	{
		HibernateUtil.getSession().saveOrUpdate(t);
	}
	
	public static List<Test> List()
	{
		return HibernateUtil.getSession().createQuery("from Test").getResultList();
	}
}
