package com.mingda.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	// �����̱߳��ر�����ÿ���̷߳����������ò�ͬ�Ķ���
	// ʹ��ThreadLocalʹһ�����Ӱ󶨵�һ���߳���
	private static ThreadLocal<Connection> currentConnection = new ThreadLocal<Connection>();
	private static String username = null; // �û���
	private static String password = null; // ����
	private static String dbName = null; // ���ݿ�����
	private static String ip = null; // ���ݿ������IP��ַ
	private static String ds;

	public JdbcConnection(String ds) {
		JdbcConnection.setDs(ds);
	}

	private static void initParams(String ds) {
		if ("cs".equals(ds)) {
			username = DbConfig.getInstance().getCs_db_username();
			password = DbConfig.getInstance().getCs_db_password();
			dbName = DbConfig.getInstance().getCs_db_name();
			ip = DbConfig.getInstance().getCs_ip();
		}
		if ("nc".equals(ds)) {
			username = DbConfig.getInstance().getNc_db_username();
			password = DbConfig.getInstance().getNc_db_password();
			dbName = DbConfig.getInstance().getNc_db_name();
			ip = DbConfig.getInstance().getNc_ip();
		}
	}

	/**
	 * 
	 * @return �õ�һ�����ݿ�����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = currentConnection.get();
		if (conn == null) {
			conn = getOracleConnection();
			currentConnection.set(conn);
		}
		return conn;
	}

	/**
	 * �ر�Oracle���ݿ�����
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		Connection conn = currentConnection.get();
		conn.close();
		currentConnection.set(null);
	}

	// ���Oracle���ݿ�����
	private static Connection getOracleConnection() {
		initParams(getDs());
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); // ��������
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + ip
					+ ":1521:" + dbName, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Oracle����û�ҵ�");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static String getDs() {
		return ds;
	}

	public static void setDs(String ds) {
		JdbcConnection.ds = ds;
	}
}