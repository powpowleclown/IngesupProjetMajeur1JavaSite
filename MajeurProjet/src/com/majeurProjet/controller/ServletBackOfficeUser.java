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

public class ServletBackOfficeUser extends ServletBackOffice {

	//LIST
	public void List()
	{
		List<User> users = UserDAO.ListUser();
		this.displayView(users);
	}
	//DETAIL
	public void Show()
	{
		User user = null;
		Integer id = this.getParamAsInt("id_user");
		if(id != null)
		{
			user = UserDAO.getUser(id);
		}
		this.displayView(user);
	}
	//ADD / UPDATE
	public void AddOrUpdate()
	{
		List<Object> model = new ArrayList<Object>();
		User user = null;
		List<Role> roles = RoleDAO.ListRole();
		Integer id = this.getParamAsInt("id_user");
		if(id != null)
		{
			user = UserDAO.getUser(id);
		}
		
		if(this.isPostBack())
		{
			User userCreateOrUpdate;
			if(id != null)
			{
				userCreateOrUpdate = UserDAO.getUser(id);
			}
			else
			{
				userCreateOrUpdate = new User();
			}			
			
			userCreateOrUpdate.setMail(this.getParam("mail"));
			userCreateOrUpdate.setPwd(this.getParam("pwd"));
			userCreateOrUpdate.setSurname(this.getParam("surname"));
			userCreateOrUpdate.setName(this.getParam("name"));
			Role role = RoleDAO.getRole(this.getParamAsInt("id_role"));
			userCreateOrUpdate.setRole(role);
			UserDAO.SaveUpdateUser(userCreateOrUpdate);
			this.redirect("/BackOffice/User/List");
		}
		else
		{
			model.add(user);
			model.add(roles);
			this.displayView(model);
		}
	}
	//DELETE
	public void Delete()
	{
		Integer id = this.getParamAsInt("id_user");
		User user = UserDAO.getUser(id);
		UserDAO.DeleteUser(user);
		this.redirect("/BackOffice/User/List");
	}
}
