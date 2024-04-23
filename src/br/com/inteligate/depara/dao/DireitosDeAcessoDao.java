package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.CentrosDeResponsabilidade;
import br.com.inteligate.depara.dados.DireitosDeAcesso;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class DireitosDeAcessoDao extends BasicDao{

	public DireitosDeAcessoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(DireitosDeAcesso direitosDeAcesso) throws SQLException {

		String sql = "insert into gera_direitosDeAcesso ("
				+ "id_direitoacesso"
				+ ",id_unidaderemota"
				+ ",id_zonadetempo"
				+ ",id_nivel"
				+ ",nivel"
				+ ",coletor"
				+ ",leitora"
				+ ",zonadetempo"
				+ ",concentrador"
				+ ",id_concentrador"
				+ ",porta"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_direitosdeacesso')"
				+ ",?,?,?,?,?,?,?,?,?,? "
				+ ",?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setLong(1,direitosDeAcesso.getId_unidaderemota());
		stmt.setLong(2,direitosDeAcesso.getId_zonadetempo());
		stmt.setLong(3,direitosDeAcesso.getId_nivel());
		stmt.setString(4,direitosDeAcesso.getNivel());
		stmt.setString(5,direitosDeAcesso.getColetor());
		stmt.setString(6,direitosDeAcesso.getLeitora());
		stmt.setString(7,direitosDeAcesso.getZonadetempo());
		stmt.setString(8,direitosDeAcesso.getConcentrador());
		stmt.setLong( 9,direitosDeAcesso.getId_concentrador());
		stmt.setString(10,direitosDeAcesso.getPorta());

		stmt.setString(11,direitosDeAcesso.getAtualizador());
		stmt.setTimestamp(12,dateTimeToSql(direitosDeAcesso.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(DireitosDeAcesso direitosDeAcesso) throws SQLException {

		String sql = "update gera_direitosDeAcesso set "
				+ "id_unidaderemota=?"
				+ ",id_zonadetempo=?"
				+ ",id_nivel=?"
				+ ",nivel=?"
				+ ",coletor=?"
				+ ",leitora=?"
				+ ",zonadetempo=?"
				+ ",concentrador=?"
				+ ",id_concentrador=?"
				+ ",porta=?"
				+ ",atualizador=?"
				+ " WHERE id_direitoacesso = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setLong(1,direitosDeAcesso.getId_unidaderemota());
		stmt.setLong(2,direitosDeAcesso.getId_zonadetempo());
		stmt.setLong(3,direitosDeAcesso.getId_nivel());
		stmt.setString(4,direitosDeAcesso.getNivel());
		stmt.setString(5,direitosDeAcesso.getColetor());
		stmt.setString(6,direitosDeAcesso.getLeitora());
		stmt.setString(7,direitosDeAcesso.getZonadetempo());
		stmt.setString(8,direitosDeAcesso.getConcentrador());
		stmt.setLong( 9,direitosDeAcesso.getId_concentrador());
		stmt.setString(10,direitosDeAcesso.getPorta());

		stmt.setString(11,direitosDeAcesso.getAtualizador());
		stmt.setTimestamp(12,dateTimeToSql(direitosDeAcesso.getD_h_atualizacao()));
		stmt.execute();

		stmt.close();

	}

	public DireitosDeAcesso buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_direitoacesso"
				+ ",id_unidaderemota"
				+ ",id_zonadetempo"
				+ ",id_nivel"
				+ ",nivel"
				+ ",coletor"
				+ ",leitora"
				+ ",zonadetempo"
				+ ",concentrador"
				+ ",id_concentrador"
				+ ",porta"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_direitosDeAcesso"
				+ " WHERE id_direitoacesso = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		DireitosDeAcesso direitosDeAcesso = null;
		if (rs.next()) {
			direitosDeAcesso = popula(rs);
		}

		rs.close();
		stmt.close();

		return direitosDeAcesso;
	}

	public DireitosDeAcesso popula(ResultSet rs) throws SQLException{
		DireitosDeAcesso direitosDeAcesso = new DireitosDeAcesso();
		
		direitosDeAcesso.setId_direitoacesso(rs.getLong("id_direitoacesso"));
		direitosDeAcesso.setId_unidaderemota(rs.getLong("id_unidaderemota"));
		direitosDeAcesso.setId_zonadetempo(rs.getLong("id_zonadetempo"));
		direitosDeAcesso.setId_nivel(rs.getLong("id_nivel"));
		direitosDeAcesso.setNivel(rs.getString("nivel"));
		direitosDeAcesso.setColetor(rs.getString("coletor"));
		direitosDeAcesso.setLeitora(rs.getString("leitora"));
		direitosDeAcesso.setZonadetempo(rs.getString("zonadetempo"));
		direitosDeAcesso.setConcentrador(rs.getString("concentrador"));
		direitosDeAcesso.setId_concentrador(rs.getLong("id_concentrador"));
		direitosDeAcesso.setPorta(rs.getString("porta"));
		direitosDeAcesso.setAtualizador(rs.getString("atualizador"));
		direitosDeAcesso.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return direitosDeAcesso;
	}

	public List<DireitosDeAcesso> lista() {
		try {
			List<DireitosDeAcesso> lista = new ArrayList<DireitosDeAcesso>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_direitosDeAcesso");

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
