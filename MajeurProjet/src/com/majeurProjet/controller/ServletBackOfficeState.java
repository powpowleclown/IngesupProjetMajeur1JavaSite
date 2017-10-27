package com.majeurProjet.controller;

import java.util.ArrayList;
import java.util.List;
import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.StateDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.State;

public class ServletBackOfficeState extends ServletBackOffice {

	//LIST
	public void List()
	{
		List<State> states = StateDAO.ListState();
		this.displayView(states);
	}
	//DETAIL
	public void Show()
	{
		State state = null;
		Integer id = this.getParamAsInt("id_state");
		if(id != null)
		{
			state = StateDAO.getState(id);
		}
		this.displayView(state);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		State state = null;
		Integer id = this.getParamAsInt("id_state");
		if(id != null)
		{
			state = StateDAO.getState(id);
		}
		
		if(this.isPostBack())
		{
			State stateCreateOrUpdate;
			if(id != null)
			{
				stateCreateOrUpdate = StateDAO.getState(id);
			}
			else
			{
				stateCreateOrUpdate = new State();
			}
			stateCreateOrUpdate.setName(this.getParam("name"));
			stateCreateOrUpdate.setTable(this.getParam("table"));
			StateDAO.SaveUpdateState(stateCreateOrUpdate);
			this.redirect("/BackOffice/State/List");
		}
		else
		{
			this.displayView(state);
		}
	}
	//DELETE
	public void Delete()
	{
		Integer id = this.getParamAsInt("id_state");
		State state = StateDAO.getState(id);
		StateDAO.DeleteState(state);
		this.redirect("/BackOffice/State/List");
	}
}
