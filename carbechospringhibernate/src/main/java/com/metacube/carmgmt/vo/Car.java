package com.metacube.carmgmt.vo;

import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("car")
@Scope("prototype")
public class Car {
	private int vehicleVO_ID;
	private String Created_By;
	private Timestamp Created_Time;
	private String Updated_By;
	private Timestamp Updted_Time;

	public Car() {

	}

	public Car(String created_By) {
		Created_By = created_By;
	}

	public Car(String created_By, String updated_By) {

		Created_By = created_By;
		Updated_By = updated_By;
	}

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
