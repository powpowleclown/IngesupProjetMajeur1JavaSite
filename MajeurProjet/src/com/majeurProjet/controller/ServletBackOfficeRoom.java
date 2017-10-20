package com.majeurProjet.controller;

import java.util.List;

import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.metier.Room;

public class ServletBackOfficeRoom extends ServletBackOffice {

	
	//LIST
	public void List()
	{
		List<Room> rooms = RoomDAO.ListRoom();
		this.displayView(rooms);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		this.displayView(null);
	}
	//DELETE
	public void Delete(Room room)
	{
		RoomDAO.DeleteRoom(room);
	}
}
