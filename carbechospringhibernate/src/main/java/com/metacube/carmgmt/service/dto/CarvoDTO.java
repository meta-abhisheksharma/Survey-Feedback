package com.metacube.carmgmt.service.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("carvoDTO")
@Scope("prototype")
public class CarvoDTO {

	private int vehicleVO_ID;
	private int ac;
	private int powerSteering;
	private int accessoryKit;

	public int getVehicleVO_ID() {
		return vehicleVO_ID;
	}

	public void setVehicleVO_ID(int vehicleVO_ID) {
		this.vehicleVO_ID = vehicleVO_ID;
	}

	public int isAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int isPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(int powerSteering) {
		this.powerSteering = powerSteering;
	}

	public int isAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(int accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

}
