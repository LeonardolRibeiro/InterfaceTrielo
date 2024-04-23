package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.TipoVeiculos;
import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class TransBe2Dao extends BasicDao{

	public TransBe2Dao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(TransBe2 transBe2) throws SQLException {

		String sql = "insert into gera_trans_be2 (serial"

				  + ",tipo" 
				  + ",data"
				  + ",cracha"
				  + ",transmitido"
				  + ",concentrador" 
				  + ",complemento" 
				  + ",atualizador" 
				  + ",d_h_atualizacao" 
				  + ",ocorrencia" 
				  + ",progresso"
				  + ",porta" 
				  + ",ip" 
				  + ",coletor" 

				+") values (nextval('seq_trans_be2')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,transBe2.getTipo());
		stmt.setTimestamp(2,dateTimeToSql(transBe2.getData()));
		stmt.setString(3,transBe2.getCracha());
		stmt.setString(4,transBe2.getTransmitido());
		stmt.setString(5,transBe2.getConcentrador());
		stmt.setString(6,transBe2.getComplemento());
		stmt.setString(7,transBe2.getAtualizador());
		stmt.setTimestamp(8,dateTimeToSql(transBe2.getD_h_atualizacao()));
		Utils.setParam(stmt, 9,transBe2.getOcorrencia()); 
		Utils.setParam(stmt, 10,transBe2.getProgresso()); 
		stmt.setString(11,transBe2.getPorta());
		stmt.setString(12,transBe2.getIp());
		stmt.setString(13,transBe2.getColetor());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public long adiciona2(TransBe2 transBe2) throws SQLException {

		String sql = "insert into gera_trans_be2 (serial"

				  + ",tipo" 
				  + ",data"
				  + ",cracha"
				  + ",transmitido"
				  + ",concentrador" 
				  + ",complemento" 
				  + ",atualizador" 
				  + ",d_h_atualizacao" 
				  + ",ocorrencia" 
				  + ",progresso"
				  + ",porta" 
				  + ",ip" 
				  + ",coletor" 

				+") values (nextval('seq_trans_be2')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,transBe2.getTipo());
		stmt.setTimestamp(2,dateTimeToSql(transBe2.getData()));
		stmt.setString(3,transBe2.getCracha());
		stmt.setString(4,transBe2.getTransmitido());
		stmt.setString(5,transBe2.getConcentrador());
		stmt.setString(6,transBe2.getComplemento());
		stmt.setString(7,transBe2.getAtualizador());
		stmt.setTimestamp(8,dateTimeToSql(transBe2.getD_h_atualizacao()));
		stmt.setInt(9,transBe2.getOcorrencia()); 
		stmt.setInt(10,transBe2.getProgresso()); 
		stmt.setString(11,transBe2.getPorta());
		stmt.setString(12,transBe2.getIp());
		stmt.setString(13,transBe2.getColetor());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	public void altera(TransBe2 transBe2) throws SQLException {

		String sql = "update gera_trans_be2 set "
				+ "tipo=?" 
				+ ",data=?"
				+ ",cracha=?"
				+ ",transmitido=?"
				+ ",concentrador=?" 
				+ ",complemento=?" 
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?" 
				+ ",ocorrencia=?" 
				+ ",progresso=?"
				+ ",porta=?" 
				+ ",ip=?" 
				+ ",coletor=?" 

				+ " WHERE serial = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,transBe2.getTipo());
		stmt.setTimestamp(2,dateTimeToSql(transBe2.getData()));
		stmt.setString(3,transBe2.getCracha());
		stmt.setString(4,transBe2.getTransmitido());
		stmt.setString(5,transBe2.getConcentrador());
		stmt.setString(6,transBe2.getComplemento());
		stmt.setString(7,transBe2.getAtualizador());
		stmt.setTimestamp(8,dateTimeToSql(transBe2.getD_h_atualizacao()));
		stmt.setInt(9,transBe2.getOcorrencia()); 
		stmt.setInt(10,transBe2.getProgresso()); 
		stmt.setString(11,transBe2.getPorta());
		stmt.setString(12,transBe2.getIp());
		stmt.setString(13,transBe2.getColetor());
		stmt.setLong(14, transBe2.getSerial());

		stmt.execute();

		stmt.close();

	}

	public TransBe2 buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "serial"
				+ ",tipo" 
				+ ",data"
				+ ",cracha"
				+ ",transmitido"
				+ ",concentrador" 
				+ ",complemento" 
				+ ",atualizador" 
				+ ",d_h_atualizacao" 
				+ ",ocorrencia" 
				+ ",progresso"
				+ ",porta" 
				+ ",ip" 
				+ ",coletor" 
				+ " FROM gera_trans_be2"
				+ " WHERE serial = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		TransBe2 transBe2 = null;
		if (rs.next()) {
			transBe2 = popula(rs);
		}

		rs.close();
		stmt.close();

		return transBe2;
	}

	public TransBe2 popula(ResultSet rs) throws SQLException{
		TransBe2 transBe2 = new TransBe2();

		transBe2.setSerial(rs.getLong("serial"));
		transBe2.setTipo(rs.getString("tipo")); 
		transBe2.setData(rs.getTimestamp("data"));
		transBe2.setCracha(rs.getString("cracha"));
		transBe2.setTransmitido(rs.getString("transmitido"));
		transBe2.setConcentrador(rs.getString("concentrador"));
		transBe2.setComplemento(rs.getString("complemento"));
		transBe2.setAtualizador(rs.getString("atualizador"));
		transBe2.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao")); 
		transBe2.setOcorrencia(rs.getInt("ocorrencia"));
		transBe2.setProgresso(rs.getInt("progresso"));
		transBe2.setPorta(rs.getString("porta"));
		transBe2.setIp(rs.getString("ip" ));
		transBe2.setColetor(rs.getString("coletor" ));


		return transBe2;
	}

	public List<TransBe2> lista() {
		try {
			List<TransBe2> lista = new ArrayList<TransBe2>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_trans_be2");

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
