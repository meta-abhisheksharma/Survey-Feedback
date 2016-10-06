package com.metacube.carmgmt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.carmgmt.exception.SystemException;
import com.metacube.carmgmt.facade.CarFacade;
import com.metacube.carmgmt.vo.Car;
import com.metacube.carmgmt.vo.CarVO;
import com.metacube.carmgmt.vo.VehicleVO;

@RestController("carAPIController")
@RequestMapping("/car")
public class CarAPIController {
	
	ApplicationContext context1 = new AnnotationConfigApplicationContext("application-config.xml");
	
	@Autowired
	CarFacade defaultCarFacade;
	
	
	@RequestMapping(value="/addcar" , method=RequestMethod.POST)
	public void addCar(@RequestBody  Car car) throws SystemException{
		
		defaultCarFacade.addCar( car);
	}
	
	@RequestMapping(value="/addcarvo" , method=RequestMethod.POST)
	public void addCar(@RequestBody  CarVO carVO) throws SystemException{
		
		defaultCarFacade.addCarVO( carVO);
	}
	
	@RequestMapping(value="/addvehiclevo" , method=RequestMethod.POST)
	public void addCar(@RequestBody VehicleVO vehicleVO) throws SystemException{
		
		defaultCarFacade.addVehicleVO(vehicleVO);
	}
	
	@RequestMapping(value="/updatecar/{vehicleVO_ID}" , method=RequestMethod.PUT)
	public void updateCar(@RequestBody Car car,@PathVariable int vehicleVO_ID) throws SystemException{
		System.out.println("inside updateCar "+car);
		System.out.println("vid "+vehicleVO_ID);
		defaultCarFacade.updateCar( car, vehicleVO_ID);
	}
	
	@RequestMapping(value="/updatevehiclevo/{vehicleVO_ID}" , method=RequestMethod.PUT)
	public void updateVehicleVO(@RequestBody VehicleVO vehicleVO,@PathVariable int vehicleVO_ID) throws SystemException{
		System.out.println("inside updateCar "+vehicleVO.getMake());
		System.out.println("vid "+vehicleVO_ID);
		defaultCarFacade.updateVehicleVO(vehicleVO, vehicleVO_ID);
	}
	
	@RequestMapping(value="/updatecarvo/{vehicleVO_ID}" , method=RequestMethod.PUT)
	public void updateCarVO(@RequestBody CarVO carVO,@PathVariable int vehicleVO_ID) throws SystemException{
		System.out.println("inside updateCar "+carVO.getAccessoryKit());
		System.out.println("vid "+vehicleVO_ID);
		defaultCarFacade.updateCarVO( carVO, vehicleVO_ID);
	}
	
	@RequestMapping(value="/vehiclevolist" , method=RequestMethod.GET)
	public List<VehicleVO> getVehicleVOList() throws SQLException, SystemException{
		return defaultCarFacade.getVehicleVOList();
	}
	
	
	@RequestMapping(value="/carvolist" , method=RequestMethod.GET)
	public List<CarVO> getCarVOList() throws SQLException, SystemException{
		return defaultCarFacade.getCarVOList();
	}
	
	@RequestMapping(value="/delete/{vehicleVO_ID}" , method=RequestMethod.DELETE)
	public void deleteCar(@PathVariable int vehicleVO_ID){
		 defaultCarFacade.deleteCar(vehicleVO_ID);
	}
	

	@RequestMapping(value="/carlist",method=RequestMethod.GET)
	public List<Car> getCarList() throws SystemException{
		return defaultCarFacade.getCarList();

	}
	
	}

	

