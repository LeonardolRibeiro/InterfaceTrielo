package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Utils {

	public Utils() {

	}
	public static void setParam(PreparedStatement stmt, int paramIndex, Long value) throws SQLException {
		if (value == null || value == 0) {
			stmt.setNull(paramIndex, Types.BIGINT);
		} else {
			stmt.setLong(paramIndex, value);
		}
	}
	
	public static void setParam(PreparedStatement stmt, int paramIndex, Integer value) throws SQLException {
		if (value == null || value == 0) {
			stmt.setNull(paramIndex, Types.BIGINT);
		} else {
			stmt.setLong(paramIndex, value);
		}
	}
	
	public static void setParam(PreparedStatement stmt, int paramIndex, Double value) throws SQLException {
		if (value == null || value == 0) {
			stmt.setNull(paramIndex, Types.BIGINT);
		} else {
			stmt.setDouble(paramIndex, value);
		}
	}
	
}
