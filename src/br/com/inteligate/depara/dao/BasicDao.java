package br.com.inteligate.depara.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BasicDao {
	protected Connection connection;
	
	public void finalize() {
		try {
			if(this.connection!=null) this.connection.close(); this.connection = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public java.sql.Date dateToSql(java.util.Date data){
		if(data!=null){
			return new java.sql.Date(data.getTime());
		}
		return null;
	}
		
	public Timestamp dateTimeToSql(java.util.Date data){
		if(data!=null){
			return new java.sql.Timestamp(data.getTime());
		}
		return null;
	}
}
