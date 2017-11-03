package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.HistoricalComputer;

public class HistoricalComputerDAO {
	
	public static void SaveUpdateHistoricalComputer(HistoricalComputer historicalcomputer)
	{
		HibernateUtil.getSession().saveOrUpdate(historicalcomputer);
	}
	
	public static void DeleteHistoricalComputer(HistoricalComputer historicalcomputer)
	{
		HibernateUtil.getSession().delete(historicalcomputer);
	}
	
	public static void DeleteHistoricalComputerById(int id_historicalcomputer)
	{
		HistoricalComputer historicalcomputer = getHistoricalComputer(id_historicalcomputer);
		HibernateUtil.getSession().delete(historicalcomputer);
	}
	
	public static List<HistoricalComputer> ListHistoricalComputer()
	{
		return HibernateUtil.getSession().createQuery("from HistoricalComputer").getResultList();
	}
	public static HistoricalComputer getHistoricalComputer(int id_historicalcomputer)
	{
		HistoricalComputer historicalcomputer;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM HistoricalComputer C WHERE C.id=?");
			query.setParameter(0, id_historicalcomputer);
			historicalcomputer = (HistoricalComputer) query.getSingleResult();
		}
		catch(Exception e)
		{
			historicalcomputer = null;
		}

		return historicalcomputer;
	}
}
