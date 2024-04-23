package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Motivacao;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class NiveisDao extends BasicDao{

	public NiveisDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(Niveis niveis) throws SQLException {

		String sql = "insert into gera_niveis (id_gera_niveis"
				+ ",codigo"
				+ ",descricao"
				+ ",toleranciaentrada"
				+ ",toleranciasaida"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",visivel_por_usuario"
				+ ",uso_local_visitante"
				+") values (nextval('seq_niveis')"
				+ ",?,?,?,?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,niveis.getCodigo());
		stmt.setString(2,niveis.getDescricao());
		stmt.setString(3,niveis.getToleranciaentrada());
		stmt.setString(4,niveis.getToleranciasaida());
		stmt.setString(5,niveis.getAtualizador());
		stmt.setTimestamp(6,dateTimeToSql(niveis.getD_h_atualizacao()));
		stmt.setBoolean(7,niveis.isVisivel_por_usuario());
		stmt.setBoolean(8,niveis.isUso_local_visitante());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Niveis niveis) throws SQLException {

		String sql = "update gera_niveis set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",toleranciaentrada=?"
				+ ",toleranciasaida=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",visivel_por_usuario=?"
				+ ",uso_local_visitante=?"
				+ " WHERE id_gera_niveis = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,niveis.getCodigo());
		stmt.setString(2,niveis.getDescricao());
		stmt.setString(3,niveis.getToleranciaentrada());
		stmt.setString(4,niveis.getToleranciasaida());
		stmt.setString(5,niveis.getAtualizador());
		stmt.setTimestamp(6,dateTimeToSql(niveis.getD_h_atualizacao()));
		stmt.setBoolean(7,niveis.isVisivel_por_usuario());
		stmt.setBoolean(8,niveis.isUso_local_visitante());
		stmt.setLong(9,niveis.getId_gera_niveis());

		stmt.execute();

		stmt.close();

	}

	public Niveis buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_gera_niveis"
				+ ",codigo"
				+ ",descricao"
				+ ",toleranciaentrada"
				+ ",toleranciasaida"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",visivel_por_usuario"
				+ ",uso_local_visitante"
				+ " FROM gera_niveis"
				+ " WHERE id_gera_niveis = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Niveis niveis = null;
		if (rs.next()) {
			niveis = popula(rs);
		}

		rs.close();
		stmt.close();

		return niveis;
	}

	public Niveis buscaPorCodigo(String codigo) throws SQLException{

		String sql = "SELECT "
				+ "id_gera_niveis"
				+ ",codigo"
				+ ",descricao"
				+ ",toleranciaentrada"
				+ ",toleranciasaida"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",visivel_por_usuario"
				+ ",uso_local_visitante"
				+ " FROM gera_niveis"
				+ " WHERE codigo = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1, codigo);

		ResultSet rs = stmt.executeQuery();
		Niveis niveis = null;
		if (rs.next()) {
			niveis = popula(rs);
		}

		rs.close();
		stmt.close();

		return niveis;
	}
	public Niveis popula(ResultSet rs) throws SQLException{
		Niveis niveis = new Niveis();
		
		niveis.setId_gera_niveis(rs.getLong("id_gera_niveis"));
		niveis.setCodigo(rs.getString("codigo"));
		niveis.setDescricao(rs.getString("descricao"));
		niveis.setToleranciaentrada(rs.getString("toleranciaentrada"));
		niveis.setToleranciasaida(rs.getString("toleranciasaida"));
		niveis.setAtualizador(rs.getString("atualizador"));
		niveis.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		niveis.setVisivel_por_usuario(rs.getBoolean("visivel_por_usuario"));
		niveis.setUso_local_visitante(rs.getBoolean("uso_local_visitante"));

		return niveis;
	}

	public List<Niveis> lista() {
		try {
			List<Niveis> lista = new ArrayList<Niveis>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_niveis");

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
