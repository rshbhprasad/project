package com.tourism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.tourism.model.Appointment;
import com.tourism.model.Doctor;
import com.tourism.model.User;
import com.tourism.util.ConnectionManager;

public class UserDAOImpl implements UserDAO{
	
	private ConnectionManager connectionManager;
	private Connection connection;
	
	public UserDAOImpl(){
		connectionManager = new ConnectionManager();
	}

	@Override
	public int save(User user) throws SQLException {
		String sql = "INSERT INTO user (firstname, lastname, age, gender, contact, address, city, zip)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		int id = 0;
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setInt(3, user.getAge());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getContactNumber());
			stmt.setString(6, user.getAddress());
			stmt.setString(7, user.getCity());
			stmt.setInt(8, user.getZipCode());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while(rs.next()){
				id=rs.getInt(1);
			}
		}
		finally{
			connectionManager.disconnect();
		}
		return id;
	}

	@Override
	public List<Doctor> getDoctorList(String day) throws SQLException {
		List<Doctor> list = new ArrayList<Doctor>();
		String sql = "SELECT doctor_id, name, specialization ,daysOfAvailability FROM "
				+ "doctor NATURAL JOIN hospital WHERE daysOfAvailability=?";
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, day);
			ResultSet rs = stmt.executeQuery();
			int d_id;
			String name,sp,dayAvail;
			Doctor doctor;
			while(rs.next()){
				d_id = rs.getInt("doctor_id");
				name = rs.getString("name");
				sp = rs.getString("specialization");
				dayAvail = rs.getString("daysOfAvailability");
				doctor = new Doctor(d_id, name, dayAvail, sp);
				list.add(doctor);
			}
		}
		finally{
			connectionManager.disconnect();
		}
		return list;
	}

	@Override
	public int saveAppointment(Appointment appointment) throws SQLException {
		int save = 0;
		String sql = "INSERT into appointment (user_id, hospital_id, timeslot, DateOfAppointment) VALUES (?,?,?,?)";
		try{
			connection = connectionManager.connect();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, appointment.getUser_id());
			stmt.setInt(2, appointment.getHospital_id());
			stmt.setString(3, appointment.getTimeSlot());
			stmt.setString(4, appointment.getDateOfAppointment());
			save = stmt.executeUpdate();
		}
		finally{
			connectionManager.disconnect();
		}
		return save;
	}
}
