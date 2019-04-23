package com.tourism.dao;

import java.sql.SQLException;

import com.tourism.model.Doctor;

public interface DoctorDAO {

	int save(Doctor doctor) throws SQLException;

}
