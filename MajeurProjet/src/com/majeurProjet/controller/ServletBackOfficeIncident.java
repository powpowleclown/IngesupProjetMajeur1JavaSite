package com.majeurProjet.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.IncidentDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.StateDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.HistoricalIncident;
import com.majeurProjet.metier.Incident;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.State;
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;

public class ServletBackOfficeIncident extends ServletBackOffice {
	
	//LIST
	public void List()
	{
		List<Incident> incidents = IncidentDAO.ListIncident();
		this.displayView(incidents);
	}
	//DETAIL
	public void Show()
	{
		Incident incident = null;
		Integer id = this.getParamAsInt("id_incident");
		if(id != null)
		{
			incident = IncidentDAO.getIncident(id);
		}
		this.displayView(incident);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		List<Object> model = new ArrayList<Object>();
		Incident incident = null;
		List<Computer> computers = ComputerDAO.ListComputer();
		List<State> states = StateDAO.getStateByTable("Incident");
		Integer id = this.getParamAsInt("id_incident");
		if(id != null)
		{
			incident = IncidentDAO.getIncident(id);
		}
		
		if(this.isPostBack())
		{
			Incident incidentCreateOrUpdate;
			if(id != null)
			{
				incidentCreateOrUpdate = IncidentDAO.getIncident(id);
				if(!this.updateFieldsAreCorrect(id)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					model.add(incident);
					model.add(computers);
					model.add(states);
					this.displayView(model);
					return;
				}
			}
			else
			{
				incidentCreateOrUpdate = new Incident();
				if (!this.addFieldsAreCorrect()) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					model.add(incident);
					model.add(computers);
					model.add(states);
					this.displayView(model);
					return;
				}
			}
	
			HistoricalIncident historical = new HistoricalIncident();
			historical.setIncident(incidentCreateOrUpdate);
			Calendar calendar = Calendar.getInstance();
			historical.setDate(new Date(calendar.getTime().getTime()));
			State state = StateDAO.getState(this.getParamAsInt("id_state"));
			historical.setState(state);
			incidentCreateOrUpdate.getHistoricals_i().add(historical);
			
			incidentCreateOrUpdate.setNumber(this.getParam("number"));
			incidentCreateOrUpdate.setDescription(this.getParam("description"));
			Computer computer = ComputerDAO.getComputer(this.getParamAsInt("id_computer"));
			incidentCreateOrUpdate.setComputer(computer);
			
			//State state = StateDAO.getState(this.getParamAsInt("id_state"));
			//incidentCreateOrUpdate.setState(state);
			IncidentDAO.SaveUpdateIncident(incidentCreateOrUpdate);
			this.redirect("/BackOffice/Incident/List");
		}
		else
		{
			model.add(incident);
			model.add(computers);
			model.add(states);
			this.displayView(model);
		}
	}
	//DELETE
	public void Delete()
	{
		Integer id = this.getParamAsInt("id_incident");
		Incident incident = IncidentDAO.getIncident(id);
		IncidentDAO.DeleteIncident(incident);
		this.redirect("/BackOffice/Incident/List");
	}
	
	private boolean updateFieldsAreCorrect(int id) {
		String number = this.getParam("number");
		String description = this.getParam("description");
		String id_state = this.getParam("id_state");
		String id_computer = this.getParam("id_computer");
		String[] params = {number, description ,id_state, id_computer};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		Incident incident = IncidentDAO.getIncidentByNumber(number);
		if(incident != null) {
			if(number.equals(incident.getNumber()) && id != incident.getId()) {
				Util.errorMessage = Message.numberAlreadyUsed;
				return false;
			}
		}
		return true;
	}
	
	private boolean addFieldsAreCorrect() {
		String number = this.getParam("number");
		String description = this.getParam("description");
		String id_state = this.getParam("id_state");
		String id_computer = this.getParam("id_computer");
		String[] params = {number, description ,id_state, id_computer};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		
		if(IncidentDAO.incidentAlreadyExists(number)) {
			Util.errorMessage = Message.numberAlreadyUsed;
			return false;
		}
		return true;
	}

}
