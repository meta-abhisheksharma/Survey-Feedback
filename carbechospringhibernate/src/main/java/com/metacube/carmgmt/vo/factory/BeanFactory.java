package com.metacube.carmgmt.vo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.carmgmt.vo.Car;
import com.metacube.carmgmt.vo.CarVO;
import com.metacube.carmgmt.vo.VehicleVO;

@Component
public class BeanFactory {
	@Autowired
	CarVO carVO;
	
	@Autowired
	VehicleVO vehicleVO;
	
	@Autowired
	Car car;

	public CarVO getCarVO() {
		return carVO;
	}

	public void setCarVO(CarVO carVO) {
		this.carVO = carVO;
	}

	public VehicleVO getVehicleVO() {
		return vehicleVO;
	}

	public void setVehicleVO(VehicleVO vehicleVO) {
		this.vehicleVO = vehicleVO;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
