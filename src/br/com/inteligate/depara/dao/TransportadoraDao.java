package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Transmissao;
import br.com.inteligate.depara.dados.Transportadora;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class TransportadoraDao extends BasicDao{

	public TransportadoraDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Transportadora transportadora) throws SQLException {
		
		String sql = "insert into aces_transportadora (id_transp"
				+ ",nome"
				+ ",tipo"
				
				+") values (nextval('seq_transportadora')"
				+ ",?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,transportadora.getNome());
		stmt.setString(2,transportadora.getTipo());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(Transportadora transportadora) throws SQLException {

		String sql = "update aces_transportadora set "
				+ "nome=?"
				+ ",tipo=?"

				+ " WHERE id_transp = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,transportadora.getNome());
		stmt.setString(2,transportadora.getTipo());
		stmt.setLong(3,transportadora.getId_transp());
		stmt.execute();

		stmt.close();

	}

	public Transportadora buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_transp"
				+ ",nome"
				+ ",tipo"
				+ " FROM aces_transportadora"

				+ " WHERE id_transp = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Transportadora transportadora = null;
		if (rs.next()) {
			transportadora = popula(rs);
		}

		rs.close();
		stmt.close();

		return transportadora;
	}

	public Transportadora popula(ResultSet rs) throws SQLException{
		Transportadora transportadora = new Transportadora();

		transportadora.setId_transp(rs.getLong("id_transp"));
		transportadora.setNome(rs.getString("nome"));
		transportadora.setTipo(rs.getString("tipo"));


		return transportadora;
		
	}

	public List<Transportadora> lista() {
		try {
			List<Transportadora> lista = new ArrayList<Transportadora>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from Transportadora");

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
