package com.infinira.studentapp.util;

import java.sql.*;
import java.util.Properties;

public class DbConnection{

   public static Connection getConnection(){
       Connection conn = null;
       try 
       {
            Properties props = PropertyReader.getProperty("db");
            // Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(props.getProperty("url"),props);
            System.out.println("Connection Establish.!");

	    } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
   }
	
   public static void main(String[] args){
		getConnection();
	}

}   