package com.metacube.carmgmt.dao.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "car")
public class CarModel {
	
	@Id
	@Column(name="vehicleVO_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int vehicleVO_ID;
	
	@Column(name="Created_By")
	private String Created_By;
	
	@Column(name="Created_Time")
	private Timestamp Created_Time;
	
	@Column(name="Updated_By")
	private String Updated_By;
	
	@Column(name="Updted_Time")
	private Timestamp Updted_Time;

	

	public int getVehicleVO_ID() {
		return vehicleVO_ID;
	}

	public void setVehicleVO_ID(int vehicleVO_ID) {
		this.vehicleVO_ID = vehicleVO_ID;
	}

	public String getCreated_By() {
		return Created_By;
	}

	public void setCreated_By(String created_By) {
		Created_By = created_By;
	}

	public Timestamp getCreated_Time() {
		return Created_Time;
	}

	public void setCreated_Time(Timestamp created_Time) {
		Created_Time = created_Time;
	}

	public String getUpdated_By() {
		return Updated_By;
	}

	public void setUpdated_By(String updated_By) {
		Updated_By = updated_By;
	}

	public Timestamp getUpdted_Time() {
		return Updted_Time;
	}

	public void setUpdted_Time(Timestamp updted_Time) {
		Updted_Time = updted_Time;
	}

}
