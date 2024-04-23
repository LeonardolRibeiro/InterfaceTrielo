package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.RequisitosEspeciais;
import br.com.inteligate.depara.dados.Restricao;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class RestricaoDao extends BasicDao{

	public RestricaoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(Restricao restricao) throws SQLException {

		
		String sql = "insert into gera_restricao (id_restricao"
				+ ",id_campo"
				+ ",operador"
				+ ",valor"
				+ ",ocorrencia"
				+ ",mensagem_display"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_restricao')"
				+ ",?,?,?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,restricao.getId_campo());
		stmt.setInt(2,restricao.getOperador());
		stmt.setString(3,restricao.getValor());
		stmt.setInt(4,restricao.getOcorrencia());
		stmt.setString(5,restricao.getMensagem_display());
		stmt.setString(6,restricao.getAtualizador());
		stmt.setTimestamp(7,dateTimeToSql(restricao.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Restricao restricao) throws SQLException {

		String sql = "update gera_restricao set "
				+ "id_campo=?"
				+ ",operador=?"
				+ ",valor=?"
				+ ",ocorrencia=?"
				+ ",mensagem_display=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_restricao = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setLong(1,restricao.getId_campo());
		stmt.setInt(2,restricao.getOperador());
		stmt.setString(3,restricao.getValor());
		stmt.setInt(4,restricao.getOcorrencia());
		stmt.setString(5,restricao.getMensagem_display());
		stmt.setString(6,restricao.getAtualizador());
		stmt.setTimestamp(7,dateTimeToSql(restricao.getD_h_atualizacao()));
		stmt.setLong(8,restricao.getId_restricao());
		stmt.execute();

		stmt.close();

	}

	public Restricao buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_restricao"
				+ ",id_campo"
				+ ",operador"
				+ ",valor"
				+ ",ocorrencia"
				+ ",mensagem_display"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_restricao"
				+ " WHERE id_restricao = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Restricao restricao = null;
		if (rs.next()) {
			restricao = popula(rs);
		}

		rs.close();
		stmt.close();

		return restricao;
	}

	public Restricao popula(ResultSet rs) throws SQLException{
		Restricao restricao = new Restricao();
		
		restricao.setId_restricao(rs.getLong("id_restricao"));
		restricao.setId_campo(rs.getLong("id_campo"));
		restricao.setOperador(rs.getInt("operador"));
		restricao.setValor(rs.getString("valor"));
		restricao.setOcorrencia(rs.getInt("ocorrencia"));
		restricao.setMensagem_display(rs.getString("mensagem_display"));
		
		restricao.setAtualizador(rs.getString("atualizador"));
		restricao.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		
		return restricao;
	}

	public List<Restricao> lista() {
		try {
			List<Restricao> lista = new ArrayList<Restricao>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_restricao");

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
