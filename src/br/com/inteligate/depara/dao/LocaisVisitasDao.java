package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.LocaisVisitas;
import br.com.inteligate.depara.dados.LocaisVisitasCategorias;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class LocaisVisitasDao extends BasicDao{

	public LocaisVisitasDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(LocaisVisitas locaisVisitas) throws SQLException {

		String sql = "insert into gera_locais_visitas (id_local_visita"
				+ ",local_visita" 
				+ ",bloqueia_entrada_apos_limite" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+ ",nivel" 
				+ ",id_niveis"
				+ ",id_site" 
				+") values (nextval('seq_local_visita')"
				+ ",?,?,?, ?,?,? ,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,locaisVisitas.getLocal_visita());
		stmt.setBoolean(2,locaisVisitas.isBloqueia_entrada_apos_limite());
		stmt.setString(3,locaisVisitas.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(locaisVisitas.getD_h_atualizacao()));
		stmt.setString(5,locaisVisitas.getNivel());
		stmt.setLong(6,locaisVisitas.getId_niveis());
		stmt.setLong(7,locaisVisitas.getId_site());


		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(LocaisVisitas locaisVisitas) throws SQLException {

		String sql = "update gera_locais_visitas set "
				+ "local_visita=?" 
				+ ",bloqueia_entrada_apos_limite=?" 
				+ ",atualizador=?" 
				+ ",d_h_atualizacao=?"
				+ ",nivel=?" 
				+ ",id_niveis=?"
				+ ",id_site=?" 
				+ " WHERE id_local_visita = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,locaisVisitas.getLocal_visita());
		stmt.setBoolean(2,locaisVisitas.isBloqueia_entrada_apos_limite());
		stmt.setString(3,locaisVisitas.getAtualizador());
		stmt.setTimestamp(4,dateTimeToSql(locaisVisitas.getD_h_atualizacao()));
		stmt.setString(5,locaisVisitas.getNivel());
		stmt.setLong(6,locaisVisitas.getId_niveis());
		stmt.setLong(7,locaisVisitas.getId_site());
		stmt.setLong(8,locaisVisitas.getId_local_visita());

		stmt.execute();

		stmt.close();

	}
	
	public LocaisVisitas buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_local_visita"
				+ ",local_visita" 
				+ ",bloqueia_entrada_apos_limite" 
				+ ",atualizador" 
				+ ",d_h_atualizacao"
				+ ",nivel" 
				+ ",id_niveis"
				+ ",id_site" 
				+ " FROM gera_locais_visitas"
				+ " WHERE id_local_visita = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		LocaisVisitas locaisVisitas = null;
		if (rs.next()) {
			locaisVisitas = popula(rs);
		}

		rs.close();
		stmt.close();

		return locaisVisitas;
	}
	
	public LocaisVisitas popula(ResultSet rs) throws SQLException{
		LocaisVisitas locaisVisitas = new LocaisVisitas();

		locaisVisitas.setId_local_visita(rs.getLong("id_local_visita"));
		locaisVisitas.setLocal_visita(rs.getString("local_visita"));
		locaisVisitas.setBloqueia_entrada_apos_limite(rs.getBoolean("bloqueia_entrada_apos_limite"));
		locaisVisitas.setAtualizador(rs.getString("atualizador"));
		locaisVisitas.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		locaisVisitas.setNivel(rs.getString("nivel"));
		locaisVisitas.setId_niveis(rs.getLong("id_niveis"));
		locaisVisitas.setId_site(rs.getLong("id_site"));
		
		return locaisVisitas;
	}
	public List<LocaisVisitas> lista() {
		try {
			List<LocaisVisitas> lista = new ArrayList<LocaisVisitas>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_locais_visitas");

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
