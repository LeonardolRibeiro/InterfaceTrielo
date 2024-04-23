package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.AcessoUsuario;
import br.com.inteligate.depara.dados.Acionamentos2;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class Acionamentos2Dao extends BasicDao{

	public Acionamentos2Dao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Acionamentos2 acionamentos2) throws SQLException {

		String sql = "insert into gera_acionamentos2 (id"

		+ ",modelo"
		+ ",descricao"
		+ ",led1"
		+ ",led2"
		+ ",led3"
		+ ",led4"
		+ ",buzzer1"
		+ ",buzzer2"
		+ ",buzzer3"
		+ ",buzzer4"
		+ ",rele1"
		+ ",rele2"
		+ ",rele3"
		+ ",rele4"
		+ ",saida1"
		+ ",saida2"
		+ ",saida3"
		+ ",saida4"
		+ ",saida5"
		+ ",saida6"
		+ ",saida7"
		+ ",saida8"
		+ ",atualizador"
		+ ",d_h_atualizacao"

				+") values (nextval('seq_acionamentos2')"
				+ ",?,?,?, ?,?,? ,?,?,? ,?"
				+ ",?,?,?, ?,?,? ,?,?,? ,?"
				+ ",?,?,?, ?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,acionamentos2.getModelo());
		stmt.setString(2,acionamentos2.getDescricao());
		stmt.setInt(3,acionamentos2.getLed1());
		stmt.setInt(4,acionamentos2.getLed2());
		stmt.setInt(5,acionamentos2.getLed3());
		stmt.setInt(6,acionamentos2.getLed4());
		stmt.setInt(7,acionamentos2.getBuzzer1());
		stmt.setInt(8,acionamentos2.getBuzzer2());
		stmt.setInt(9,acionamentos2.getBuzzer3());
		stmt.setInt(10,acionamentos2.getBuzzer4());
		stmt.setInt(11,acionamentos2.getRele1());
		stmt.setInt(12,acionamentos2.getRele2());
		stmt.setInt(13,acionamentos2.getRele3());
		stmt.setInt(14,acionamentos2.getRele4());
		stmt.setInt(15,acionamentos2.getSaida1());
		stmt.setInt(16,acionamentos2.getSaida2());
		stmt.setInt(17,acionamentos2.getSaida3());
		stmt.setInt(18,acionamentos2.getSaida4());
		stmt.setInt(19,acionamentos2.getSaida5());
		stmt.setInt(20,acionamentos2.getSaida6());
		stmt.setInt(21,acionamentos2.getSaida7());
		stmt.setInt(22,acionamentos2.getSaida8());
		stmt.setString(23,acionamentos2.getAtualizador());
		stmt.setTimestamp(24,dateTimeToSql(acionamentos2.getD_h_atualizacao()));
		
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Acionamentos2 acionamentos2) throws SQLException {

		String sql = "update gera_acionamentos2 set "
				+ "modelo=?"
				+ ",descricao=?"
				+ ",led1=?"
				+ ",led2=?"
				+ ",led3=?"
				+ ",led4=?"
				+ ",buzzer1=?"
				+ ",buzzer2=?"
				+ ",buzzer3=?"
				+ ",buzzer4=?"
				+ ",rele1=?"
				+ ",rele2=?"
				+ ",rele3=?"
				+ ",rele4=?"
				+ ",saida1=?"
				+ ",saida2=?"
				+ ",saida3=?"
				+ ",saida4=?"
				+ ",saida5=?"
				+ ",saida6=?"
				+ ",saida7=?"
				+ ",saida8=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,acionamentos2.getModelo());
		stmt.setString(2,acionamentos2.getDescricao());
		stmt.setInt(3,acionamentos2.getLed1());
		stmt.setInt(4,acionamentos2.getLed2());
		stmt.setInt(5,acionamentos2.getLed3());
		stmt.setInt(6,acionamentos2.getLed4());
		stmt.setInt(7,acionamentos2.getBuzzer1());
		stmt.setInt(8,acionamentos2.getBuzzer2());
		stmt.setInt(9,acionamentos2.getBuzzer3());
		stmt.setInt(10,acionamentos2.getBuzzer4());
		stmt.setInt(11,acionamentos2.getRele1());
		stmt.setInt(12,acionamentos2.getRele2());
		stmt.setInt(13,acionamentos2.getRele3());
		stmt.setInt(14,acionamentos2.getRele4());
		stmt.setInt(15,acionamentos2.getSaida1());
		stmt.setInt(16,acionamentos2.getSaida2());
		stmt.setInt(17,acionamentos2.getSaida3());
		stmt.setInt(18,acionamentos2.getSaida4());
		stmt.setInt(19,acionamentos2.getSaida5());
		stmt.setInt(20,acionamentos2.getSaida6());
		stmt.setInt(21,acionamentos2.getSaida7());
		stmt.setInt(22,acionamentos2.getSaida8());
		stmt.setString(23,acionamentos2.getAtualizador());
		stmt.setTimestamp(24,dateTimeToSql(acionamentos2.getD_h_atualizacao()));
		stmt.setLong(25,acionamentos2.getId());
		stmt.execute();

		stmt.close();

	}
	
	public Acionamentos2 buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id"
				+ ",modelo"
				+ ",descricao"
				+ ",led1"
				+ ",led2"
				+ ",led3"
				+ ",led4"
				+ ",buzzer1"
				+ ",buzzer2"
				+ ",buzzer3"
				+ ",buzzer4"
				+ ",rele1"
				+ ",rele2"
				+ ",rele3"
				+ ",rele4"
				+ ",saida1"
				+ ",saida2"
				+ ",saida3"
				+ ",saida4"
				+ ",saida5"
				+ ",saida6"
				+ ",saida7"
				+ ",saida8"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_acionamentos2"
				+ " WHERE id = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Acionamentos2 acionamentos2 = null;
		if (rs.next()) {
			acionamentos2 = popula(rs);
		}

		rs.close();
		stmt.close();

		return acionamentos2;
	}
	
	public Acionamentos2 popula(ResultSet rs) throws SQLException{
		Acionamentos2 acionamentos2 = new Acionamentos2();

		acionamentos2.setId(rs.getLong("id"));
		
		acionamentos2.setModelo(rs.getString("modelo"));
		acionamentos2.setDescricao(rs.getString("descricao"));
		acionamentos2.setLed1(rs.getInt("led1"));
		acionamentos2.setLed2(rs.getInt("led2"));
		acionamentos2.setLed3(rs.getInt("led3"));
		acionamentos2.setLed4(rs.getInt("led4"));
		acionamentos2.setBuzzer1(rs.getInt("buzzer1"));
		acionamentos2.setBuzzer2(rs.getInt("buzzer2"));
		acionamentos2.setBuzzer3(rs.getInt("buzzer3"));
		acionamentos2.setBuzzer4(rs.getInt("buzzer4"));
		acionamentos2.setRele1(rs.getInt("rele1"));
		acionamentos2.setRele2(rs.getInt("rele2"));
		acionamentos2.setRele3(rs.getInt("rele3"));
		acionamentos2.setRele4(rs.getInt("rele4"));
		acionamentos2.setSaida1(rs.getInt("saida1"));
		acionamentos2.setSaida2(rs.getInt("saida2"));
		acionamentos2.setSaida3(rs.getInt("saida3"));
		acionamentos2.setSaida4(rs.getInt("saida4"));
		acionamentos2.setSaida5(rs.getInt("saida5"));
		acionamentos2.setSaida6(rs.getInt("saida6"));
		acionamentos2.setSaida7(rs.getInt("saida7"));
		acionamentos2.setSaida8(rs.getInt("saida8"));
		acionamentos2.setAtualizador(rs.getString("atualizador"));
		acionamentos2.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		
		return acionamentos2;
	}
	
	public List<Acionamentos2> lista() {
		try {
			List<Acionamentos2> lista = new ArrayList<Acionamentos2>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_acionamentos2");

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
