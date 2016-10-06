package com.metacube.carmgmt.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.metacube.carmgmt.dao.model.CarModel;
import com.metacube.carmgmt.dao.model.CarVOModel;
import com.metacube.carmgmt.dao.model.VehicleVOModel;
import com.metacube.carmgmt.exception.SystemException;
import com.metacube.carmgmt.vo.Car;
import com.metacube.carmgmt.vo.CarVO;
import com.metacube.carmgmt.vo.VehicleVO;


public interface CarDAO {

public void addCar(VehicleVO vehicleVO, Car car, CarVO carVO) throws SQLException, SystemException;
	
ApplicationContext context2 = new AnnotationConfigApplicationContext("mvc-dispatcher-servlet.xml");

	
	public void deleteCar(int vehicleVO_ID)throws SQLException, SystemException;
	
	public List<CarVOModel> getCarVOList()throws SQLException, SystemException;
	
	public List<CarModel> getCarList() throws SystemException;
	
	public List<VehicleVOModel> getVehicleVOList()throws SQLException, SystemException;

	public void updateCar(Car car, int vehicleVO_ID) throws SystemException, SQLException;

	public void updateCarVO(CarVO carVO, int vehicleVO_ID) throws SystemException, SQLException;

	public void updateVehicleVO(VehicleVO vehicleVO, int vehicleVO_ID) throws SystemException, SQLException;

	public void addCar(Car car) throws SystemException, SQLException;

	public void addCarVO(CarVO carVO) throws SystemException, SQLException;

	public void addVehicleVO(VehicleVO vehicleVO) throws SystemException, SQLException;
}
