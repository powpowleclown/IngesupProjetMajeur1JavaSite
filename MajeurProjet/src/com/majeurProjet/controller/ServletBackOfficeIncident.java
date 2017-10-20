package com.majeurProjet.controller;

import java.util.List;

import com.majeurProjet.dao.IncidentDAO;
import com.majeurProjet.metier.Incident;

public class ServletBackOfficeIncident extends ServletBackOffice {
	
	//LIST
	public void List()
	{
		List<Incident> incidents = IncidentDAO.ListIncident();
		this.displayView(incidents);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		this.displayView(null);
	}
	//DELETE
	public void Delete(Incident incident)
	{
		IncidentDAO.DeleteIncident(incident);
	}

}
