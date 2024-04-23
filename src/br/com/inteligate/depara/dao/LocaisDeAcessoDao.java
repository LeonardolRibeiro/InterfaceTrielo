package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.ListaNegra;
import br.com.inteligate.depara.dados.LocaisDeAcesso;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class LocaisDeAcessoDao extends BasicDao{

	public LocaisDeAcessoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(LocaisDeAcesso locaisDeAcesso) throws SQLException {

		String sql = "insert into aces_locaisdeacesso (id_local_acesso"
				+ ",codigo"
				+ ",descricao"
				+ ",nivel"
				+ ",id_niveis"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",id_site"
				+ ",local_de_visitante"
				+") values (nextval('seq_locaisDeAcesso')"
				+ ",?,?,?,?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,locaisDeAcesso.getCodigo());
		stmt.setString(2,locaisDeAcesso.getDescricao());
		stmt.setString(3,locaisDeAcesso.getNivel());
		stmt.setLong(4, locaisDeAcesso.getId_niveis());
		stmt.setString(5,locaisDeAcesso.getAtualizador());
		stmt.setTimestamp(6,dateTimeToSql(locaisDeAcesso.getD_h_atualizacao()));
		stmt.setLong(7, locaisDeAcesso.getId_site());
		stmt.setBoolean(8, locaisDeAcesso.isLocal_de_visitante());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(LocaisDeAcesso locaisDeAcesso) throws SQLException {

		String sql = "update aces_locaisdeacesso set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",nivel=?"
				+ ",id_niveis=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",id_site=?"
				+ ",local_de_visitante=?"
				+ " WHERE id_local_acesso = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,locaisDeAcesso.getCodigo());
		stmt.setString(2,locaisDeAcesso.getDescricao());
		stmt.setString(3,locaisDeAcesso.getNivel());
		stmt.setLong(4, locaisDeAcesso.getId_niveis());
		stmt.setString(5,locaisDeAcesso.getAtualizador());
		stmt.setTimestamp(6,dateTimeToSql(locaisDeAcesso.getD_h_atualizacao()));
		stmt.setLong(7, locaisDeAcesso.getId_site());
		stmt.setBoolean(8, locaisDeAcesso.isLocal_de_visitante());
		stmt.setLong(9,locaisDeAcesso.getId_local_acesso());
		stmt.execute();

		stmt.close();

	}

	public LocaisDeAcesso buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_local_acesso"
				+ ",codigo"
				+ ",descricao"
				+ ",nivel"
				+ ",id_niveis"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",id_site"
				+ ",local_de_visitante"
				+ " FROM aces_locaisdeacesso"
				+ " WHERE id_local_acesso = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		LocaisDeAcesso locaisDeAcesso = null;
		if (rs.next()) {
			locaisDeAcesso = popula(rs);
		}

		rs.close();
		stmt.close();

		return locaisDeAcesso;
	}

	public LocaisDeAcesso popula(ResultSet rs) throws SQLException{
		LocaisDeAcesso locaisDeAcesso = new LocaisDeAcesso();

		locaisDeAcesso.setId_local_acesso(rs.getLong("id_local_acesso"));
		locaisDeAcesso.setCodigo(rs.getString("codigo"));
		locaisDeAcesso.setDescricao(rs.getString("descricao"));
		locaisDeAcesso.setNivel(rs.getString("nivel"));
		locaisDeAcesso.setId_niveis(rs.getLong("id_niveis"));
		locaisDeAcesso.setAtualizador(rs.getString("atualizador"));
		locaisDeAcesso.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		locaisDeAcesso.setId_site(rs.getLong("id_site"));
		locaisDeAcesso.setLocal_de_visitante(rs.getBoolean("local_de_visitante"));
		return locaisDeAcesso;
		
	}

	public List<LocaisDeAcesso> lista() {
		try {
			List<LocaisDeAcesso> lista = new ArrayList<LocaisDeAcesso>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_locaisdeacesso");

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
