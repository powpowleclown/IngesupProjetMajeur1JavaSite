package com.majeurProjet.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "state")
	private List<HistoricalIncident> historicals_i = new ArrayList<HistoricalIncident>();
	@OneToMany(mappedBy = "state")
	private List<HistoricalComputer> historicals_c = new ArrayList<HistoricalComputer>();
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
	public List<HistoricalIncident> getHistoricals_i() {
		return historicals_i;
	}
	public void setHistoricals_i(List<HistoricalIncident> historicals_i) {
		this.historicals_i = historicals_i;
	}
	public List<HistoricalComputer> getHistoricals_c() {
		return historicals_c;
	}
	public void setHistoricals_c(List<HistoricalComputer> historicals_c) {
		this.historicals_c = historicals_c;
	}
}