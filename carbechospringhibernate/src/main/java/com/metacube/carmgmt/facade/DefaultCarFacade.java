package com.metacube.carmgmt.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.carmgmt.dao.CarDAO;
import com.metacube.carmgmt.dao.model.CarModel;
import com.metacube.carmgmt.dao.model.CarVOModel;
import com.metacube.carmgmt.dao.model.VehicleVOModel;
import com.metacube.carmgmt.exception.SystemException;
import com.metacube.carmgmt.vo.Car;
import com.metacube.carmgmt.vo.CarVO;
import com.metacube.carmgmt.vo.VehicleVO;
import com.metacube.carmgmt.vo.factory.BeanFactory;

@Component("defaultCarFacade")
public class DefaultCarFacade implements CarFacade {

	@Autowired
	CarDAO defaultCarDAO;

	@Autowired
	BeanFactory beanFactory;

	public void addCar(VehicleVO vehicleVO, Car car, CarVO carVO)
			throws SystemException {

		try {
			defaultCarDAO.addCar(vehicleVO, car, carVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<VehicleVO> getVehicleVOList() throws SQLException,
			SystemException {

		List<VehicleVOModel> vehicleVOModelList = defaultCarDAO
				.getVehicleVOList();
		List<VehicleVO> vehicleVOList = new ArrayList<VehicleVO>();
		for (VehicleVOModel vehicleVOModel : vehicleVOModelList) {
			VehicleVO vehicleVO = beanFactory.getVehicleVO();

			BeanUtils.copyProperties(vehicleVO, vehicleVOModel);
			vehicleVOList.add(vehicleVO);
		}

		return vehicleVOList;
	}

	public List<Car> getCarList() throws SystemException {
		List<CarModel> carModelList = defaultCarDAO.getCarList();
		List<Car> carList = new ArrayList<Car>();
		for (CarModel carModel : carModelList) {
			Car car = beanFactory.getCar();

			BeanUtils.copyProperties(car, carModel);
			carList.add(car);
		}

		return carList;
	}

	public List<CarVO> getCarVOList() throws SQLException, SystemException {
		List<CarVOModel> carVOModelList = defaultCarDAO.getCarVOList();
		List<CarVO> carVOList = new ArrayList<CarVO>();
		for (CarVOModel carVOModel : carVOModelList) {
			CarVO carVO = beanFactory.getCarVO();

			BeanUtils.copyProperties(carVO, carVOModel);
			carVOList.add(carVO);
		}

		return carVOList;
	}

	public void deleteCar(int vehicleVO_ID) {
		try {
			defaultCarDAO.deleteCar(vehicleVO_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCar(Car car, int vehicleVO_ID) throws SystemException {
		try {
			defaultCarDAO.updateCar(car, vehicleVO_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateCarVO(CarVO carVO, int vehicleVO_ID)
			throws SystemException {
		try {
			defaultCarDAO.updateCarVO(carVO, vehicleVO_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateVehicleVO(VehicleVO vehicleVO, int vehicleVO_ID)
			throws SystemException {
		try {
			defaultCarDAO.updateVehicleVO(vehicleVO, vehicleVO_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addVehicleVO(VehicleVO vehicleVO) throws SystemException {
		try {
			defaultCarDAO.addVehicleVO(vehicleVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addCarVO(CarVO carVO) throws SystemException {
		try {
			defaultCarDAO.addCarVO(carVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addCar(Car car) throws SystemException {
		try {
			defaultCarDAO.addCar(car);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
