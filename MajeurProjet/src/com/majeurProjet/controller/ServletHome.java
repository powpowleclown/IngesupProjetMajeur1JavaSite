package com.majeurProjet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.ComputerDataDAO;
import com.majeurProjet.dao.RoleDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.ComputerData;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.Room;
import com.majeurProjet.metier.User;
import com.majeurProjet.utils.Message;
import com.majeurProjet.utils.Util;
import com.majeurProjet.metier.Computer;

public class ServletHome extends UtilHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void Home() {
		List<Room> rooms = RoomDAO.ListRoom();
		this.displayView(rooms);
	}

	public void Connection() throws ServletException {

		if (this.isPostBack()) {
			//this.req.getRequestDispatcher( this.getParam("redirect")).forward(req, resp);
			String redirect = this.getParam("redirect");
			if(redirect != null) {
				if(redirect.equals("SignIn")) {
					this.SignIn();
				}
				else if (redirect.equals("SignUp")) {
					this.SignUp();
				}else {
					Util.errorMessage = Message.failedToConnect;
					Util.showErrorMessage(this.req, Util.errorMessage);
				}
			}else {
				Util.errorMessage = Message.failedToConnect;
				Util.showErrorMessage(this.req, Util.errorMessage);
			}
		}

		else {
			Util.hideErrorMessage(this.req);
			this.displayView(null);
		}
	}

	public void SignUp() {
		String encryptedPassword = Util.encryptPassword(this.getParam("password"));
		if (this.signUpFieldsAreCorrect(encryptedPassword)) {
			User user = new User();
			user.setMail(this.getParam("mail"));
			user.setPwd(encryptedPassword);
			user.setName(this.getParam("name"));
			user.setSurname(this.getParam("surname"));
			Role role = RoleDAO.getRoleUser();
			user.setRole(role);
			UserDAO.SaveUpdateUser(user);
			User userLog = UserDAO.getUserByMailPassword(this.getParam("mail"), encryptedPassword);
			if (userLog != null) {
				HttpSession session = this.req.getSession();
				if(session != null) {
					this.req.getSession().removeAttribute("userlog");
				}
				session.setAttribute("userlog", userLog);
				if (userLog.getRole().getRole().equals("admin")) {
					session.setAttribute("isadmin", true);
				}
			}
			this.redirect("/Home/Home");
		} else {
			Util.showErrorMessage(this.req, Util.errorMessage);
			this.displayView(null);
		}
		
	}

	public void SignIn() {
		String encryptedPassword = Util.encryptPassword(this.getParam("password"));
		if (this.signInFieldsAreCorrect(encryptedPassword)) {
			String mail = this.getParam("mail");
			User userLog = UserDAO.getUserByMailPassword(mail, encryptedPassword);
			if (userLog != null) {
				HttpSession session = this.req.getSession();
				if(session != null) {
					this.req.getSession().removeAttribute("userlog");
				}
				session.setAttribute("userlog", userLog);
				if (userLog.getRole().getRole().equals("admin")) {
					session.setAttribute("isadmin", true);
				}
				String redirect = (String) req.getSession().getAttribute("redirect");
				System.out.println(redirect);
				if (redirect != null) {
					try {
						redirect = redirect.toString();
						this.resp.sendRedirect(redirect);
						return;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						this.resp.sendRedirect("Home");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				Util.showErrorMessage(this.req, Message.failedToSignIn);
				this.displayView(null);
			}

		} else {
			Util.showErrorMessage(this.req, Util.errorMessage);
			this.displayView(null);
		}
	}

	public void Logout() {
		this.req.getSession().removeAttribute("userlog");
		try {
			this.resp.sendRedirect("Connection");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void Computer() {
		List<Object> model = new ArrayList<Object>();
		ComputerData computerData = null;
		Integer id = this.getParamAsInt("id_computer");
		if(id != null)
		{
			computerData = ComputerDataDAO.getComputerDataByComputer(id);
			Computer computer = ComputerDAO.getComputer(id);
			if (computer != null) {
				model.add(computer);
				model.add(computerData);
				this.displayView(model);
			}
			
			else{
				this.redirect("/Home/Home");
			}
		}else {
			this.redirect("/Home/Home");
		}
	}

	private boolean signUpFieldsAreCorrect(String encryptedPassword) {
		String firstname = this.getParam("name");
		String surname = this.getParam("surname");
		String email = this.getParam("mail");
		String password = this.getParam("password");
		String confirm_password = this.getParam("confirm-password");
		return Util.addFieldsAreCorrect(encryptedPassword, firstname, surname, email, password, confirm_password);

	}

	private boolean signInFieldsAreCorrect(String encryptedPassword) {
		String email = this.getParam("mail");
		String password = this.getParam("password");
		String[] params = { email, password };
		if (encryptedPassword == null) {
			Util.errorMessage = Message.failedToConnect;
			return false;
		} else {
			if (Util.aFieldIsEmpty(params)) {
				Util.errorMessage = Message.fieldIsincorrectOrMissing;
				return false;
			} else if (!UserDAO.userAlreadyExists(email, encryptedPassword)) {
				Util.errorMessage = Message.badEmailOrPassword;
				return false;
			} else {
				return true;
			}
		}

	}

}