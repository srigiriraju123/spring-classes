/**
 * 
 */
package com.doj.springapp.repository;

/**
 * @author Dinesh.Rajput
 *
 */
public class AppDataSource {
	
	String dburl;
	String user;
	String password;
	String driver;
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public AppDataSource(String dburl, String user, String password, String driver) {
		super();
		this.dburl = dburl;
		this.user = user;
		this.password = password;
		this.driver = driver;
	}
	
	public AppDataSource() {
		super();
	}
	@Override
	public String toString() {
		return "AppDataSource [dburl=" + dburl + ", user=" + user + ", password=" + password + ", driver=" + driver
				+ "]";
	}
}
