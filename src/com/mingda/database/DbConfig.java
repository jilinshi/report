package com.mingda.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class DbConfig {
	// 数据库及server配置文件路径
	private static final String ACTIONPATH = "config.properties";
	private static DbConfig instance = null;

	private String cs_db_username = null;
	private String cs_db_password = null;
	private String cs_db_name = null;
	private String cs_ip = null;

	private String nc_db_username = null;
	private String nc_db_password = null;
	private String nc_db_name = null;
	private String nc_ip = null;

	private DbConfig() {
	}

	public static DbConfig getInstance() {
		if (instance == null) {
			instance = new DbConfig().getNewDbConfig();
		}
		return instance;
	}

	private DbConfig getNewDbConfig() {

		DbConfig dc = new DbConfig();
		Properties prop = new Properties();
		String path = null;
		FileInputStream fis = null;

		try {
			path = DbConfig.class.getClassLoader().getResource("").toURI()
					.getPath();
			System.out.println(path);
			fis = new FileInputStream(new File(path + ACTIONPATH));
			prop.load(fis);
			dc.cs_db_username = prop.getProperty("cs_db_username");
			dc.cs_db_password = prop.getProperty("cs_db_password");
			dc.cs_db_name = prop.getProperty("cs_db_name");
			dc.cs_ip = prop.getProperty("cs_ip");
			dc.nc_db_username = prop.getProperty("nc_db_username");
			dc.nc_db_password = prop.getProperty("nc_db_password");
			dc.nc_db_name = prop.getProperty("nc_db_name");
			dc.nc_ip = prop.getProperty("nc_ip");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dc;
	}

	public String getCs_db_username() {
		return cs_db_username;
	}

	public void setCs_db_username(String cs_db_username) {
		this.cs_db_username = cs_db_username;
	}

	public String getCs_db_password() {
		return cs_db_password;
	}

	public void setCs_db_password(String cs_db_password) {
		this.cs_db_password = cs_db_password;
	}

	public String getCs_db_name() {
		return cs_db_name;
	}

	public void setCs_db_name(String cs_db_name) {
		this.cs_db_name = cs_db_name;
	}

	public String getCs_ip() {
		return cs_ip;
	}

	public void setCs_ip(String cs_ip) {
		this.cs_ip = cs_ip;
	}

	public String getNc_db_username() {
		return nc_db_username;
	}

	public void setNc_db_username(String nc_db_username) {
		this.nc_db_username = nc_db_username;
	}

	public String getNc_db_password() {
		return nc_db_password;
	}

	public void setNc_db_password(String nc_db_password) {
		this.nc_db_password = nc_db_password;
	}

	public String getNc_db_name() {
		return nc_db_name;
	}

	public void setNc_db_name(String nc_db_name) {
		this.nc_db_name = nc_db_name;
	}

	public String getNc_ip() {
		return nc_ip;
	}

	public void setNc_ip(String nc_ip) {
		this.nc_ip = nc_ip;
	}

}
