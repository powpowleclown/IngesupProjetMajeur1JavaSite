package com.majeurProjet.dao;

import java.util.List;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Incident;

public class IncidentDAO {

	public static void SaveUpdateIncident(Incident incident)
	{
		HibernateUtil.getSession().saveOrUpdate(incident);
	}
	
	public static void DeleteIncident(Incident incident)
	{
		HibernateUtil.getSession().delete(incident);
	}
	
	public static List<Incident> ListIncident()
	{
		return HibernateUtil.getSession().createQuery("from Incident").getResultList();
	}
}
