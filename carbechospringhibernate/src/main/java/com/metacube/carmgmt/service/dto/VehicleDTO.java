package com.metacube.carmgmt.service.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("vehicleDTO")
@Scope("prototype")
public class VehicleDTO {

	private int vehicleVO_ID;
	private String make;
	private String model;
	private float engineInCC;
	private float fuelCapacity;
	private float mileage;
	private float price;
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
