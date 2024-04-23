package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.AcessoUsuario;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class AcessoUsuarioDao extends BasicDao{

	public AcessoUsuarioDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(AcessoUsuario acessoUsuario) throws SQLException {

		String sql = "insert into gera_acesso_usuario (id_acesso_usuario" 
				+ ",id_unidaderemota"
				+ ",id_zonadetempo"
				+ ",id_usuarios"
				+ ",matricula"
				+ ",coletor"
				+ ",leitora"
				+ ",zonadetempo"
				+ ",concentrador"
				+ ",id_concentrador"
				+ ",porta"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",horario_livre"
				+ ",d_h_inicio_validade"
				+ ",d_h_termino_validade"
				+ ",nome_autorizador"
				+ ",cargo_autorizador"
				+ ",id_nivel"
				+ ",datainiciovalidade"
				+ ",datafimvalidade"
				+") values (nextval('seq_acesso_usuario')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		Utils.setParam(stmt,1,acessoUsuario.getId_unidaderemota());
		Utils.setParam(stmt,2,acessoUsuario.getId_zonadetempo());
		stmt.setLong(3,acessoUsuario.getId_usuarios());
		stmt.setString(4,acessoUsuario.getMatricula());
		stmt.setString(5,acessoUsuario.getColetor());
		stmt.setString(6,acessoUsuario.getLeitora());
		stmt.setString(7,acessoUsuario.getZonadetempo());
		stmt.setString(8,acessoUsuario.getConcentrador());
		Utils.setParam(stmt,9,acessoUsuario.getId_concentrador());
		stmt.setString(10,acessoUsuario.getPorta());
		stmt.setString(11,acessoUsuario.getAtualizador());
		stmt.setTimestamp(12,dateTimeToSql(acessoUsuario.getD_h_atualizacao()));
		if(acessoUsuario.getHorario_livre()!=null)
			stmt.setBoolean(13,acessoUsuario.getHorario_livre());
		else
			stmt.setNull(13, Types.BOOLEAN);
		stmt.setTimestamp(14,dateTimeToSql(acessoUsuario.getD_h_inicio_validade()));
		stmt.setTimestamp(15,dateTimeToSql(acessoUsuario.getD_h_termino_validade()));
		stmt.setString(16,acessoUsuario.getNome_autorizador());
		stmt.setString(17,acessoUsuario.getCargo_autorizador());
		stmt.setLong(18,acessoUsuario.getId_nivel());
		stmt.setTimestamp(19,dateTimeToSql(acessoUsuario.getDatainiciovalidade()));
		stmt.setTimestamp(20,dateTimeToSql(acessoUsuario.getDatafimvalidade()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(AcessoUsuario acessoUsuario) throws SQLException {

		String sql = "update gera_acesso_usuario set "
				+ "id_unidaderemota=?"
				+ ",id_zonadetempo=?"
				+ ",id_usuarios=?"
				+ ",matricula=?"
				+ ",coletor=?"
				+ ",leitora=?"
				+ ",zonadetempo=?"
				+ ",concentrador=?"
				+ ",id_concentrador=?"
				+ ",porta=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",horario_livre=?"
				+ ",d_h_inicio_validade=?"
				+ ",d_h_termino_validade=?"
				+ ",nome_autorizador=?"
				+ ",cargo_autorizador=?"
				+ ",id_nivel=?"
				+ ",datainiciovalidade=?"
				+ ",datafimvalidade=?"
				+ " WHERE id_acesso_usuario = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setLong(1,acessoUsuario.getId_unidaderemota());
		stmt.setLong(2,acessoUsuario.getId_zonadetempo());
		stmt.setLong(3,acessoUsuario.getId_usuarios());
		stmt.setString(4,acessoUsuario.getMatricula());
		stmt.setString(5,acessoUsuario.getColetor());
		stmt.setString(6,acessoUsuario.getLeitora());
		stmt.setString(7,acessoUsuario.getZonadetempo());
		stmt.setString(8,acessoUsuario.getConcentrador());
		stmt.setLong(9,acessoUsuario.getId_concentrador());
		stmt.setString(10,acessoUsuario.getPorta());
		stmt.setString(11,acessoUsuario.getAtualizador());
		stmt.setTimestamp(12,dateTimeToSql(acessoUsuario.getD_h_atualizacao()));
		stmt.setBoolean(13,acessoUsuario.getHorario_livre());
		stmt.setTimestamp(14,dateTimeToSql(acessoUsuario.getD_h_inicio_validade()));
		stmt.setTimestamp(15,dateTimeToSql(acessoUsuario.getD_h_termino_validade()));
		stmt.setString(16,acessoUsuario.getNome_autorizador());
		stmt.setString(17,acessoUsuario.getCargo_autorizador());
		stmt.setLong(18,acessoUsuario.getId_nivel());
		stmt.setTimestamp(19,dateTimeToSql(acessoUsuario.getDatainiciovalidade()));
		stmt.setTimestamp(20,dateTimeToSql(acessoUsuario.getDatafimvalidade()));

		stmt.setLong(21,acessoUsuario.getId_acesso_usuario());
		stmt.execute();

		stmt.close();

	}

	public AcessoUsuario buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_acesso_usuario"
				+ ",id_unidaderemota"
				+ ",id_zonadetempo"
				+ ",id_usuarios"
				+ ",matricula"
				+ ",coletor"
				+ ",leitora"
				+ ",zonadetempo"
				+ ",concentrador"
				+ ",id_concentrador"
				+ ",porta"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",horario_livre"
				+ ",d_h_inicio_validade"
				+ ",d_h_termino_validade"
				+ ",nome_autorizador"
				+ ",cargo_autorizador"
				+ ",id_nivel"
				+ ",datainiciovalidade"
				+ ",datafimvalidade"
				+ " FROM gera_acesso_usuario"
				+ " WHERE id_acesso_usuario = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		AcessoUsuario acessoUsuario = null;
		if (rs.next()) {
			acessoUsuario = popula(rs);
		}

		rs.close();
		stmt.close();

		return acessoUsuario;
	}

	public AcessoUsuario popula(ResultSet rs) throws SQLException{
		AcessoUsuario acessoUsuario = new AcessoUsuario();

		acessoUsuario.setId_acesso_usuario(rs.getLong("id_acesso_usuario"));
		acessoUsuario.setId_unidaderemota(rs.getLong("id_unidaderemota"));
		acessoUsuario.setId_zonadetempo(rs.getLong("id_zonadetempo"));
		acessoUsuario.setId_usuarios(rs.getLong("id_usuarios"));
		acessoUsuario.setMatricula(rs.getString("matricula"));
		acessoUsuario.setColetor(rs.getString("coletor"));
		acessoUsuario.setLeitora(rs.getString("leitora"));
		acessoUsuario.setZonadetempo(rs.getString("zonadetempo"));
		acessoUsuario.setConcentrador(rs.getString("concentrador"));
		acessoUsuario.setId_concentrador(rs.getLong("id_concentrador"));
		acessoUsuario.setPorta(rs.getString("porta"));
		acessoUsuario.setAtualizador(rs.getString("atualizador"));
		acessoUsuario.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		acessoUsuario.setHorario_livre(rs.getBoolean("horario_livre"));
		acessoUsuario.setD_h_inicio_validade(rs.getTimestamp("d_h_inicio_validade"));
		acessoUsuario.setD_h_termino_validade(rs.getTimestamp("d_h_termino_validade"));
		acessoUsuario.setNome_autorizador(rs.getString("nome_autorizador"));
		acessoUsuario.setCargo_autorizador(rs.getString("cargo_autorizador"));
		acessoUsuario.setId_nivel(rs.getLong("id_nivel"));
		acessoUsuario.setDatainiciovalidade(rs.getTimestamp("datainiciovalidade"));
		acessoUsuario.setDatafimvalidade(rs.getTimestamp("datafimvalidade"));


		return acessoUsuario;
	}

	public List<AcessoUsuario> lista() {
		try {
			List<AcessoUsuario> lista = new ArrayList<AcessoUsuario>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_acesso_usuario");

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
