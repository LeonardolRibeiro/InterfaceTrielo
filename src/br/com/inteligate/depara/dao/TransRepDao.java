package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.TransRep;
import br.com.inteligate.depara.dados.Transportadora;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class TransRepDao extends BasicDao{

	public TransRepDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(TransRep transRep) throws SQLException {

		String sql = "insert into gera_trans_rep (id_trans_rep"
				  + ",progresso"
				  + ",modelorep"
				  + ",data"
				  + ",cmd"
				  + ",parametros"
				  + ",id_ur" 
				  + ",ip"
				  + ",transmitido"
				  + ",resultado"
				  + ",atualizador"
				  + ",d_h_atualizacao" 
				
				


				+") values (nextval('seq_trans_rep')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1,transRep.getProgresso()); 
		stmt.setString(2,transRep.getModelorep());
		stmt.setTimestamp(3,dateTimeToSql(transRep.getData()));
		stmt.setInt(4,transRep.getCmd());
		stmt.setString(5,transRep.getParametros());
		stmt.setLong(6,transRep.getId_ur());
		stmt.setString(7,transRep.getIp());
		stmt.setString(8,transRep.getTransmitido());
		stmt.setString(9,transRep.getResultado());
		stmt.setString(10,transRep.getAtualizador());
		stmt.setTimestamp(11,dateTimeToSql(transRep.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(TransRep transRep) throws SQLException {

		String sql = "update gera_trans_rep set "
				  + "progresso=?"
				  + ",modelorep=?"
				  + ",data=?"
				  + ",cmd=?"
				  + ",parametros=?"
				  + ",id_ur=?" 
				  + ",ip=?"
				  + ",transmitido=?"
				  + ",resultado=?"
				  + ",atualizador=?"
				  + ",d_h_atualizacao=?" 
				  
				+ " WHERE id_trans_rep = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setInt(1,transRep.getProgresso()); 
		stmt.setString(2,transRep.getModelorep());
		stmt.setTimestamp(3,dateTimeToSql(transRep.getData()));
		stmt.setInt(4,transRep.getCmd());
		stmt.setString(5,transRep.getParametros());
		stmt.setLong(6,transRep.getId_ur());
		stmt.setString(7,transRep.getIp());
		stmt.setString(8,transRep.getTransmitido());
		stmt.setString(9,transRep.getResultado());
		stmt.setString(10,transRep.getAtualizador());
		stmt.setTimestamp(11,dateTimeToSql(transRep.getD_h_atualizacao()));

		stmt.setLong(12, transRep.getId_trans_rep());

		stmt.execute();

		stmt.close();

	}

	public TransRep buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				  + "id_trans_rep"
				  + ",progresso"
				  + ",modelorep"
				  + ",data"
				  + ",cmd"
				  + ",parametros"
				  + ",id_ur" 
				  + ",ip"
				  + ",transmitido"
				  + ",resultado"
				  + ",atualizador"
				  + ",d_h_atualizacao" 
				+ " FROM gera_trans_rep"
				+ " WHERE id_trans_rep = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		TransRep transRep = null;
		if (rs.next()) {
			transRep = popula(rs);
		}

		rs.close();
		stmt.close();

		return transRep;
	}

	public TransRep popula(ResultSet rs) throws SQLException{
		TransRep transRep = new TransRep();

		  
		transRep.setId_trans_rep(rs.getLong("id_trans_rep"));
		transRep.setProgresso(rs.getInt("progresso")); 
		transRep.setModelorep(rs.getString("modelorep"));
		transRep.setData(rs.getTimestamp("data"));
	
		transRep.setCmd(rs.getInt("cmd"));
		transRep.setParametros(rs.getString("parametros"));
		transRep.setId_ur(rs.getLong("id_ur"));

		transRep.setIp(rs.getString("ip"));
		transRep.setTransmitido(rs.getString("transmitido"));
		transRep.setResultado(rs.getString("resultado"));

		
		transRep.setAtualizador(rs.getString("atualizador"));
		transRep.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao")); 

		return transRep;
	}

	public List<TransRep> lista() {
		try {
			List<TransRep> lista = new ArrayList<TransRep>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_trans_rep");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				lista.add(popula(rs));
			}

			rs.close();
			stmt.close();

			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
