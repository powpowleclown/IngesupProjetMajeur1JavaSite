package com.majeurProjet.metier;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "Incident")
@Entity
@Table(name ="incident")
public class Incident implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_incident")
	private int id;
	@Column(name="number_incident")
	private String number;
	@Column(name="description_incident")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_computer_incident")
	private Computer computer; 
	@OneToMany(mappedBy = "incident", cascade=CascadeType.ALL)
	private List<HistoricalIncident> historicals_i = new ArrayList<HistoricalIncident>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	@XmlTransient
	public List<HistoricalIncident> getHistoricals_i() {
		return historicals_i;
	}
	@XmlTransient
	public State getLastHistoricals_iState()
	{
		getHistoricals_i().sort(Comparator.comparing(HistoricalIncident::getDate));
		return getHistoricals_i().get(0).getState();
	}
	public void setHistoricals_i(List<HistoricalIncident> historicals_i) {
		this.historicals_i = historicals_i;
	}
	@Override
	public String toString() {
		return "Incident [id=" + id + ", number=" + number + ", description=" + description + ", computer=" + computer
				+ "]";
	}

}
