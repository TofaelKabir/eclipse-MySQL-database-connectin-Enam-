package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Student1 {
	   
	private static Connection connect() {
		try{
		    Class.forName("com.mysql.jdbc.Driver");
		    return DriverManager.getConnection("jdbc:mysql://localhost:3306/pnt", "root", "tofael483");
		    // ClassNotFoundException is used in case of driver not found
		    }catch (SQLException | ClassNotFoundException e){
		    System.out.println(e);
		    //in case of connection failure
		    return null;
		    }
	}
	public static void main(String args[]) {
		connect();
		System.out.println("Database is connected, Congratulation!!!");
		}
	}



