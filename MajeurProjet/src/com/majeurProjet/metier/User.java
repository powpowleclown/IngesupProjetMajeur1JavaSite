package com.majeurProjet.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
@Entity
@Table(name ="user")
public class User implements Serializable{
	
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="firstname_user")
	private String firstname;
	@Column(name="surname_user")
	private String surname;
	@Column(name="pwd_user")
	private String pwd;
	@Column(name="mail_user")
	private String mail;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_role_user")
	private Role role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setName(String name) {
		this.firstname = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", pwd=" + pwd + ", mail="
				+ mail + ", role=" + role + "]";
	}
}
