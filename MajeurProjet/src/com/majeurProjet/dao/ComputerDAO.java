package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Computer;

public class ComputerDAO {

	public static void SaveUpdateComputer(Computer computer)
	{
		HibernateUtil.getSession().saveOrUpdate(computer);
	}
	
	public static void DeleteComputer(Computer computer)
	{
		HibernateUtil.getSession().delete(computer);
	}
	
	public static List<Computer> ListComputer()
	{
		return HibernateUtil.getSession().createQuery("from Computer").getResultList();
	}
	
	public static Computer getComputer(int id_computer)
	{
		Computer computer;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Computer C WHERE C.id=?");
			query.setParameter(0, id_computer);
			computer = (Computer) query.getSingleResult();
		}
		catch(Exception e)
		{
			computer = null;
		}

		return computer;
	}
}
