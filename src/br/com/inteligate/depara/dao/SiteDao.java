package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Restricao;
import br.com.inteligate.depara.dados.Site;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class SiteDao extends BasicDao{

	public SiteDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Site site) throws SQLException {

		String sql = "insert into site (idSite"
				+ ",nome_site"
				+ ",codigo"
				+ ",regra_refeicoes"
				+ ",qtdveiculos"
				+ ",d_h_atualizacao"
				+ ",localizacao"
				+") values (nextval('SEQ_SITES')"
				+ ",?,?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,site.getNome_site());
		stmt.setString(2,site.getCodigo());
		stmt.setBoolean(3,site.isRegra_refeicoes());
		stmt.setInt(4,site.getQtdveiculos());
		stmt.setTimestamp(5,dateTimeToSql(site.getD_h_atualizacao()));
		stmt.setString(6,site.getLocalizacao());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Site site) throws SQLException {

		String sql = "update site set "
				+ "nome_site=?"
				+ ",codigo=?"
				+ ",regra_refeicoes=?"
				+ ",qtdveiculos=?"
				+ ",d_h_atualizacao=?"
				+ ",localizacao=?"
				+ " WHERE idSite = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,site.getNome_site());
		stmt.setString(2,site.getCodigo());
		stmt.setBoolean(3,site.isRegra_refeicoes());
		stmt.setInt(4,site.getQtdveiculos());
		stmt.setTimestamp(5,dateTimeToSql(site.getD_h_atualizacao()));
		stmt.setString(6,site.getLocalizacao());
		stmt.setLong(7,site.getIdsite());

		stmt.execute();

		stmt.close();

	}
	
	public Site buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+" idsite"
				+ ",nome_site"
				+ ",codigo"
				+ ",regra_refeicoes"
				+ ",qtdveiculos"
				+ ",d_h_atualizacao"
				+ ",localizacao"
				+ " FROM site"
				+ " WHERE idsite = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Site site = null;
		if (rs.next()) {
			site = popula(rs);
		}

		rs.close();
		stmt.close();

		return site;
	}
	
	public Site popula(ResultSet rs) throws SQLException{
		Site site = new Site();

		site.setIdsite(rs.getLong("idsite"));
		site.setNome_site(rs.getString("nome_site"));
		site.setCodigo(rs.getString("codigo"));
		site.setRegra_refeicoes(rs.getBoolean("regra_refeicoes"));
		site.setQtdveiculos(rs.getInt("qtdveiculos"));
		site.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		site.setLocalizacao(rs.getString("localizacao"));
		
		return site;
	}

	public List<Site> lista() {
		try {
			List<Site> lista = new ArrayList<Site>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from site");

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
