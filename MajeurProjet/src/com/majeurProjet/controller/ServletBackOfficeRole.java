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
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;

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
				if(!this.updateFieldsAreCorrect(id)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(roleCreateOrUpdate);
					return;
				}
			}
			else
			{
				roleCreateOrUpdate = new Role();
				if(!this.addFieldsAreCorrect()) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(null);
					return;
				}
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
	
	private boolean addFieldsAreCorrect() {
		String name = this.getParam("name");
		String role = this.getParam("role");
		String[] params = {name, role};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		if(RoleDAO.roleNameAlreadyExists(name)) {
			Util.errorMessage = Message.nameAlreadyUsed;
			return false;
		}
		return true;
	}
	
	private boolean updateFieldsAreCorrect(int id) {
		String name = this.getParam("name");
		String role = this.getParam("role");
		String[] params = {name, role};
		if(Util.aFieldIsEmpty(params)) {
			Util.errorMessage = Message.fieldIsincorrectOrMissing;
			return false;
		}
		Role roleObject = RoleDAO.getRoleByName(name);
		if(roleObject != null) {
			if(name.equals(roleObject.getName()) && id != roleObject.getId()) {
				Util.errorMessage = Message.nameAlreadyUsed;
				return false;
			}
		}
		return true;
	}
}
