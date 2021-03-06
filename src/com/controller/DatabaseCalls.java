package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCalls {

	private final static String tableName = "JDBC_TEST";

	public static void initDatabase() {
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			System.out.println("Connected to database");
			testMethodBeforeProperImplementation(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		// add a student

	}

	public static void testMethodBeforeProperImplementation(Connection conn) throws SQLException {
		// Create a table
		String createString = "CREATE TABLE " + tableName + " ( " + "ID INTEGER NOT NULL, " + "NAME varchar(40) NOT NULL, "
				+ "STREET varchar(40) NOT NULL, " + "CITY varchar(20) NOT NULL, " + "STATE char(2) NOT NULL, " + "ZIP char(5), "
				+ "PRIMARY KEY (ID))";
		executeUpdate(conn, createString);
		System.out.println("Created a table");

		// Drop the table
		String dropString = "DROP TABLE " + tableName;
		executeUpdate(conn, dropString);
		System.out.println("Dropped the table");
	}

	public static boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}
}