package com.majeurProjet.metier;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "Computer")
@Entity
@Table(name ="computer")
public class Computer implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_computer")
	private int id;
	@Column(name="name_computer")
	private String name;
	@Column(name="ip_computer")
	private String ip;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_room_computer")
	private Room room;
	//@JsonIgnore
	@OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
	private List<Incident> incidents = new ArrayList<Incident>();
	//@JsonIgnore
	@OneToMany(mappedBy = "computer", cascade=CascadeType.ALL)
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	@XmlTransient 
	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
	@XmlTransient 
	public List<HistoricalComputer> getHistoricals_c() {
		return historicals_c;
	}
	public State getLastHistoricals_cState()
	{
		getHistoricals_c().sort(Comparator.comparing(HistoricalComputer::getDate));
		return getHistoricals_c().get(0).getState();
	}
	public void setHistoricals_c(List<HistoricalComputer> historicals_c) {
		this.historicals_c = historicals_c;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", ip=" + ip + ", room=" + room + "]";
	}

}
