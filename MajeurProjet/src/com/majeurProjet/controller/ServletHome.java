package com.majeurProjet.controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import com.majeurProjet.dao.RoleDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.User;
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;

public class ServletHome extends UtilHttpServlet {
	
	private String errorMessage = "";
	
	public void Home()
	{
		List<Room> rooms = RoomDAO.ListRoom();
		this.displayView(rooms);
	}
	
	public void Connection()
	{
		this.displayView(null);
	}
	
	public void SignUp()
	{
		if(this.isPostBack())
		{
			String encryptedPassword  = Util.encryptPassword(this.getParam("password"));
			if(this.signUpFieldsAreCorrect(encryptedPassword)) {
				User user = new User();
				user.setMail(this.getParam("mail"));
				user.setPwd(encryptedPassword);
				user.setName(this.getParam("name"));
				user.setSurname(this.getParam("surname"));
				Role role = RoleDAO.getRoleUser();
				user.setRole(role);
				UserDAO.SaveUpdateUser(user);
				this.redirect("Home");
			}else {
				Util.showErrorMessage(this.req, this.errorMessage);
				this.displayView(null);
			}
		}
		else
		{
			Util.hideErrorMessage(this.req);
			this.displayView(null);
		}
	}
	
	public void SignIn()
	{
		if(this.isPostBack())
		{
			String encryptedPassword  = Util.encryptPassword(this.getParam("password"));
			if(this.signInFieldsAreCorrect(encryptedPassword)) {
				String mail = this.getParam("mail");
				User userLog = UserDAO.getUserByMailPassword(mail,encryptedPassword);
				if(userLog != null)
				{
					HttpSession session = this.req.getSession();
					session.setAttribute("userlog", userLog);
					String redirect = (String) req.getSession().getAttribute("redirect");
					if(redirect != null)
					{
						try {
							redirect = redirect.toString();
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
							this.resp.sendRedirect("Home");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					Util.showErrorMessage(this.req, Message.failedToSignIn);
					this.displayView(null);
				}
			
			}else{
				Util.showErrorMessage(this.req, this.errorMessage);
				this.displayView(null);;
			}
		}else{
			Util.hideErrorMessage(this.req);
			this.displayView(null);
		}	
	}
	
	public void Logout()
	{
		this.req.getSession().removeAttribute("user");
		try {
			this.resp.sendRedirect("SignIn");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private boolean signUpFieldsAreCorrect(String encryptedPassword) {
        String firstname = this.getParam("name");
        String surname = this.getParam("surname");
        String email = this.getParam("mail");
        String password = this.getParam("password");
        String confirm_password = this.getParam("confirm-password");
        System.out.println(UserDAO.getUserByMailPassword(email, encryptedPassword));
        if (encryptedPassword == null) {
        	this.errorMessage = Message.failedToConnect;
        	return false;
        }else {
        	String[] paramsName = {firstname, surname, email, password, confirm_password};
            if (Util.aFieldIsEmpty(paramsName)) {
                this.errorMessage = Message.fieldIsincorrectOrMissing;
                return false;

            } else if (!Util.isSamePasswords(password, confirm_password)) {
                this.errorMessage = Message.passwordsNotMatching;
                return false;
            } else if (UserDAO.userAlreadyExists(email, encryptedPassword)) {
                this.errorMessage = Message.emailAlreadyUsed;
                return false;
            } else {
                return true;
            }
        }

        
    }

    private boolean signInFieldsAreCorrect(String encryptedPassword) {
        String email = this.getParam("mail");
        String password = this.getParam("password");
        String[] params = {email, password};
        if (encryptedPassword == null) {
        	this.errorMessage = Message.failedToConnect;
        	return false;
        }else {
        	if (Util.aFieldIsEmpty(params)) {
                this.errorMessage = Message.fieldIsincorrectOrMissing;
                return false;
            } else if (!UserDAO.userAlreadyExists(email, encryptedPassword)) {
                this.errorMessage = Message.badEmailOrPassword;
                return false;
            } else {
                return true;
            }
        }
        
    }
}
