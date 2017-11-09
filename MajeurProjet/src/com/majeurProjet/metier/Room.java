package com.majeurProjet.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;*/

@XmlRootElement()
//@JsonPropertyOrder({"id", "name", "ipmask"})
@Entity
@Table(name ="room")
public class Room implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_room")
	private int id;
	@Column(name="name_room")
	private String name;
	@Column(name="ipmask_room")
	private String ipmask;
	//@JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
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
	public String getIpmask() {
		return ipmask;
	}
	public void setIpmask(String ipmask) {
		this.ipmask = ipmask;
	}
	@XmlTransient
	public List<Computer> getComputers() {
		return computers;
	}
	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", ipmask=" + ipmask + "]";
	}
}
