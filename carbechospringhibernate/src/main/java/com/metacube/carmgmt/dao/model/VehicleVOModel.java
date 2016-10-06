package com.metacube.carmgmt.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiclevo")
public class VehicleVOModel {

	@Id
	@Column(name="VehicleVO_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int vehicleVO_ID;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="engineInCC")
	private float engineInCC;
	
	@Column(name="fuelCapacity")
	private float fuelCapacity;
	
	@Column(name="milage")
	private float mileage;
	
	@Column(name="price")
	private float price;
	
	@Column(name="roadTax")
	private float roadTax;

	

	public int getVehicleVO_ID() {
		return vehicleVO_ID;
	}

	public void setVehicleVO_ID(int vehicleVO_ID) {
		this.vehicleVO_ID = vehicleVO_ID;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getEngineInCC() {
		return engineInCC;
	}

	public void setEngineInCC(float engineInCC) {
		this.engineInCC = engineInCC;
	}

	public float getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(float fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public float getMileage() {
		return mileage;
	}

	public void setMileage(float mileage) {
		this.mileage = mileage;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(float roadTax) {
		this.roadTax = roadTax;
	}
}
