package com.javacode.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
  public Connection getConnection() {
	  Connection connection=null;
	  System.out.println("Connection calling");
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pdf","root","rabin12");
	  }
	  catch(ClassNotFoundException e) {
		  e.printStackTrace();
	  }
	  catch(SQLException e) {
		  e.printStackTrace();
	  }
	  return connection;
  }
}
