package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.LibVeiculos;
import br.com.inteligate.depara.dados.ListaNegra;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class ListaNegraDao extends BasicDao{

	public ListaNegraDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void adiciona(ListaNegra listaNegra) throws SQLException {

		String sql = "insert into gera_lista_negra (matricula"

				+") values (?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,listaNegra.getMatricula());

		stmt.execute();

		stmt.close();


	}

	public void altera(ListaNegra listaNegraAnterior, ListaNegra listaNegraNovo) throws SQLException {

		String sql = "update gera_lista_negra set "
				+ "matricula=?"
				+ " WHERE matricula = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,listaNegraNovo.getMatricula());
		stmt.setString(2,listaNegraAnterior.getMatricula());
		stmt.execute();

		stmt.close();

	}

	public ListaNegra buscaPorChave(String matricula) throws SQLException{

		String sql = "SELECT "
				+ "matricula"
				+ " FROM gera_lista_negra"
				+ " WHERE matricula = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setString(1, matricula);

		ResultSet rs = stmt.executeQuery();
		ListaNegra listaNegra = null;
		if (rs.next()) {
			listaNegra = popula(rs);
		}

		rs.close();
		stmt.close();

		return listaNegra;
	}

	public ListaNegra popula(ResultSet rs) throws SQLException{
		ListaNegra listaNegra = new ListaNegra();
		
		listaNegra.setMatricula(rs.getString("matricula"));
		return listaNegra;
	}

	public List<ListaNegra> lista() {
		try {
			List<ListaNegra> lista = new ArrayList<ListaNegra>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_lista_negra");

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
