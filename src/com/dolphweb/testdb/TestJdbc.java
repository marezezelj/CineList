package com.dolphweb.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJdbc
 */
@WebServlet("/TestJdbc")
public class TestJdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = "hbstudent";
		String pass = "hbstudent";
		String url = "jdbc:mysql://localhost:3306/hb-movies-tv?useSSL=false";
		
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting..." + url);
			
			Class.forName(driver);
			
			Connection myConn=DriverManager.getConnection(url, username, pass);
			
			out.println("Connected!");
			
			myConn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	
	}

}
