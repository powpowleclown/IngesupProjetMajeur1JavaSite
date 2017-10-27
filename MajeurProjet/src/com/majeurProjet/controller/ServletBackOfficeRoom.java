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
	//DETAIL
	public void Show()
	{
		Room room = null;
		Integer id = this.getParamAsInt("id_room");
		if(id != null)
		{
			room = RoomDAO.getRoom(id);
		}
		this.displayView(room);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		Room room = null;
		Integer id = this.getParamAsInt("id_room");
		if(id != null)
		{
			room = RoomDAO.getRoom(id);
		}
		
		if(this.isPostBack())
		{
			Room roomCreateOrUpdate;
			if(id != null)
			{
				roomCreateOrUpdate = RoomDAO.getRoom(id);
			}
			else
			{
				roomCreateOrUpdate = new Room();
			}
			roomCreateOrUpdate.setIpmask(this.getParam("ipmask"));
			roomCreateOrUpdate.setName(this.getParam("name"));

			RoomDAO.SaveUpdateRoom(roomCreateOrUpdate);
			this.redirect("/BackOffice/Room/List");
		}
		else
		{
			this.displayView(room);
		}
	}
	//DELETE
	public void Delete()
	{
		Integer id = this.getParamAsInt("id_room");
		Room room = RoomDAO.getRoom(id);
		RoomDAO.DeleteRoom(room);
		this.redirect("/BackOffice/Room/List");
	}
}
