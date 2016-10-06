package com.metacube.carmgmt.facade;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.metacube.carmgmt.exception.SystemException;
import com.metacube.carmgmt.vo.Car;
import com.metacube.carmgmt.vo.CarVO;
import com.metacube.carmgmt.vo.VehicleVO;

@Component
public interface CarFacade {

	public void addCar(VehicleVO vehicleVO, Car car, CarVO carVO) throws SystemException;
	public void updateCar( Car car,  int vehicleVO_ID) throws SystemException;
	public void updateCarVO( CarVO carVO, int vehicleVO_ID) throws SystemException;
	public void updateVehicleVO(VehicleVO vehicleVO, int vehicleVO_ID) throws SystemException;
	public List<VehicleVO> getVehicleVOList() throws SQLException, SystemException;
	public List<Car> getCarList() throws SystemException;
	public List<CarVO> getCarVOList() throws SQLException, SystemException;
	public void deleteCar(int vehicleVO_ID);
	public void addVehicleVO(VehicleVO vehicleVO) throws SystemException;
	public void addCarVO(CarVO carVO) throws SystemException;
	public void addCar(Car car) throws SystemException;
}
