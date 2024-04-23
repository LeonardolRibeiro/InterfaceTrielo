package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Acionamentos;
import br.com.inteligate.depara.dados.Autorizacao;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class AutorizacaoDao extends BasicDao{

	public AutorizacaoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Autorizacao autorizacao) throws SQLException {

		String sql = "insert into gera_autorizacao (id_autorizacao"
				+ ",matricula" 
				+ ",dt_autorizacao" 
				+ ",mat_solicitante" 
				+ ",nr_hor_aut" 
				+ ",usa_interj" 
				+ ",usa_dsr"
				+ ",aea" 
				+ ",asp" 
				+ ",tp_refe_adic" 
				+ ",faixa_semjornada" 
				+ ",nomeusu" 

				+") values (nextval('seq_autorizacao')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,autorizacao.getMatricula());
		stmt.setTimestamp(2,dateTimeToSql(autorizacao.getDt_autorizacao()));
		stmt.setString(3,autorizacao.getMat_solicitante());
		stmt.setInt(4,autorizacao.getNr_hor_aut());
		stmt.setBoolean(5,autorizacao.isUsa_interj());
		stmt.setBoolean(6,autorizacao.isUsa_dsr());
		stmt.setInt(7,autorizacao.getAea());
		stmt.setInt(8,autorizacao.getAsp());
		stmt.setInt(9,autorizacao.getTp_refe_adic());
		stmt.setString(10,autorizacao.getFaixa_semjornada());
		stmt.setString(11,autorizacao.getNomeusu());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Autorizacao autorizacao) throws SQLException {

		String sql = "update gera_autorizacao set "
				+ "matricula=?" 
				+ ",dt_autorizacao=?" 
				+ ",mat_solicitante=?" 
				+ ",nr_hor_aut=?" 
				+ ",usa_interj=?" 
				+ ",usa_dsr=?"
				+ ",aea=?" 
				+ ",asp=?" 
				+ ",tp_refe_adic=?" 
				+ ",faixa_semjornada=?" 
				+ ",nomeusu=?" 
				+ " WHERE id_autorizacao = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,autorizacao.getMatricula());
		stmt.setTimestamp(2,dateTimeToSql(autorizacao.getDt_autorizacao()));
		stmt.setString(3,autorizacao.getMat_solicitante());
		stmt.setInt(4,autorizacao.getNr_hor_aut());
		stmt.setBoolean(5,autorizacao.isUsa_interj());
		stmt.setBoolean(6,autorizacao.isUsa_dsr());
		stmt.setInt(7,autorizacao.getAea());
		stmt.setInt(8,autorizacao.getAsp());
		stmt.setInt(9,autorizacao.getTp_refe_adic());
		stmt.setString(10,autorizacao.getFaixa_semjornada());
		stmt.setString(11,autorizacao.getNomeusu());

		stmt.setLong(12,autorizacao.getId_autorizacao());

		stmt.execute();

		stmt.close();

	}
	
	public Autorizacao buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+" id_autorizacao"
				+ ",matricula" 
				+ ",dt_autorizacao" 
				+ ",mat_solicitante" 
				+ ",nr_hor_aut" 
				+ ",usa_interj" 
				+ ",usa_dsr"
				+ ",aea" 
				+ ",asp" 
				+ ",tp_refe_adic" 
				+ ",faixa_semjornada" 
				+ ",nomeusu" 
				+ " FROM gera_autorizacao"
				+ " WHERE id_autorizacao = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Autorizacao autorizacao = null;
		if (rs.next()) {
			autorizacao = popula(rs);
		}

		rs.close();
		stmt.close();

		return autorizacao;
	}
	
	public Autorizacao popula(ResultSet rs) throws SQLException{
		Autorizacao autorizacao = new Autorizacao();

		autorizacao.setId_autorizacao(rs.getLong("id_autorizacao"));
		autorizacao.setMatricula(rs.getString("matricula"));
		autorizacao.setDt_autorizacao(rs.getTimestamp("dt_autorizacao"));
		autorizacao.setMat_solicitante(rs.getString("mat_solicitante"));
		autorizacao.setNr_hor_aut(rs.getInt("nr_hor_aut"));
		autorizacao.setUsa_interj(rs.getBoolean("usa_interj"));
		autorizacao.setUsa_dsr(rs.getBoolean("usa_dsr"));
		autorizacao.setAea(rs.getInt("aea"));
		autorizacao.setAsp(rs.getInt("asp"));
		autorizacao.setTp_refe_adic(rs.getInt("tp_refe_adic"));
		autorizacao.setFaixa_semjornada(rs.getString("faixa_semjornada"));
		autorizacao.setNomeusu(rs.getString("nomeusu"));
		return autorizacao;
	}
	
	public List<Autorizacao> lista() {
		try {
			List<Autorizacao> lista = new ArrayList<Autorizacao>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_autorizacao");

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
