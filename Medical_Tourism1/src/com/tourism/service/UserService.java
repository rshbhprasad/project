package com.tourism.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

	void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	int saveUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
	void userPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void appointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException;
	void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException;

}
