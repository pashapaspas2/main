package by.bsu.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;
import java.util.LinkedList;

import com.mysql.jdbc.Driver;

public class DBConnectionPool {
	private static DBConnectionPool instance;
	private String URL;
	private String user;
	private String password;
	private String driverName;

	private Deque<Connection> deque;

	private DBConnectionPool() {
		try {
			URL = "jdbc:mysql://localhost:3307/mydb2";
			user = "root";
			password = "pass";
			driverName = "com.mysql.jdbc.Driver";

			Driver driver;

			driver = (Driver) Class.forName(driverName).newInstance();
			DriverManager.registerDriver(driver);

			deque = new LinkedList<Connection>();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static DBConnectionPool getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new DBConnectionPool();
		}
	}

	public synchronized Connection getConnection() throws SQLException {
		if (!deque.isEmpty()) {
			while (!deque.isEmpty()) {
				Connection connection = deque.poll();
				if (connection.isValid(500)) {
					return connection;
				}
				return DriverManager.getConnection(URL, user, password);
			}
		}
		return DriverManager.getConnection(URL, user, password);
	}

	public synchronized void freeConnection(Connection connection) {
		try {
			if (!connection.isClosed()) {
				deque.add(connection);
			}
		} catch (SQLException e) {
			return;
		}
	}
}
