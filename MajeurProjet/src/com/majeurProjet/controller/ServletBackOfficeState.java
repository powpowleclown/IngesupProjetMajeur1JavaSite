package com.majeurProjet.controller;

import java.util.ArrayList;
import java.util.List;
import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.StateDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.State;
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;

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
				if (!this.updateFieldsAreCorrect(id)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(stateCreateOrUpdate);
					return;
				}
			}
			else
			{
				stateCreateOrUpdate = new State();
				if (!this.addFieldsAreCorrect()) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(null);
					return;
				}
			}
			stateCreateOrUpdate.setName(this.getParam("name"));
			stateCreateOrUpdate.setTable(this.getParam("table"));
			StateDAO.SaveUpdateState(stateCreateOrUpdate);
			this.redirect("/BackOffice/State/List");
		}
		else
		{
			Util.hideErrorMessage(this.req);
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
	
	public boolean updateFieldsAreCorrect(int id) {
		String name = this.getParam("name");
		String table = this.getParam("table");
		String[] params = {name, table};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		State state = StateDAO.getStateByNameAndTable(name, table);
		if(state != null) {
			if(name.equals(state.getName()) && table.equals(state.getTable()) && id != state.getId()) {
				Util.errorMessage = Message.nameAlreadyUsed;
				return false;
			}
		}
		return true;
	}
	
	public boolean addFieldsAreCorrect() {
		String name = this.getParam("name");
		String table = this.getParam("table");
		String[] params = {name, table};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		if(StateDAO.stateAlreadyExists(name, table)) {
			Util.errorMessage = Message.nameAlreadyUsed;
			return false;
		}
		return true;
	}
}
