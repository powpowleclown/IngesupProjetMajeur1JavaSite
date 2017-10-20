package com.majeurProjet.metier;

import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name ="incident")
public class Incident {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_incident")
	private int id;
	@Column(name="number_incident")
	private String number;
	@Column(name="description_incident")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_computer_incident ")
	private Computer computer;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "historical_c", 
        joinColumns = { @JoinColumn(name = "id_incident") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_state") }
    )
	private List<State> states = new ArrayList<State>();
	
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
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
}
