package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.ComputerData;

public class ComputerDataDAO {

	public static void SaveUpdateComputerData(ComputerData computerdata)
	{
		HibernateUtil.getSession().saveOrUpdate(computerdata);
	}
	
	public static void DeleteComputerData(ComputerData computerdata)
	{
		HibernateUtil.getSession().delete(computerdata);
	}
	
	public static void DeleteComputerDataById(int id_computerdata)
	{
		ComputerData computerdata = getComputerData(id_computerdata);
		HibernateUtil.getSession().delete(computerdata);
	}
	
	public static List<ComputerData> ListComputerData()
	{
		return HibernateUtil.getSession().createQuery("from ComputerData").getResultList();
	}
	
	public static ComputerData getComputerData(int id_computerdata)
	{
		ComputerData computerdata;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM ComputerData C WHERE C.id=?");
			query.setParameter(0, id_computerdata);
			computerdata = (ComputerData) query.getSingleResult();
		}
		catch(Exception e)
		{
			computerdata = null;
		}

		return computerdata;
	}
	
	public static ComputerData getComputerDataByComputer(int id_computer) {
		ComputerData computerdata;
		try
		{
			System.out.println(ComputerDAO.getComputer(id_computer));
			Query query = HibernateUtil.getSession().createQuery("FROM ComputerData C WHERE C.computer=?");
			query.setParameter(0, ComputerDAO.getComputer(id_computer));
			computerdata = (ComputerData) query.getSingleResult();
		}
		catch(Exception e)
		{
			computerdata = null;
		}

		return computerdata;
	}
}
