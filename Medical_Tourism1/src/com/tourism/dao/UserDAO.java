package com.tourism.dao;

import java.sql.SQLException;
import java.util.List;

import com.tourism.model.Appointment;
import com.tourism.model.Doctor;
import com.tourism.model.User;

public interface UserDAO {

	int save(User user) throws SQLException;

	List<Doctor> getDoctorList(String day) throws SQLException;

	int saveAppointment(Appointment appointment) throws SQLException;


}
