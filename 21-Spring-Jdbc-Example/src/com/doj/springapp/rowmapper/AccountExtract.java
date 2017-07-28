package com.doj.springapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.doj.springapp.model.Account;

public class AccountExtract implements ResultSetExtractor<List<Account>> {

	@Override
	public List<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		return null;
	}

}
