package com.majeurProjet.metier;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Role")
@Entity
@Table(name ="role")
public class Role implements Serializable{

	@Id
	@Column(name = "id_role")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="name_role")
	private String name;
	@Column(name="role_role")
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
