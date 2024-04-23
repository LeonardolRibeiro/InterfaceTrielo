package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dados.TipoVeiculos;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class TipoVeiculosDao extends BasicDao{

	public TipoVeiculosDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(TipoVeiculos tipoVeiculos) throws SQLException {

		String sql = "insert into gera_tipos_Veiculos (id_tipos_veiculos"
				+ ",descricao"
				+ ",numero_eixos"
				+ ",tamanho"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_tipo_vei')"
				+ ",?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,tipoVeiculos.getDescricao());
		stmt.setString(2,tipoVeiculos.getNumero_eixos());
		stmt.setString(3,tipoVeiculos.getTamanho());
		stmt.setString(4,tipoVeiculos.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(tipoVeiculos.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(TipoVeiculos tipoVeiculos) throws SQLException {

		String sql = "update gera_tipos_Veiculos set "
				+ "descricao=?"
				+ ",numero_eixos=?"
				+ ",tamanho=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_tipos_Veiculos = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,tipoVeiculos.getDescricao());
		stmt.setString(2,tipoVeiculos.getNumero_eixos());
		stmt.setString(3,tipoVeiculos.getTamanho());
		stmt.setString(4,tipoVeiculos.getAtualizador());
		stmt.setTimestamp(5,dateTimeToSql(tipoVeiculos.getD_h_atualizacao()));
		stmt.setLong(6,tipoVeiculos.getId_tipos_veiculos());
		stmt.execute();

		stmt.close();

	}

	public TipoVeiculos buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_tipos_veiculos"
				+ ",descricao"
				+ ",numero_eixos"
				+ ",tamanho"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_tipos_Veiculos"
				+ " WHERE id_tipos_veiculos = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		TipoVeiculos tipoVeiculos = null;
		if (rs.next()) {
			tipoVeiculos = popula(rs);
		}

		rs.close();
		stmt.close();

		return tipoVeiculos;
	}

	public TipoVeiculos popula(ResultSet rs) throws SQLException{
		TipoVeiculos tipoVeiculos = new TipoVeiculos();

		tipoVeiculos.setId_tipos_veiculos(rs.getLong("id_tipos_veiculos"));

		tipoVeiculos.setDescricao(rs.getString("descricao"));
		tipoVeiculos.setNumero_eixos(rs.getString("numero_eixos"));
		tipoVeiculos.setTamanho(rs.getString("tamanho"));
		tipoVeiculos.setAtualizador(rs.getString("atualizador"));
		tipoVeiculos.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		return tipoVeiculos;
		
	}

	public List<TipoVeiculos> lista() {
		try {
			List<TipoVeiculos> lista = new ArrayList<TipoVeiculos>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_tipos_Veiculos");

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
