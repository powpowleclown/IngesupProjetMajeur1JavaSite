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
			Computer computerCreateOrUpdate;
			if(id != null)
			{
				computerCreateOrUpdate = ComputerDAO.getComputer(id);
			}
			else
			{
				computerCreateOrUpdate = new Computer();
			}
			computerCreateOrUpdate.setIp(this.getParam("ip"));
			computerCreateOrUpdate.setName(this.getParam("name"));
			Room room = RoomDAO.getRoom(this.getParamAsInt("id_room"));
			computerCreateOrUpdate.setRoom(room);
			ComputerDAO.SaveUpdateComputer(computerCreateOrUpdate);
			this.redirect("/BackOffice/Computer/List");
		}
		else
		{
			this.displayView(computer);
		}
	}
	//DELETE
	public void Delete()
	{
		Integer id = this.getParamAsInt("id_computer");
		Computer computer = ComputerDAO.getComputer(id);
		ComputerDAO.DeleteComputer(computer);
		this.redirect("/BackOffice/Computer/List");
	}
}
