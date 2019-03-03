package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Student3 {
	 static ResultSet resultSet = null;
	 static Statement statement = null;
	 static Connection conn = null;
	 static PreparedStatement pstat = null;
	   
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
	//now save the data into database
	private static void saveData(int id, String name, int marks){
	   	
	   	String query ="INSERT INTO student483 VALUES(?,?,?)";
	   	try{
	   	    conn = connect();
	        pstat = conn.prepareStatement(query);
	        pstat.setInt(1,id);
	        pstat.setString(2,name);
	        pstat.setInt(3,marks);
	        pstat.executeUpdate();
        }catch (SQLException e){
	         System.out.println(e);
	     }
	 }
	//now save the data into database
	   private static  void readData() throws Exception,SQLException{
	   	
	   	String query ="SELECT * FROM student483";
	   try {

	     conn = connect();
	statement = conn.createStatement();
	resultSet = statement.executeQuery(query);

	ResultSetMetaData metaData = resultSet.getMetaData();
	       //count number of column
	        int columnCount = metaData.getColumnCount();
	       // System.out.println(columnCount);
	        
	        //display column levels or header
	        for (int i = 1; i<=columnCount; i++)
	       	// { System.out.print(metaData.getColumnLabel(i)+"\t\t");}

	//display whole table
	 while (resultSet.next()) {
	System.out.println(resultSet.getInt(1)+"\t"+ resultSet.getString(2)+"\t"+resultSet.getInt(3));
	 }                              
	      
	       }
	       catch(SQLException e){
	           System.out.println(e);
	       }

	        }
     public static void main(String args[]) throws SQLException, Exception {
		connect();
		System.out.println("Database is connected, Congratulation!!!");
		
		saveData(3743, "Tofael", 70);
		System.out.println("Query executed");
		readData();
		}
	}



