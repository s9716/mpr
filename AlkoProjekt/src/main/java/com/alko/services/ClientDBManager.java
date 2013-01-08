package com.alko.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.alko.project.Client;

public class ClientDBManager {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addClientStmt;
	private PreparedStatement getClientStmt;
	private PreparedStatement findClientStmt;
	public PreparedStatement deleteClientStmt;

	public ClientDBManager() {

		Properties props = new Properties();

		try {
			props.load(ClassLoader
					.getSystemResourceAsStream("com/sklep/jdbc.properties"));

			conn = DriverManager.getConnection(props.getProperty("url"), props);
			boolean clientTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			stmt = conn.createStatement();

			while (rs.next()) {
				if ("Client".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					clientTableExists = true;
					break;
				}

			}
			if (!clientTableExists) {

				
			}

		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	
}
