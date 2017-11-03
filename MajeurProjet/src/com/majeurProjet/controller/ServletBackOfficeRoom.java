package com.majeurProjet.controller;

import java.util.Arrays;
import java.util.List;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.metier.Room;
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;

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
			Room roomToCreateOrUpdate;
			if(id != null)
			{
				roomToCreateOrUpdate = RoomDAO.getRoom(id);
				if(!this.updateFieldsAreCorrect(id)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(roomToCreateOrUpdate);
					return;
				}
			}
			else
			{
				roomToCreateOrUpdate = new Room();
				if(!this.addFieldsAreCorrect()) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(null);
					return;
				}
			}
			
			roomToCreateOrUpdate.setIpmask(this.getParam("ipmask"));
			roomToCreateOrUpdate.setName(this.getParam("name"));

			RoomDAO.SaveUpdateRoom(roomToCreateOrUpdate);
			this.redirect("/BackOffice/Room/List");
		}
		else
		{
			Util.hideErrorMessage(this.req);
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
	
	private boolean addFieldsAreCorrect() {
		String ipMask = this.getParam("ipmask");
		String name = this.getParam("name");
		String[] params = {ipMask, name};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		else if(RoomDAO.roomNameAlreadyExists(name)) {
			Util.errorMessage = Message.nameAlreadyUsed;
			return false;
		}
		else if (RoomDAO.roomIpAlreadyExists(ipMask)) {
			Util.errorMessage = Message.ipAlreadyUsed;
			return false;
		}
		return true;
	}
	
	private boolean updateFieldsAreCorrect(int id) {
		String ipMask = this.getParam("ipmask");
		String name = this.getParam("name");
		String[] params = {ipMask, name};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		Room room = RoomDAO.getRoomByName(name);
		if(room != null) {
			if(name.equals(room.getName()) && id != room.getId()) {
				Util.errorMessage = Message.nameAlreadyUsed;
				return false;
			}
		}
		
		room = RoomDAO.getRoomByIp(ipMask);
		if(room != null) {
			if (ipMask.equals(room.getIpmask()) && id != room.getId()) {
				Util.errorMessage = Message.ipAlreadyUsed;
				return false;
			}
		}
		
		return true;
	}
}
