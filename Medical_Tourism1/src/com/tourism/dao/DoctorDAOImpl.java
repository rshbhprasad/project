package com.tourism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tourism.model.Doctor;
import com.tourism.util.ConnectionManager;

public class DoctorDAOImpl implements DoctorDAO {
	
	private ConnectionManager connectionManager;
	private Connection connection;
	
	public DoctorDAOImpl(){
		connectionManager = new ConnectionManager();
	}

	@Override
	public int save(Doctor doctor) throws SQLException {
		String sql = "INSERT INTO DOCTOR (hospital_id, specialization, daysOfAvailability) VALUES"
				+" (?,?,?)";
		int save = 0;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, doctor.getHospitalID());
			stmt.setString(2, doctor.getSpecialization());
			stmt.setString(3, doctor.getAvailability());
			save=stmt.executeUpdate();
		}finally{
			connectionManager.disconnect();
		}
		return save;
	}

}
