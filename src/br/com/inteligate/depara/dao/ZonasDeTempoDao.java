package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.ZonasDeTempo;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.Visitantes;

public class ZonasDeTempoDao extends BasicDao{

	public ZonasDeTempoDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(ZonasDeTempo zonasDeTempo) throws SQLException {

		String sql = "insert into gera_zonasdetempo (id_zonadetempo"

				+ ",zona"
				+ ",segunda"
				+ ",terca"
				+ ",quarta"
				+ ",quinta"
				+ ",sexta"
				+ ",sabado"
				+ ",domingo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"

				+") values (nextval('seq_zonasdetempo')"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,zonasDeTempo.getZona());
		stmt.setString(2,zonasDeTempo.getSegunda());
		stmt.setString(3,zonasDeTempo.getTerca());
		stmt.setString(4,zonasDeTempo.getQuarta());
		stmt.setString(5,zonasDeTempo.getQuinta());
		stmt.setString(6,zonasDeTempo.getSexta());
		stmt.setString(7,zonasDeTempo.getSabado());
		stmt.setString(8,zonasDeTempo.getDomingo());
		stmt.setString(9,zonasDeTempo.getDescricao());
		stmt.setString(10,zonasDeTempo.getAtualizador());
		stmt.setTimestamp(11,dateTimeToSql(zonasDeTempo.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(ZonasDeTempo zonasDeTempo) throws SQLException {

		String sql = "update gera_zonasdetempo set "
				+ "zona=?"
				+ ",segunda=?"
				+ ",terca=?"
				+ ",quarta=?"
				+ ",quinta=?"
				+ ",sexta=?"
				+ ",sabado=?"
				+ ",domingo=?"
				+ ",descricao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				
				+ " WHERE id_zonadetempo = ?";


		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,zonasDeTempo.getZona());
		stmt.setString(2,zonasDeTempo.getSegunda());
		stmt.setString(3,zonasDeTempo.getTerca());
		stmt.setString(4,zonasDeTempo.getQuarta());
		stmt.setString(5,zonasDeTempo.getQuinta());
		stmt.setString(6,zonasDeTempo.getSexta());
		stmt.setString(7,zonasDeTempo.getSabado());
		stmt.setString(8,zonasDeTempo.getDomingo());
		stmt.setString(9,zonasDeTempo.getDescricao());
		stmt.setString(10,zonasDeTempo.getAtualizador());
		stmt.setTimestamp(11,dateTimeToSql(zonasDeTempo.getD_h_atualizacao()));
		stmt.setLong(12,zonasDeTempo.getId_zonadetempo());


		stmt.execute();

		stmt.close();


	}

	public ZonasDeTempo buscaPorId(long id) throws SQLException{


		String sql = "SELECT "
				+ "id_zonadetempo"
				+ ",zona"
				+ ",segunda"
				+ ",terca"
				+ ",quarta"
				+ ",quinta"
				+ ",sexta"
				+ ",sabado"
				+ ",domingo"
				+ ",descricao"
				+ ",atualizador"
				+ ",d_h_atualizacao"

				+ " FROM gera_zonasdetempo"
				+ " WHERE id_zonadetempo = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		ZonasDeTempo zonasDeTempo = null;
		if (rs.next()) {
			zonasDeTempo = popula(rs);
		}

		rs.close();
		stmt.close();

		return zonasDeTempo;
	}

	public ZonasDeTempo popula(ResultSet rs) throws SQLException{
		ZonasDeTempo zonasDeTempo = new ZonasDeTempo();
		
		zonasDeTempo.setId_zonadetempo(rs.getLong("id_zonadetempo"));
		zonasDeTempo.setZona(rs.getString("zona"));
		zonasDeTempo.setSegunda(rs.getString("segunda"));
		zonasDeTempo.setTerca(rs.getString("terca"));
		zonasDeTempo.setQuarta(rs.getString("quarta"));
		zonasDeTempo.setQuinta(rs.getString("quinta"));
		zonasDeTempo.setSexta(rs.getString("sexta"));
		zonasDeTempo.setSabado(rs.getString("sabado"));
		zonasDeTempo.setDomingo(rs.getString("domingo"));
		zonasDeTempo.setDescricao(rs.getString("descricao"));
		
		zonasDeTempo.setAtualizador(rs.getString("atualizador"));
		zonasDeTempo.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return zonasDeTempo;
	}

	public List<ZonasDeTempo> lista() {
		try {
			List<ZonasDeTempo> lista = new ArrayList<ZonasDeTempo>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_zonasdetempo");

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
