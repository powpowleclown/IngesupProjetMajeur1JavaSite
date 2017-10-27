package com.majeurProjet.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.RoleDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.StateDAO;
import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.HistoricalComputer;
import com.majeurProjet.metier.HistoricalIncident;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.State;
import com.majeurProjet.metier.User;

public class ServletBackOfficeComputer extends ServletBackOffice {

	//LIST
	public void List()
	{
		List<Computer> computers = ComputerDAO.ListComputer();
		this.displayView(computers);
	}
	//DETAIL
	public void Show()
	{
		Computer computer = null;
		Integer id = this.getParamAsInt("id_computer");
		if(id != null)
		{
			computer = ComputerDAO.getComputer(id);
		}
		System.out.println(computer);
		this.displayView(computer);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		List<Object> model = new ArrayList<Object>();
		Computer computer = null;
		List<Room> rooms = RoomDAO.ListRoom();
		List<State> states = StateDAO.getStateByTable("Computer");
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
				HistoricalComputer historical = new HistoricalComputer();
				historical.setComputer(computerCreateOrUpdate);
				Calendar calendar = Calendar.getInstance();
				historical.setDate(new Date(calendar.getTime().getTime()));
				State state = StateDAO.getState(this.getParamAsInt("id_state"));
				historical.setState(state);
				computerCreateOrUpdate.getHistoricals_c().add(historical);
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
			model.add(computer);
			model.add(rooms);
			model.add(states);
			this.displayView(model);
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
