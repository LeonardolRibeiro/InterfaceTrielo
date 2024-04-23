package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.HorarioUsuario;
import br.com.inteligate.depara.dados.Horarios;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class HorarioUsuarioDao extends BasicDao{

	public HorarioUsuarioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void adiciona(HorarioUsuario horariosUsuarios) throws SQLException {


		
		String sql = "insert into gera_horario_Usuario ("
				+ "matricula"
				+ ",dia_semana"
				+ ",hr_entrada"
				+ ",hr_saida"
				+ ",folga_comp"
				+ ",dthr_importacao"
				+") values ("
				+ "?,?,?,?,?,?"
				+ ")";

		PreparedStatement stmt;

			
		stmt = connection.prepareStatement(sql);
		stmt.setString(1,horariosUsuarios.getMatricula());
		stmt.setInt(2,horariosUsuarios.getDia_semana());
		stmt.setTimestamp(3,dateTimeToSql(horariosUsuarios.getHr_entrada()));
		stmt.setTimestamp(4,dateTimeToSql(horariosUsuarios.getHr_saida()));
		stmt.setBoolean(5,horariosUsuarios.isFolga_comp());
		stmt.setTimestamp(6,dateTimeToSql(horariosUsuarios.getDthr_importacao()));

		stmt.execute();

		stmt.close();


	}

	public void altera(HorarioUsuario horariosUsuarios) throws SQLException {

		String sql = "update gera_horario_Usuario set "
				+ "matricula=?"
				+ ",dia_semana=?"
				+ ",hr_entrada=?"
				+ ",hr_saida=?"
				+ ",folga_comp=?"
				+ ",dthr_importacao=?"
				+ " WHERE matricula = ? and dia_semana=?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,horariosUsuarios.getMatricula());
		stmt.setInt(2,horariosUsuarios.getDia_semana());
		stmt.setTimestamp(3,dateTimeToSql(horariosUsuarios.getHr_entrada()));
		stmt.setTimestamp(4,dateTimeToSql(horariosUsuarios.getHr_saida()));
		stmt.setBoolean(5,horariosUsuarios.isFolga_comp());
		stmt.setTimestamp(6,dateTimeToSql(horariosUsuarios.getDthr_importacao()));
		
		stmt.setString(7,horariosUsuarios.getMatricula());
		stmt.setInt(8,horariosUsuarios.getDia_semana());
		
		stmt.execute();

		stmt.close();

	}

	public HorarioUsuario buscaPorChave(String matricula, int dia_semana) throws SQLException{

		String sql = "SELECT "
				+ "matricula"
				+ ",dia_semana"
				+ ",hr_entrada"
				+ ",hr_saida"
				+ ",folga_comp"
				+ ",dthr_importacao"

				+ " FROM gera_horario_Usuario"
				+ " WHERE matricula = ? and dia_semana=?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1,matricula);
		stmt.setInt(2,dia_semana);
		
		ResultSet rs = stmt.executeQuery();
		HorarioUsuario horariosUsuarios = null;
		if (rs.next()) {
			horariosUsuarios = popula(rs);
		}

		rs.close();
		stmt.close();

		return horariosUsuarios;
	}

	public HorarioUsuario popula(ResultSet rs) throws SQLException{
		HorarioUsuario horariosUsuarios = new HorarioUsuario();
		
		horariosUsuarios.setMatricula(rs.getString("matricula"));
		horariosUsuarios.setDia_semana(rs.getInt("dia_semana"));
		horariosUsuarios.setHr_entrada(rs.getTimestamp("hr_entrada"));
		horariosUsuarios.setHr_saida(rs.getTimestamp("hr_saida"));
		horariosUsuarios.setFolga_comp(rs.getBoolean("folga_comp"));
		horariosUsuarios.setDthr_importacao(rs.getTimestamp("dthr_importacao"));

		
		return horariosUsuarios;
	}

	public List<HorarioUsuario> lista() {
		try {
			List<HorarioUsuario> lista = new ArrayList<HorarioUsuario>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_horario_Usuario");

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
