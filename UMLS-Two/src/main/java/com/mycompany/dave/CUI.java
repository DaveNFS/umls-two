package com.mycompany.dave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CUI implements QueryDB{
	
	 public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 public static final String DB_URL = "jdbc:mysql://mysql.chpc.utah.edu";
	 public static final String USER_NAME = "umlsro";
	 public static final String PASSWORD = "umls";
	
	 
	 public String retreiveDefinition(String cui) throws Exception 
	 {
		String output = null; 
		Class.forName(JDBC_DRIVER);
		Connection  conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT DEF FROM umls.MRDEF WHERE cui='" + cui + "';";
		ResultSet res = stmt.executeQuery(sql);
		
	   while(res.next())
		 {
			 output = res.getString("DEF");
		 }
		 
	    // close response
	    res.close();
	    // close connection
	    conn.close();

		
		return output; 
	 }
	
	 public List<String> retreiveSynonyms(String cui) throws Exception
	 {
		    ArrayList<String> output = new ArrayList<String>(); 
			Class.forName(JDBC_DRIVER);
			Connection  conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM umls.MRCONSO WHERE cui='" + cui + "';";
			ResultSet res = stmt.executeQuery(sql);
			
		   while(res.next())
			 {
				 output.add(res.getString("STR"));
			 }
			 
		    // close response
		    res.close();
		    // close connection
		    conn.close();

			
			return output;
		
	 }
	 
	 public List<String> retreiveSemanticType(String cui) throws Exception
	 {
	
		    ArrayList<String> output = new ArrayList<String>(); 
			Class.forName(JDBC_DRIVER);
			Connection  conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM umls.MRSTY WHERE cui='" + cui + "';";
			ResultSet res = stmt.executeQuery(sql);
			
		   while(res.next())
			 {
				 output.add(res.getString("STY"));
			 }
			 
		    // close response
		    res.close();
		    // close connection
		    conn.close();

			
			return output;
	 }
	 
	 
	 

}
