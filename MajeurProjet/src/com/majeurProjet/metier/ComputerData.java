package com.majeurProjet.metier;

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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ComputerData")
@Entity
@Table(name ="computer_d")
public class ComputerData {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_computer_d")
	private int id;
	@Column(name="processor_computer_d")
	private String processor;
	@Column(name="free_memory_computer_d")
	private String freeMemory;
	@Column(name="max_memory_computer_d")
	private String maxMemory;
	@Column(name="total_memory_computer_d")
	private String totalMemory;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_computer_computer_d")
	private Computer computer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getFreeMemory() {
		return freeMemory;
	}
	public void setFreeMemory(String freeMemory) {
		this.freeMemory = freeMemory;
	}
	public String getMaxMemory() {
		return maxMemory;
	}
	public void setMaxMemory(String maxMemory) {
		this.maxMemory = maxMemory;
	}
	public String getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(String totalMemory) {
		this.totalMemory = totalMemory;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
}
