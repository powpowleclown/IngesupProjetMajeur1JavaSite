package com.majeurProjet.controller;

import java.util.Date;
import java.sql.Timestamp;
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
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;

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
				if(!this.updateFieldsAreCorrect(id)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					model.add(computer);
					model.add(rooms);
					model.add(states);
					this.displayView(model);
					return;
				}
			}
			else
			{
				computerCreateOrUpdate = new Computer();
				if(!this.addFieldsAreCorrect()) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					model.add(computer);
					model.add(rooms);
					model.add(states);
					this.displayView(model);
					return;
				}
			}
			
			HistoricalComputer historical = new HistoricalComputer();
			historical.setComputer(computerCreateOrUpdate);
			Date date = new Date();
			historical.setDate(new Timestamp(date.getTime()));
			State state = StateDAO.getState(this.getParamAsInt("id_state"));
			historical.setState(state);
			computerCreateOrUpdate.getHistoricals_c().add(historical);
			
			computerCreateOrUpdate.setIp(this.getParam("ip"));
			computerCreateOrUpdate.setMac(this.getParam("mac"));
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
	
	private boolean updateFieldsAreCorrect(int id) {
		String name = this.getParam("name");
		String ip = this.getParam("ip");
		String mac = this.getParam("mac");
		String id_state = this.getParam("id_state");
		String id_room = this.getParam("id_room");
		String[] params = {name, ip, mac, id_state, id_room};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		
		Computer computer = ComputerDAO.getComputerByName(name);
		if (computer != null) {
			if(name.equals(computer.getName()) && id != computer.getId()) {
				Util.errorMessage = Message.nameAlreadyUsed;
				return false;
			}
		}
		
		
		computer = ComputerDAO.getComputerByIp(ip);
		if (computer != null) {
			if(ip.equals(computer.getIp()) && id != computer.getId()) {
				Util.errorMessage = Message.ipAlreadyUsed;
				return false;
			}
		}
		return true;
		
	}
	
	private boolean addFieldsAreCorrect() {
		String name = this.getParam("name");
		String ip = this.getParam("ip");
		String mac = this.getParam("mac");
		String id_state = this.getParam("id_state");
		String id_room = this.getParam("id_room");
		String[] params = {name, ip, mac, id_state, id_room};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		
		if(ComputerDAO.computerNameAlreadyExists(name)) {
			Util.errorMessage = Message.nameAlreadyUsed;
			return false;
		}
		
		if(ComputerDAO.computerIpAlreadyExists(ip)) {
			Util.errorMessage = Message.ipAlreadyUsed;
			return false;
		}
		
		if(ComputerDAO.computerMacAlreadyExists(mac)) {
			Util.errorMessage = Message.macAlreadyUsed;
			return false;
		}
		return true;
	}
}
