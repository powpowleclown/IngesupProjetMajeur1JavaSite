package com.majeurProjet.dao;

import java.util.List;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Room;

public class RoomDAO {

	public void SaveUpdateRoom(Room room)
	{
		HibernateUtil.getSession().saveOrUpdate(room);
	}
	
	public void DeleteRoom(Room room)
	{
		HibernateUtil.getSession().delete(room);
	}
	
	public List<Room> ListRoom()
	{
		return HibernateUtil.getSession().createQuery("from Room").getResultList();
	}
}
