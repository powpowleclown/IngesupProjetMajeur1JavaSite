package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Room;

public class RoomDAO {

	public static void SaveUpdateRoom(Room room)
	{
		HibernateUtil.getSession().saveOrUpdate(room);
	}
	
	public static void DeleteRoom(Room room)
	{
		HibernateUtil.getSession().delete(room);
	}
	
	public static void DeleteRoomById(int id_room)
	{
		Room room = getRoom(id_room);
		HibernateUtil.getSession().delete(room);
	}
	
	public static List<Room> ListRoom()
	{
		return HibernateUtil.getSession().createQuery("FROM Room").getResultList();
	}
	
	public static Room getRoom(int id_room)
	{
		Room room;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Room R WHERE R.id=?");
			query.setParameter(0, id_room);
			room = (Room) query.getSingleResult();
		}
		catch(Exception e)
		{
			room = null;
		}

		return room;
	}
}
