package com.majeurProjet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.majeurProjet.dao.TestDAO;
import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.Test;
import com.majeurProjet.metier.Utilisateur;

public class ServletHome extends UtilHttpServlet {
	
	public void Inscription()
	{
		if(this.isPostBack())
		{
			Utilisateur user = new Utilisateur();
			user.setMail(this.getParam("mail"));
			user.setPassword(this.getParam("pwd"));
			user.setNom(this.getParam("nom"));
			user.setPrenom(this.getParam("prenom"));
			//Crypter pwd
			UserDAO.Save(user);;
			this.redirect("/Login/Login");
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
			Utilisateur userLog = UserDAO.Verif(mail,pwd);
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
