package com.majeurProjet.metier;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HistoricalComputer")
@Entity
@Table(name = "historical_c")
public class HistoricalComputer implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_historical_c")
	private int id;
	@Column(name="date_historical_c")
	private Timestamp date;
	
	private String note;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_computer_historical_c")
	private Computer computer;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_state_historical_c")
	private State state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "HistoricalComputer [id=" + id + ", date=" + date + ", note=" + note + ", computer=" + computer
				+ ", state=" + state + "]";
	}
}
