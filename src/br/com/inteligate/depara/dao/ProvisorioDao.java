package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.PrevioVisitantes;
import br.com.inteligate.depara.dados.Provisorio;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class ProvisorioDao extends BasicDao{

	public ProvisorioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(Provisorio provisorio) throws SQLException {

		String sql = "insert into aces_provisorios (id_aces_provisorios"
				+ ",matricula"
				+ ",crachaatual"
				+ ",crachaprovisorio"
				+ ",dataretirada"
				+ ",datadevolucao"
				+ ",observacoes"
				+ ",tipodevolucao"
				+ ",matprov"
				+ ",tipoprov"
				+ ",pa_ant"
				+ ",valido_ate"
				+ ",id_usuarios"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_provisorios')"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,provisorio.getMatricula());
		stmt.setString(2,provisorio.getCrachaatual());
		stmt.setString(3,provisorio.getCrachaprovisorio());
		stmt.setTimestamp(4,dateTimeToSql(provisorio.getDataretirada()));
		stmt.setTimestamp(5,dateTimeToSql(provisorio.getDatadevolucao()));
		stmt.setString(6,provisorio.getObservacoes());
		stmt.setString(7,provisorio.getTipodevolucao());
		stmt.setString(8,provisorio.getMatprov());
		stmt.setString(9,provisorio.getTipoprov());
		stmt.setString(10,provisorio.getPa_ant());
		stmt.setTimestamp(11,dateTimeToSql(provisorio.getValido_ate()));
		stmt.setLong(12,provisorio.getId_usuarios());

		stmt.setString(13,provisorio.getAtualizador());
		stmt.setTimestamp(14,dateTimeToSql(provisorio.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Provisorio provisorio) throws SQLException {

		String sql = "update aces_provisorios set "
				+ "matricula=?"
				+ ",crachaatual=?"
				+ ",crachaprovisorio=?"
				+ ",dataretirada=?"
				+ ",datadevolucao=?"
				+ ",observacoes=?"
				+ ",tipodevolucao=?"
				+ ",matprov=?"
				+ ",tipoprov=?"
				+ ",pa_ant=?"
				+ ",valido_ate=?"
				+ ",id_usuarios=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"

				+ " WHERE id_aces_provisorios = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,provisorio.getMatricula());
		stmt.setString(2,provisorio.getCrachaatual());
		stmt.setString(3,provisorio.getCrachaprovisorio());
		stmt.setTimestamp(4,dateTimeToSql(provisorio.getDataretirada()));
		stmt.setTimestamp(5,dateTimeToSql(provisorio.getDatadevolucao()));
		stmt.setString(6,provisorio.getObservacoes());
		stmt.setString(7,provisorio.getTipodevolucao());
		stmt.setString(8,provisorio.getMatprov());
		stmt.setString(9,provisorio.getTipoprov());
		stmt.setString(10,provisorio.getPa_ant());
		stmt.setTimestamp(11,dateTimeToSql(provisorio.getValido_ate()));
		stmt.setLong(12,provisorio.getId_usuarios());

		stmt.setString(13,provisorio.getAtualizador());
		stmt.setTimestamp(14,dateTimeToSql(provisorio.getD_h_atualizacao()));
		stmt.setLong(15,provisorio.getId_aces_provisorios());
		stmt.execute();

		stmt.close();

	}

	public Provisorio buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_aces_provisorios"
			  + ",matricula"
				+ ",crachaatual"
				+ ",crachaprovisorio"
				+ ",dataretirada"
				+ ",datadevolucao"
				+ ",observacoes"
				+ ",tipodevolucao"
				+ ",matprov"
				+ ",tipoprov"
				+ ",pa_ant"
				+ ",valido_ate"
				+ ",id_usuarios"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM aces_provisorios"
				+ " WHERE id_aces_provisorios = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Provisorio provisorio = null;
		if (rs.next()) {
			provisorio = popula(rs);
		}

		rs.close();
		stmt.close();

		return provisorio;
	}

	public Provisorio popula(ResultSet rs) throws SQLException{
		Provisorio provisorio = new Provisorio();
		provisorio.setId_aces_provisorios(rs.getLong("id_aces_provisorios"));
		
		provisorio.setMatricula(rs.getString("Matricula"));
		provisorio.setCrachaatual(rs.getString("crachaatual"));
		provisorio.setCrachaprovisorio(rs.getString("crachaprovisorio"));
		provisorio.setDataretirada(rs.getTimestamp("dataretirada"));
		provisorio.setDatadevolucao(rs.getTimestamp("datadevolucao"));
		provisorio.setObservacoes(rs.getString("observacoes"));
		provisorio.setTipodevolucao(rs.getString("tipodevolucao"));
		provisorio.setMatprov(rs.getString("matprov"));
		provisorio.setTipoprov(rs.getString("tipoprov"));
		provisorio.setPa_ant(rs.getString("pa_ant"));
		provisorio.setValido_ate(rs.getTimestamp("valido_ate"));
		provisorio.setId_usuarios(rs.getLong("id_usuarios"));
		
		provisorio.setAtualizador(rs.getString("atualizador"));
		provisorio.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return provisorio;
	}

	public List<Provisorio> lista() {
		try {
			List<Provisorio> lista = new ArrayList<Provisorio>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_provisorios");

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
