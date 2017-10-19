package com.majeurProjet.metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="computer")
public class Computer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int id;
	@Column(name="name_computer")
	private String name;
	@Column(name="ip_computer")
	private String ip;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_room_computer")
	private Room room;
	
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
}
