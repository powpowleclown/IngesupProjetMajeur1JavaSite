package com.majeurProjet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import com.majeurProjet.dao.RoleDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.User;

public class ServletHome extends UtilHttpServlet {
	
	public void Home()
	{
		List<Room> rooms = RoomDAO.ListRoom();
		this.displayView(rooms);
	}
	
	public void Signin()
	{
		if(this.isPostBack())
		{
			User user = new User();
			user.setMail(this.getParam("mail"));
			//crypto pwd
			user.setPwd(this.getParam("pwd"));
			user.setName(this.getParam("nom"));
			user.setSurname(this.getParam("prenom"));
			Role role = RoleDAO.getRoleUser();
			user.setRole(role);
			UserDAO.Save(user);;
			this.redirect("/Home/Login");
		}
		else
		{
			this.displayView(null);
		}
	}
	
	public void Login()
	{
		if(this.isPostBack())
		{
			String mail = this.getParam("mail");
			String pwd = this.getParam("pwd");
			User userLog = UserDAO.Verif(mail,pwd);
			if(userLog != null)
			{
				HttpSession session = req.getSession();
				session.setAttribute("userlog", userLog);
				String redirect = (String) req.getSession().getAttribute("redirect").toString();
				if(redirect != null)
				{
					try {
						this.resp.sendRedirect(redirect);
						return;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					try {
						resp.sendRedirect("Access");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
			else
			{
				this.redirect("/Utilisateur/Utilisateur");
			}
		}
		else
		{
			this.displayView(null);
		}	
	}
	
	public void Logout()
	{
		this.req.getSession().removeAttribute("user");
		try {
			resp.sendRedirect("Login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
