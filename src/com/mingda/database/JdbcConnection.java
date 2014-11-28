package com.mingda.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	// 定义线程本地变量，每个线程访问它都会获得不同的对象
	// 使用ThreadLocal使一个连接绑定到一个线程上
	private static ThreadLocal<Connection> currentConnection = new ThreadLocal<Connection>();
	private static String username = null; // 用户名
	private static String password = null; // 密码
	private static String dbName = null; // 数据库名称
	private static String ip = null; // 数据库服务器IP地址
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
	 * @return 得到一个数据库连接
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
	 * 关闭Oracle数据库连接
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		Connection conn = currentConnection.get();
		conn.close();
		currentConnection.set(null);
	}

	// 获得Oracle数据库连接
	private static Connection getOracleConnection() {
		initParams(getDs());
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); // 加载驱动
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + ip
					+ ":1521:" + dbName, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Oracle驱动没找到");
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