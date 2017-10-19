package com.majeurProjet.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="name_user")
	private String name;
	@Column(name="surname_user")
	private String surname;
	@Column(name="pwd_user")
	private String pwd;
	@Column(name="mail_user")
	private String mail;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Role role;
}
