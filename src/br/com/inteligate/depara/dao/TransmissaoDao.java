package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dados.Transmissao;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class TransmissaoDao extends BasicDao{

	public TransmissaoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Transmissao transmissao) throws SQLException {

		String sql = "insert into gera_transmissao (id_transmissao"
				+ ",tipo" 
				+ ",data" 
				+ ",cracha"
				+ ",transmitido" 
				+ ",concentrador" 
				+ ",nivel"
				+ ",matricula"
				+ ",unidades"
				+ ",grupo" 
				+ ",porta" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+") values (nextval('seq_transmissao')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,transmissao.getTipo());
		stmt.setTimestamp(2,dateTimeToSql(transmissao.getData()));
		stmt.setString(3,transmissao.getCracha());
		stmt.setString(4,transmissao.getTransmitido());
		stmt.setString(5,transmissao.getConcentrador());
		stmt.setString(6,transmissao.getNivel());
		stmt.setString(7,transmissao.getMatricula());
		stmt.setString(8,transmissao.getUnidades());
		stmt.setString(9,transmissao.getGrupo());
		stmt.setString(10,transmissao.getPorta());
		stmt.setString(11,transmissao.getAtualizador());
		stmt.setTimestamp(12,dateTimeToSql(transmissao.getD_h_atualizacao()));


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Transmissao transmissao) throws SQLException {

		String sql = "update gera_transmissao set "
				+ "tipo=?" 
				+ ",data=?" 
				+ ",cracha=?"
				+ ",transmitido=?" 
				+ ",concentrador=?" 
				+ ",nivel=?"
				+ ",matricula=?"
				+ ",unidades=?"
				+ ",grupo=?" 
				+ ",porta=?" 
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?"
				+ " WHERE id_transmissao = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,transmissao.getTipo());
		stmt.setTimestamp(2,dateTimeToSql(transmissao.getData()));
		stmt.setString(3,transmissao.getCracha());
		stmt.setString(4,transmissao.getTransmitido());
		stmt.setString(5,transmissao.getConcentrador());
		stmt.setString(6,transmissao.getNivel());
		stmt.setString(7,transmissao.getMatricula());
		stmt.setString(8,transmissao.getUnidades());
		stmt.setString(9,transmissao.getGrupo());
		stmt.setString(10,transmissao.getPorta());
		stmt.setString(11,transmissao.getAtualizador());
		stmt.setTimestamp(12,dateTimeToSql(transmissao.getD_h_atualizacao()));
		stmt.setLong(13, transmissao.getId_transmissao());

		stmt.execute();

		stmt.close();

	}

	public Transmissao buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_transmissao"
				+ ",tipo" 
				+ ",data" 
				+ ",cracha"
				+ ",transmitido" 
				+ ",concentrador" 
				+ ",nivel"
				+ ",matricula"
				+ ",unidades"
				+ ",grupo" 
				+ ",porta" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+ " FROM gera_transmissao"
				+ " WHERE id_transmissao = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Transmissao transmissao = null;
		if (rs.next()) {
			transmissao = popula(rs);
		}

		rs.close();
		stmt.close();

		return transmissao;
	}

	public Transmissao popula(ResultSet rs) throws SQLException{
		Transmissao transmissao = new Transmissao();

		transmissao.setId_transmissao(rs.getLong("id_transmissao"));
		transmissao.setTipo(rs.getString("tipo"));
		transmissao.setData(rs.getTimestamp("data"));
		transmissao.setCracha(rs.getString("cracha"));
		transmissao.setTransmitido(rs.getString("transmitido"));
		transmissao.setConcentrador(rs.getString("concentrador"));
		transmissao.setNivel(rs.getString("nivel"));
		transmissao.setCracha(rs.getString("cracha"));
		transmissao.setMatricula(rs.getString("matricula"));
		transmissao.setGrupo(rs.getString("grupo"));
		transmissao.setPorta(rs.getString("porta"));
		transmissao.setAtualizador(rs.getString("atualizador"));
		
		transmissao.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));


		return transmissao;
	}

	public List<Transmissao> lista() {
		try {
			List<Transmissao> lista = new ArrayList<Transmissao>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_transmissao");

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
