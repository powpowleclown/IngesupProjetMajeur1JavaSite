package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.State;

public class StateDAO {
	
	public static void SaveUpdateState(State state)
	{
		HibernateUtil.getSession().saveOrUpdate(state);
	}
	
	public static void DeleteState(State state)
	{
		HibernateUtil.getSession().delete(state);
	}
	
	public static void DeleteStateById(int id_state)
	{
		State state = getState(id_state);
		HibernateUtil.getSession().delete(state);
	}
	
	public static List<State> ListState()
	{
		return HibernateUtil.getSession().createQuery("from State").getResultList();
	}
	
	public static State getState(int id_state)
	{
		State state;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM State C WHERE C.id=?");
			query.setParameter(0, id_state);
			state = (State) query.getSingleResult();
		}
		catch(Exception e)
		{
			state = null;
		}

		return state;
	}
	
	public static State getStateByNameAndTable(String name_state, String table_state)
	{
		State state;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM State C WHERE C.name=? AND C.table=?");
			query.setParameter(0, name_state);
			query.setParameter(1, table_state);
			state = (State) query.getSingleResult();
		}
		catch(Exception e)
		{
			state = null;
		}

		return state;
	}
	public static List<State> getStateByTable(String table_state)
	{
		Query query = HibernateUtil.getSession().createQuery("FROM State C WHERE C.table=?");
		query.setParameter(0, table_state);
		return query.getResultList();
	}
	
	public static State getStateByName(String name) {
		try
		{
			return (State) HibernateUtil.getSession().createQuery("FROM State where name=?")
					.setParameter(0, name).getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}	
	}
	
	public static boolean stateAlreadyExists(String name, String table) {
		if(getStateByNameAndTable(name, table) != null) {
			return true;
		}else {
			return false;
		}
	}
}
