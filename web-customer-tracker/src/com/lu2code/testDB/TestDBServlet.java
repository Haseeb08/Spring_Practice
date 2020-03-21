package com.lu2code.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//setup connection vars
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user="springstudent";
		String pass="springStudent@123";
		
		String driver = "com.mysql.jdbc.Driver";
		
		//get connecrion to db
	try {
		
		PrintWriter out = response.getWriter();
		
		Class.forName(driver);
		Connection myCon=DriverManager.getConnection(jdbcUrl, user, pass);
		out.print("Success..");
		myCon.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
