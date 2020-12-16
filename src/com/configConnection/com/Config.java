package com.configConnection.com;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Config {
private String userName;
private String password;
private String host;
	public Config() {
		// TODO Auto-generated constructor stub
	}
	public Config(String host, String UserName,String password) {
		this.host=host;
		this.userName=UserName;
		this.password=password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Connection CoonectionLoad() throws Exception {
		
		Connection connect= (Connection) DriverManager.getConnection(getHost(),getUserName(),getPassword());
		return connect;
	}

}
