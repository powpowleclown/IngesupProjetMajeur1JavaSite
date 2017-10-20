package com.majeurProjet.controller;

import java.util.List;
import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.RoleDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.User;

public class ServletBackOfficeComputer extends ServletBackOffice {

	//LIST
	public void List()
	{
		List<Computer> computers = ComputerDAO.ListComputer();
		this.displayView(computers);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		Computer computer = null;
		Integer id = this.getParamAsInt("id_computer");
		if(id != null)
		{
			computer = ComputerDAO.getComputer(id);
		}
		
		if(this.isPostBack())
		{
			Computer computerCreate = new Computer();
			computerCreate.setId(this.getParamAsInt("id"));
			computerCreate.setIp(this.getParam("ip"));
			computerCreate.setName(this.getParam("name"));
			Room room = RoomDAO.getRoom(this.getParamAsInt("id_room"));
			computerCreate.setRoom(room);
			ComputerDAO.SaveUpdateComputer(computerCreate);
			this.redirect("/Computer/List");
		}
		this.displayView(computer);
	}
	//DELETE
	public void Delete(Computer computer)
	{
		ComputerDAO.DeleteComputer(computer);
	}
}
