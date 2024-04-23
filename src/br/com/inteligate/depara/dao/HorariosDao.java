package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.HistoricoEventos;
import br.com.inteligate.depara.dados.Horarios;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class HorariosDao extends BasicDao{

	public HorariosDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(Horarios horarios) throws SQLException {

	
		String sql = "insert into gera_horarios (nr_hor"
				+ ",hrent"
				+ ",hrsai"
				+ ",tpref_pri"
				+ ",tpref_sec"
				+") values ("
				+ "?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1,horarios.getNr_hor());
		stmt.setTimestamp(2,dateTimeToSql(horarios.getHrent()));
		stmt.setTimestamp(3,dateTimeToSql(horarios.getHrsai()));
		stmt.setInt(4,horarios.getTpref_pri());
		stmt.setInt(5,horarios.getTpref_sec());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Horarios horarios) throws SQLException {

		String sql = "update gera_horarios set "
				+ "nr_hor=?"
				+ ",hrent=?"
				+ ",hrsai=?"
				+ ",tpref_pri=?"
				+ ",tpref_sec=?"
				+ " WHERE nr_hor = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setInt(1,horarios.getNr_hor());
		stmt.setTimestamp(2,dateTimeToSql(horarios.getHrent()));
		stmt.setTimestamp(3,dateTimeToSql(horarios.getHrsai()));
		stmt.setInt(4,horarios.getTpref_pri());
		stmt.setInt(5,horarios.getTpref_sec());
		stmt.setInt(6,horarios.getNr_hor());
		
		stmt.execute();

		stmt.close();

	}

	public Horarios buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "nr_hor"
				+ ",hrent"
				+ ",hrsai"
				+ ",tpref_pri"
				+ ",tpref_sec"
				+ " FROM gera_horarios"
				+ " WHERE nr_hor = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Horarios horarios = null;
		if (rs.next()) {
			horarios = popula(rs);
		}

		rs.close();
		stmt.close();

		return horarios;
	}

	public Horarios popula(ResultSet rs) throws SQLException{
		Horarios horarios = new Horarios();
		
		horarios.setNr_hor(rs.getInt("nr_hor"));
		horarios.setHrent(rs.getTimestamp("hrent"));
		horarios.setHrsai(rs.getTimestamp("hrsai"));
		horarios.setNr_hor(rs.getInt("nr_hor"));
		horarios.setTpref_pri(rs.getInt("tpref_pri"));
		horarios.setTpref_sec(rs.getInt("tpref_sec"));

		return horarios;
	}

	public List<Horarios> lista() {
		try {
			List<Horarios> lista = new ArrayList<Horarios>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_horarios");

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
