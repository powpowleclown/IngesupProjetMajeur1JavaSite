package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.HistoricalIncident;

public class HistoricalIncidentDAO {
	
	public static void SaveUpdateHistoricalComputer(HistoricalIncident historicalincident)
	{
		HibernateUtil.getSession().saveOrUpdate(historicalincident);
	}
	
	public static void DeleteIncident(HistoricalIncident historicalincident)
	{
		HibernateUtil.getSession().delete(historicalincident);
	}
	
	public static List<HistoricalIncident> ListHistoricalComputer()
	{
		return HibernateUtil.getSession().createQuery("from HistoricalIncident").getResultList();
	}
	public static HistoricalIncident getHistoricalComputer(int id_historicalincident)
	{
		HistoricalIncident historicalincident;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM HistoricalIncident C WHERE C.id=?");
			query.setParameter(0, id_historicalincident);
			historicalincident = (HistoricalIncident) query.getSingleResult();
		}
		catch(Exception e)
		{
			historicalincident = null;
		}

		return historicalincident;
	}
}
