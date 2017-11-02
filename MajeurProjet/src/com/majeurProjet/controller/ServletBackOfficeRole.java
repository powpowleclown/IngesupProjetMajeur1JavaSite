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

public class ServletBackOfficeRole extends ServletBackOffice {

	//LIST
	public void List()
	{
		List<Role> roles = RoleDAO.ListRole();
		this.displayView(roles);
	}
	//DETAIL
	public void Show()
	{
		Role role = null;
		Integer id = this.getParamAsInt("id_role");
		if(id != null)
		{
			role = RoleDAO.getRole(id);
		}
		this.displayView(role);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		Role role = null;
		Integer id = this.getParamAsInt("id_role");
		if(id != null)
		{
			role = RoleDAO.getRole(id);
		}
		
		if(this.isPostBack())
		{
			Role roleCreateOrUpdate;
			if(id != null)
			{
				roleCreateOrUpdate = RoleDAO.getRole(id);
			}
			else
			{
				roleCreateOrUpdate = new Role();
			}
			
			roleCreateOrUpdate.setName(this.getParam("name"));
			roleCreateOrUpdate.setRole(this.getParam("role"));
			RoleDAO.SaveUpdateRole(roleCreateOrUpdate);
			this.redirect("/BackOffice/Role/List");
		}
		else
		{
			this.displayView(role);
		}
	}
	//DELETE
	public void Delete()
	{
		Integer id = this.getParamAsInt("id_role");
		Role role = RoleDAO.getRole(id);
		RoleDAO.DeleteRole(role);
		this.redirect("/BackOffice/Role/List");
	}
}
