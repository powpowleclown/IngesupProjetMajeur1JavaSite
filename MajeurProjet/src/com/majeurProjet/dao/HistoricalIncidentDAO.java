package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.HistoricalComputer;
import com.majeurProjet.metier.HistoricalIncident;

public class HistoricalIncidentDAO {
	
	public static void SaveUpdateHistoricalIncident(HistoricalIncident historicalincident)
	{
		HibernateUtil.getSession().saveOrUpdate(historicalincident);
	}
	
	public static void DeleteHistoricalIncident(HistoricalIncident historicalincident)
	{
		HibernateUtil.getSession().delete(historicalincident);
	}
	
	public static void DeleteHistoricalIncidentById(int id_historicalincident)
	{
		HistoricalIncident historicalincident = getHistoricalIncident(id_historicalincident);
		HibernateUtil.getSession().delete(historicalincident);
	}
	
	public static List<HistoricalIncident> ListHistoricalIncident()
	{
		return HibernateUtil.getSession().createQuery("from HistoricalIncident").getResultList();
	}
	public static HistoricalIncident getHistoricalIncident(int id_historicalincident)
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
