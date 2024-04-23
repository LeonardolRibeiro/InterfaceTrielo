package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Estacionamento;
import br.com.inteligate.depara.dados.FaixaDeAcesso;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class FaixaDeAcessoDao extends BasicDao{

	public FaixaDeAcessoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(FaixaDeAcesso faixaDeAcesso) throws SQLException {

		String sql = "insert into gera_faixasdeacessos (id_faixadeacesso"
				+ ",faixa"
				+ ",horainicio"
				+ ",horafim"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_faixasdeacessos')"
				+ ",?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,faixaDeAcesso.getFaixa());
		stmt.setTimestamp(2,dateTimeToSql(faixaDeAcesso.getHorainicio()));
		stmt.setTimestamp(3,dateTimeToSql(faixaDeAcesso.getHorafim()));
		stmt.setString(4,faixaDeAcesso.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(faixaDeAcesso.getD_h_atualizacao()));
		
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(FaixaDeAcesso faixaDeAcesso) throws SQLException {

		String sql = "update gera_faixasDeAcessos set "
				+ "faixa=?"
				+ ",horainicio=?"
				+ ",horafim=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_faixadeacesso = ?";


		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,faixaDeAcesso.getFaixa());
		stmt.setTimestamp(2,dateTimeToSql(faixaDeAcesso.getHorainicio()));
		stmt.setTimestamp(3,dateTimeToSql(faixaDeAcesso.getHorafim()));
		stmt.setString(4,faixaDeAcesso.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(faixaDeAcesso.getD_h_atualizacao()));
		stmt.setLong(6,faixaDeAcesso.getId_faixadeacesso());

		stmt.execute();

		stmt.close();

	}

	public FaixaDeAcesso buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_faixadeacesso"
				+ ",faixa"
				+ ",horainicio"
				+ ",horafim"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_faixasDeAcessos"
				+ " WHERE id_faixadeacesso = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		FaixaDeAcesso faixaDeAcesso = null;
		if (rs.next()) {
			faixaDeAcesso = popula(rs);
		}

		rs.close();
		stmt.close();

		return faixaDeAcesso;
	}

	public FaixaDeAcesso popula(ResultSet rs) throws SQLException{
		FaixaDeAcesso faixaDeAcesso = new FaixaDeAcesso();
		
		faixaDeAcesso.setId_faixadeacesso(rs.getLong("id_faixadeacesso"));
		faixaDeAcesso.setFaixa(rs.getString("faixa"));
		faixaDeAcesso.setHorainicio(rs.getTimestamp("horainicio"));
		faixaDeAcesso.setHorafim(rs.getTimestamp("horafim"));
		faixaDeAcesso.setAtualizador(rs.getString("atualizador"));
		faixaDeAcesso.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return faixaDeAcesso;
	}

	public List<FaixaDeAcesso> lista() {
		try {
			List<FaixaDeAcesso> lista = new ArrayList<FaixaDeAcesso>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_faixasdeacessos");

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
