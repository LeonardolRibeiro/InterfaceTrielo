package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Acionamentos;
import br.com.inteligate.depara.dados.Acionamentos2;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class AcionamentosDao extends BasicDao{

	public AcionamentosDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Acionamentos acionamentos) throws SQLException {

		String sql = "insert into gera_acionamentos ("
				+ "id"
				+ ",tipo"
				+ ",cofre"
				+ ",usuario"
				+ ",sentido"
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
				+ ",id_display"
				+ ",id_mensagem"
				+") values ("
				+ "?,?,?, ?,?,?, ?,?,?, ?,"
				+ "?,?,?, ?,?,?, ?,?,?, ?,"
				+ "?,?,?, ?,?,?, ?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,acionamentos.getId());
		stmt.setString(2,acionamentos.getTipo());
		stmt.setString(3,acionamentos.getCofre());
		stmt.setString(4,acionamentos.getUsuario());
		stmt.setString(5,acionamentos.getSentido());
		stmt.setString(6,acionamentos.getLed1());
		stmt.setString(7,acionamentos.getLed2());
		stmt.setString(8,acionamentos.getLed3());
		stmt.setString(9,acionamentos.getLed4());
		stmt.setString(10,acionamentos.getBuzzer1());
		stmt.setString(11,acionamentos.getBuzzer2());
		stmt.setString(12,acionamentos.getBuzzer3());
		stmt.setString(13,acionamentos.getBuzzer4());
		stmt.setString(14,acionamentos.getRele1());
		stmt.setString(15,acionamentos.getRele2());
		stmt.setString(16,acionamentos.getRele3());
		stmt.setString(17,acionamentos.getRele4());
		stmt.setString(18,acionamentos.getSaida1());
		stmt.setString(19,acionamentos.getSaida2());
		stmt.setString(20,acionamentos.getSaida3());
		stmt.setString(21,acionamentos.getSaida4());
		stmt.setString(22,acionamentos.getSaida5());
		stmt.setString(23,acionamentos.getSaida6());
		stmt.setString(24,acionamentos.getSaida7());
		stmt.setString(25,acionamentos.getSaida8());
		stmt.setString(26,acionamentos.getId_display());
		stmt.setString(27,acionamentos.getId_mensagem());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Acionamentos acionamentos) throws SQLException {

		String sql = "update gera_acionamentos set "
				+ "id=?"
				+ ",tipo=?"
				+ ",cofre=?"
				+ ",usuario=?"
				+ ",sentido=?"
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
				+ ",id_display=?"
				+ ",id_mensagem=?"
				+ " WHERE id = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,acionamentos.getId());
		stmt.setString(2,acionamentos.getTipo());
		stmt.setString(3,acionamentos.getCofre());
		stmt.setString(4,acionamentos.getUsuario());
		stmt.setString(5,acionamentos.getSentido());
		stmt.setString(6,acionamentos.getLed1());
		stmt.setString(7,acionamentos.getLed2());
		stmt.setString(8,acionamentos.getLed3());
		stmt.setString(9,acionamentos.getLed4());
		stmt.setString(10,acionamentos.getBuzzer1());
		stmt.setString(11,acionamentos.getBuzzer2());
		stmt.setString(12,acionamentos.getBuzzer3());
		stmt.setString(13,acionamentos.getBuzzer4());
		stmt.setString(14,acionamentos.getRele1());
		stmt.setString(15,acionamentos.getRele2());
		stmt.setString(16,acionamentos.getRele3());
		stmt.setString(17,acionamentos.getRele4());
		stmt.setString(18,acionamentos.getSaida1());
		stmt.setString(19,acionamentos.getSaida2());
		stmt.setString(20,acionamentos.getSaida3());
		stmt.setString(21,acionamentos.getSaida4());
		stmt.setString(22,acionamentos.getSaida5());
		stmt.setString(23,acionamentos.getSaida6());
		stmt.setString(24,acionamentos.getSaida7());
		stmt.setString(25,acionamentos.getSaida8());
		stmt.setString(26,acionamentos.getId_display());
		stmt.setString(27,acionamentos.getId_mensagem());
		stmt.setString(28,acionamentos.getId());
		stmt.execute();

		stmt.close();

	}

	public Acionamentos buscaPorId(String id) throws SQLException{

		String sql = "SELECT "
				+ "id"
				+ ",tipo"
				+ ",cofre"
				+ ",usuario"
				+ ",sentido"
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
				+ ",id_display"
				+ ",id_mensagem"
				+ " FROM gera_acionamentos"
				+ " WHERE id = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1, id);

		ResultSet rs = stmt.executeQuery();
		Acionamentos acionamentos = null;
		if (rs.next()) {
			acionamentos = popula(rs);
		}

		rs.close();
		stmt.close();

		return acionamentos;
	}

	public Acionamentos popula(ResultSet rs) throws SQLException{
		Acionamentos acionamentos = new Acionamentos();

		acionamentos.setId(rs.getString("id"));
		acionamentos.setTipo(rs.getString("tipo"));
		acionamentos.setCofre(rs.getString("cofre"));
		acionamentos.setUsuario(rs.getString("usuario"));
		acionamentos.setSentido(rs.getString("sentido"));
		acionamentos.setLed1(rs.getString("led1"));
		acionamentos.setLed2(rs.getString("led2"));
		acionamentos.setLed3(rs.getString("led3"));
		acionamentos.setLed4(rs.getString("led4"));
		acionamentos.setBuzzer1(rs.getString("buzzer1"));
		acionamentos.setBuzzer2(rs.getString("buzzer2"));
		acionamentos.setBuzzer3(rs.getString("buzzer3"));
		acionamentos.setBuzzer4(rs.getString("buzzer4"));
		acionamentos.setRele1(rs.getString("rele1"));
		acionamentos.setRele2(rs.getString("rele2"));
		acionamentos.setRele3(rs.getString("rele3"));
		acionamentos.setRele4(rs.getString("rele4"));
		acionamentos.setSaida1(rs.getString("saida1"));
		acionamentos.setSaida2(rs.getString("saida2"));
		acionamentos.setSaida3(rs.getString("saida3"));
		acionamentos.setSaida4(rs.getString("saida4"));
		acionamentos.setSaida5(rs.getString("saida5"));
		acionamentos.setSaida6(rs.getString("saida6"));
		acionamentos.setSaida7(rs.getString("saida7"));
		acionamentos.setSaida8(rs.getString("saida8"));
		acionamentos.setId_display(rs.getString("id_display"));
		acionamentos.setId_mensagem(rs.getString("id_mensagem"));
		return acionamentos;
	}

	public List<Acionamentos> lista() {
		try {
			List<Acionamentos> lista = new ArrayList<Acionamentos>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_acionamentos");

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
