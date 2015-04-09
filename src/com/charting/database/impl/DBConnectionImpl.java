package com.charting.database.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.charting.database.DBConnection;
import com.charting.exception.DBException;

public class DBConnectionImpl implements DBConnection {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DB_URL;

	// Database credentials
	private String USER;
	private String PASS;

	private Connection conn;

	private DBConnectionImpl() {
	}

	private static final DBConnectionImpl instanceOf = new DBConnectionImpl();

	public static DBConnectionImpl getInstanceof() {
		return instanceOf;
	}

	public void initializeDB(String databaseUrl, String username,
			String password) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new DBException(e.getMessage());
		}
		DB_URL = "jdbc:mysql://" + databaseUrl;
		USER = username;
		PASS = password;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	@Override
	public Object[] getResult(String query, String[] columnNames) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		ResultSet rs;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

		Object[] result = new Object[columnNames.length];
		try {
			rs.absolute(1);
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		try {
			int i = 0;
			for (String col : columnNames) {
				result[i] = rs.getObject(col);
				i++;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

		return result;
	}

	@Override
	public List<Object[]> getResults(String query, String[] columnNames) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		ResultSet rs;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

		ArrayList<Object[]> result = new ArrayList<>();

		try {
			while (rs.next()) {
				Object[] row = new Object[columnNames.length];
				int i = 0;
				for (String col : columnNames) {
					row[i] = rs.getObject(col);
					i++;
				}
				result.add(row);
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

		return result;
	}

}
