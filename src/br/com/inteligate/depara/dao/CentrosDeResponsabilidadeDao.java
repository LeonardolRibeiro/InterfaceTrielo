package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.CampoUsuario;
import br.com.inteligate.depara.dados.CentrosDeResponsabilidade;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class CentrosDeResponsabilidadeDao extends BasicDao{

	public CentrosDeResponsabilidadeDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(CentrosDeResponsabilidade centrosDeResponsabilidade) throws SQLException {
		
		String sql = "insert into gera_centrosderesponsabilidade (id_centrosderesponsabilidade"
				+ ",codigo"
				+ ",descricao"
				+ ",unidadespermitidas"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",nivel"
				+ ",id_usuario_responsavel"
				+") values (nextval('SEQ_CENTROSRESP')"
				+ ",?,?,?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,centrosDeResponsabilidade.getCodigo());
		stmt.setString(2,centrosDeResponsabilidade.getDescricao());
		stmt.setString(3,centrosDeResponsabilidade.getUnidadespermitidas());
		stmt.setString(4,centrosDeResponsabilidade.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(centrosDeResponsabilidade.getD_h_atualizacao()));
		stmt.setString(6,centrosDeResponsabilidade.getNivel());
		stmt.setLong(7, centrosDeResponsabilidade.getId_usuario_responsavel());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(CentrosDeResponsabilidade centrosDeResponsabilidade) throws SQLException {

		String sql = "update gera_centrosderesponsabilidade set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",unidadespermitidas=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",nivel=?"
				+ ",id_usuario_responsavel=?"
				+ " WHERE id_centrosderesponsabilidade = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,centrosDeResponsabilidade.getCodigo());
		stmt.setString(2,centrosDeResponsabilidade.getDescricao());
		stmt.setString(3,centrosDeResponsabilidade.getUnidadespermitidas());
		stmt.setString(4,centrosDeResponsabilidade.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(centrosDeResponsabilidade.getD_h_atualizacao()));
		stmt.setString(6,centrosDeResponsabilidade.getNivel());
		stmt.setLong(7, centrosDeResponsabilidade.getId_usuario_responsavel());
		stmt.setLong(8, centrosDeResponsabilidade.getId_centrosderesponsabilidade());
		stmt.execute();

		stmt.close();

	}

	public CentrosDeResponsabilidade buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_centrosderesponsabilidade"
				+ ",codigo"
				+ ",descricao"
				+ ",unidadespermitidas"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",nivel"
				+ ",id_usuario_responsavel"
				+ " FROM gera_centrosderesponsabilidade"
				+ " WHERE id_centrosderesponsabilidade = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		CentrosDeResponsabilidade centrosDeResponsabilidade = null;
		if (rs.next()) {
			centrosDeResponsabilidade = popula(rs);
		}

		rs.close();
		stmt.close();

		return centrosDeResponsabilidade;
	}

	public CentrosDeResponsabilidade popula(ResultSet rs) throws SQLException{
		CentrosDeResponsabilidade centrosDeResponsabilidade = new CentrosDeResponsabilidade();

		centrosDeResponsabilidade.setId_centrosderesponsabilidade(rs.getLong("id_centrosderesponsabilidade"));
		centrosDeResponsabilidade.setCodigo(rs.getString("codigo"));
		centrosDeResponsabilidade.setDescricao(rs.getString("descricao"));
		centrosDeResponsabilidade.setUnidadespermitidas(rs.getString("unidadespermitidas"));
		centrosDeResponsabilidade.setAtualizador(rs.getString("atualizador"));
		centrosDeResponsabilidade.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		centrosDeResponsabilidade.setNivel(rs.getString("nivel"));
		centrosDeResponsabilidade.setId_usuario_responsavel(rs.getLong("id_usuario_responsavel"));

		return centrosDeResponsabilidade;
		
	}

	public List<CentrosDeResponsabilidade> lista() {
		try {
			List<CentrosDeResponsabilidade> lista = new ArrayList<CentrosDeResponsabilidade>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_centrosderesponsabilidade");

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
