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
			String encryptedPassword = Util.encryptPassword(this.getParam("password"));
			if(id != null)
			{
				userCreateOrUpdate = UserDAO.getUser(id);
				if(!updateFieldsAreCorrect(id, encryptedPassword)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					model.add(user);
					model.add(roles);
					this.displayView(model);
					return;
				}else {
					userCreateOrUpdate.setPwd(userCreateOrUpdate.getPwd());
				}
			}
			else
			{
				userCreateOrUpdate = new User();
				if(!addFieldsAreCorrect(encryptedPassword)) {
					Util.showErrorMessage(this.req, Util.errorMessage);
					this.displayView(null);
					return;
				}else {
					userCreateOrUpdate.setPwd(encryptedPassword);
				}
			}			
			
			userCreateOrUpdate.setMail(this.getParam("mail"));
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
	
	private boolean updateFieldsAreCorrect(int id, String encryptedPassword) {
		String firstname = this.getParam("name");
        String surname = this.getParam("surname");
        String email = this.getParam("mail");
        if (encryptedPassword == null) {
        	Util.errorMessage = Message.failedToConnect;
        	return false;
        }else {
        	String[] paramsName = {firstname, surname, email};
            if (Util.aFieldIsEmpty(paramsName)) {
                Util.errorMessage = Message.fieldIsincorrectOrMissing;
                return false;

            }
            User user = UserDAO.getUserByMail(email);
            if (email.equals(user.getMail()) && id != user.getId()) {
                Util.errorMessage = Message.emailAlreadyUsed;
                return false;
            } 
            return true;
            
        }	
	}
	
	private boolean addFieldsAreCorrect(String encryptedPassword) {
		String firstname = this.getParam("name");
        String surname = this.getParam("surname");
        String email = this.getParam("mail");
        String password = this.getParam("password");
        String confirm_password = this.getParam("confirm-password");
        return Util.addFieldsAreCorrect(encryptedPassword, firstname, surname, email, password, confirm_password);
	}
}
