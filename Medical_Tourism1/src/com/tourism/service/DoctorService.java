package com.tourism.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DoctorService {

	void addDoctor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;

}
