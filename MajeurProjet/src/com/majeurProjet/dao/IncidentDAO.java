package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

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
	public static Incident getIncident(int id_incident)
	{
		Incident incident;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Incident C WHERE C.id=?");
			query.setParameter(0, id_incident);
			incident = (Incident) query.getSingleResult();
		}
		catch(Exception e)
		{
			incident = null;
		}

		return incident;
	}
}
