/**
 * 
 */
package com.doj.springapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * @author Dinesh.Rajput
 *
 */
public class AccountCallBackHandler implements RowCallbackHandler {

	@Override
	public void processRow(ResultSet resultSet) throws SQLException {
		//Write flat file
		//Send mail
		//Analyse data and dump it 
	}

}
