package com.metacube.carmgmt.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carvo")
public class CarVOModel {

	@Id
	@Column(name="vehicleVO_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int vehicleVO_ID;
	
	@Column(name="AC")
	private int ac;
	
	@Column(name="powerSteering")
	private int powerSteering;
	
	@Column(name="accessoryKit")
	private int accessoryKit;

	

	public int getVehicleVO_ID() {
		return vehicleVO_ID;
	}

	public void setVehicleVO_ID(int vehicleVO_ID) {
		this.vehicleVO_ID = vehicleVO_ID;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(int powerSteering) {
		this.powerSteering = powerSteering;
	}

	public int getAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(int accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

}
