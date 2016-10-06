
package com.metacube.carmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.carmgmt.dao.model.CarModel;
import com.metacube.carmgmt.dao.model.CarVOModel;
import com.metacube.carmgmt.dao.model.VehicleVOModel;
import com.metacube.carmgmt.exception.SystemException;
import com.metacube.carmgmt.vo.Car;
import com.metacube.carmgmt.vo.CarVO;
import com.metacube.carmgmt.vo.VehicleVO;

@Component("defaultCarDAO")
public class DefaultCarDAO implements CarDAO{

	int vehicleVO_ID ;
	
	@Autowired
	private SessionFactory sessionFactory; //To create a session for the database operation

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addCar(VehicleVO vehicleVO, Car car, CarVO carVO)
			throws SQLException, SystemException {

		


		

	}

	
	public void deleteCar(int vehicleVO_ID) throws SQLException,
			SystemException {
		Connection con = ConnectionFactory.getInstance().getConnection();

		String deleteFromCar = "delete from Car where vehicleVO_ID=?";
		PreparedStatement pstmt3 = con.prepareStatement(deleteFromCar);
		pstmt3.setInt(1, vehicleVO_ID);
		pstmt3.executeUpdate();

		String deleteFromCarVO = "delete from CarVO where vehicleVO_ID=?";
		PreparedStatement pstmt4 = con.prepareStatement(deleteFromCarVO);
		pstmt4.setInt(1, vehicleVO_ID);
		pstmt4.executeUpdate();

		String deleteFromVehicleVO = "delete from vehiclevo where vehicleVO_ID=?";
		PreparedStatement pstmt5 = con.prepareStatement(deleteFromVehicleVO);
		pstmt5.setInt(1, vehicleVO_ID);
		pstmt5.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<CarVOModel>  getCarVOList() throws SystemException {
		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteriaQuery =  session.createCriteria(CarVOModel.class);
		return criteriaQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<CarModel> getCarList() throws SystemException {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteriaQuery =  session.createCriteria(CarModel.class);
			return criteriaQuery.list();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	
	@SuppressWarnings("unchecked")
	public List<VehicleVOModel> getVehicleVOList() throws SystemException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria criteriaQuery =  session.createCriteria(VehicleVOModel.class);
			return criteriaQuery.list();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	public void updateCar(Car car, int vehicleVO_ID) throws SystemException, SQLException {
		Connection con = ConnectionFactory.getInstance().getConnection();

		String updateIntoCar = "Update   `carbecho`.`car` set `Updated_By`=?,`Updated_Time`=? where VehicleVO_ID = ?";
		PreparedStatement pstmt1 = con.prepareStatement(updateIntoCar);

		pstmt1.setString(1, car.getUpdated_By());
		pstmt1.setTimestamp(2, new Timestamp(new Date().getTime()));
		pstmt1.setInt(3, vehicleVO_ID);

		pstmt1.executeUpdate();
		
	}

	public void updateCarVO(CarVO carVO, int vehicleVO_ID) throws SystemException, SQLException {
		Connection con = ConnectionFactory.getInstance().getConnection();

		String updateIntoCarVO = "Update `carbecho`.`carvo` set `AC`=?, `powerSteering`=?, `accessoryKit`=? where VehicleVO_ID = ?";
		PreparedStatement pstmt2 = con.prepareStatement(updateIntoCarVO);
		pstmt2.setInt(1, carVO.getAc());
		pstmt2.setInt(2, carVO.getPowerSteering());
		pstmt2.setInt(3, carVO.getAccessoryKit());
		pstmt2.setInt(4, vehicleVO_ID);
		pstmt2.executeUpdate();
		
	}

	public void updateVehicleVO(VehicleVO vehicleVO, int vehicleVO_ID) throws SystemException, SQLException {
		Connection con = ConnectionFactory.getInstance().getConnection();

		String updateIntoVehicleVO = "Update vehiclevo set make = ?, model =? , engineInCC=? , fuelCapacity=? , milage =? , price =? , roadTax = ? where VehicleVO_ID = ?";

		PreparedStatement pstmt = con.prepareStatement(updateIntoVehicleVO);

		pstmt.setString(1, vehicleVO.getMake());
		pstmt.setString(2, vehicleVO.getModel());
		pstmt.setFloat(3, vehicleVO.getEngineInCC());
		pstmt.setFloat(4, vehicleVO.getFuelCapacity());
		pstmt.setFloat(5, vehicleVO.getMileage());
		pstmt.setFloat(6, vehicleVO.getPrice());
		pstmt.setFloat(7, vehicleVO.getRoadTax());
		pstmt.setInt(8, vehicleVO_ID);
		pstmt.executeUpdate();

		
		
	}


	public void addCar(Car car) throws SystemException, SQLException {
		
		Connection con = ConnectionFactory.getInstance().getConnection();
		String addIntoCar = "INSERT INTO `carbecho`.`car` (`vehicleVO_ID`,`Created_By`,`Updated_By`,`Updated_Time`) VALUES(?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(addIntoCar);
		pstmt1.setInt(1, vehicleVO_ID);
		pstmt1.setString(2, car.getCreated_By());
		pstmt1.setString(3, car.getUpdated_By());
		pstmt1.setTimestamp(4, new Timestamp(new Date().getTime()));
		pstmt1.executeUpdate();
		
	}


	public void addCarVO(CarVO carVO) throws SystemException, SQLException {
		
		Connection con = ConnectionFactory.getInstance().getConnection();
		String addIntoCarVO = "INSERT INTO `carbecho`.`carvo` ( `AC`, `powerSteering`, `accessoryKit`, `vehicleVO_ID`) VALUES (?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(addIntoCarVO);
		pstmt2.setInt(1, carVO.getAc());
		pstmt2.setInt(2, carVO.getPowerSteering());
		pstmt2.setInt(3, carVO.getAccessoryKit());
		pstmt2.setInt(4, vehicleVO_ID);
		pstmt2.executeUpdate();
		
	}


	public void addVehicleVO(VehicleVO vehicleVO) throws SystemException, SQLException{
		Connection con = ConnectionFactory.getInstance().getConnection();

		String addIntoVehicleVO = "INSERT INTO vehiclevo (`make`, `model`, `engineInCC`, `fuelCapacity`, `milage`, `price`, `roadTax`)"
				+ "VALUES(?,?,?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(addIntoVehicleVO);

		pstmt.setString(1, vehicleVO.getMake());
		pstmt.setString(2, vehicleVO.getModel());
		pstmt.setFloat(3, vehicleVO.getEngineInCC());
		pstmt.setFloat(4, vehicleVO.getFuelCapacity());
		pstmt.setFloat(5, vehicleVO.getMileage());
		pstmt.setFloat(6, vehicleVO.getPrice());
		pstmt.setFloat(7, vehicleVO.getRoadTax());

		pstmt.executeUpdate();

		ResultSet rs = pstmt.getGeneratedKeys();
		
		if (rs.next()) {
			vehicleVO_ID = rs.getInt(1);
		}
		
	}
	
	
}
