package com.mycompany.dave;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	
	 public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 public static final String DB_URL = "jdbc:mysql://mysql.chpc.utah.edu";
	 public static final String USER_NAME = "umlsro";
	 public static final String PASSWORD = "umls";
	 
	 public static void listDBs() throws Exception
	 {
		 
		 Class.forName(JDBC_DRIVER);
		 Connection  conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		
		 // see if a connection is established 
		 if(conn != null)
		 {
			 System.out.println("Connection established");
		 }
		 
		 // list all the databases in it:
		 DatabaseMetaData meta = conn.getMetaData();
	     ResultSet res = meta.getCatalogs();
	     System.out.println("List of databases: "); 
	     while (res.next()) 
	     {
	    	 System.out.println("   "+res.getString("TABLE_CAT"));
	     }	      
	     // close response
	      res.close();
	     // close connection
	     conn.close();
		 
	 }
	 
	 
	 
	 public static void listTables(String dbName) throws Exception
	 {
		  Class.forName(JDBC_DRIVER);
		  Connection conn = DriverManager.getConnection(DB_URL+dbName, USER_NAME, PASSWORD);
		 
		  DatabaseMetaData dbm = conn.getMetaData();
		  String[] types = {"TABLE"};
		  ResultSet res = dbm.getTables(null,null,"%",types);
		  System.out.println("Table name:");
		 
		  while (res.next())
		  {
			  String table = res.getString("TABLE_NAME");
			  System.out.println(table);
		  }
		  
		  res.close();
		  conn.close();
	 
	 }
	
	 
	 public static void testOne() throws Exception
	 {
		 Class.forName(JDBC_DRIVER);
		 Connection  conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		
		 // see if a connection is established 
		 if(conn != null)
		 {
			 System.out.println("Connection established");
		 }
		 
	
		 Statement stmt = conn.createStatement();
		 String sql = "SELECT * FROM umls.MRCONSO LIMIT 10;";
		 ResultSet res = stmt.executeQuery(sql);
		 
		 while(res.next())
		 {
			 System.out.println(res.getString(1));
		 }
		 
	     // close response
	      res.close();
	     // close connection
	     conn.close();
		 
	 }
	 
	 
	 
	 
	 
	 
}
