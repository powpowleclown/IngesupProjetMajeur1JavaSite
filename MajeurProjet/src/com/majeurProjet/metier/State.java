package com.majeurProjet.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="state")
public class State {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_state")
	private int id;
	@Column(name="name_state")
	private String name;
	@Column(name="table_state")
	private String table;
	@ManyToMany(mappedBy = "states")
	private List<Incident> incidents = new ArrayList<Incident>();
	@ManyToMany(mappedBy = "states")
	private List<Computer> computers = new ArrayList<Computer>();
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
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public List<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
	public List<Computer> getComputers() {
		return computers;
	}
	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
}