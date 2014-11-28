package com.mingda.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBProvider {
	// �������
	private static Connection ct = null;
	// ������������preparedstatement���statement
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// �������ݿ�Ĳ���
	private static String url = "";
	private static String username = "";
	private static String driver = "";
	private static String passwd = "";

	private static Properties pp = null;
	// private static FileInputStream fis = null;
	private static InputStream fis = null;
	// ����������ֻ��Ҫһ�Σ��þ�̬�����
	static {
		try {
			// ��dbinfo.properties
			pp = new Properties();
			// fis = new FileInputStream("dbinfo.properties");

			fis = DBProvider.class.getClassLoader().getResourceAsStream(
					"dbinfo.properties");
			pp.load(fis);
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			driver = pp.getProperty("driver");
			passwd = pp.getProperty("passwd");

			// 1.��������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fis = null;// ��������վ����ʰ
		}

	}

	// �õ�����
	public static Connection getConnection() {
		try
		// ��������
		{
			ct = DriverManager.getConnection(url, username, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	// �ر���Դ
	public static void close(ResultSet rs, Statement ps, Connection ct) {
		// �ر���Դ(�ȿ����)
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if (null != ct) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}
}
