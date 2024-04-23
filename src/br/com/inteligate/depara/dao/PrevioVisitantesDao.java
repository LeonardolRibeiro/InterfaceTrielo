package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Previo;
import br.com.inteligate.depara.dados.PrevioVisitantes;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class PrevioVisitantesDao extends BasicDao{

	public PrevioVisitantesDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(PrevioVisitantes previoVisitantes) throws SQLException {

		String sql = "insert into aces_previo_visitantes (id_aces_previo_visitantes"
				+ ",rg"
				+ ",nome"
				+ ",empresa"
				+ ",email"
				+ ",inicioliberadode"
				+ ",inicioliberadoate"
				+ ",horarioliberadode"
				+ ",horarioliberadoate"
				+ ",diaaniversario"
				+ ",mesaniversario"
				+ ",empresavisitada"
				+ ",blocoliberado"
				+ ",tipovisitante"
				+ ",visitado"
				+ ",cod_barra"
				+ ",status"
				+ ",msg"
				+ ",nivel" 
				+ ",bloqueada"
				+ ",atualizador"
				+ ",autorizado_por"
				+ ",dh_atualizacao"
				+ ",id_local_acesso" 
				+ ",observacao1"
				+ ",observacao2"
				+ ",fonevisitado" 
				+") values (nextval('seq_previo_visitantes')"
				+ ",?,?,? ,?,?,? ,?,?,? ,?"
				+ ",?,?,? ,?,?,? ,?,?,? ,?"
				+ ",?,?,? ,?,?,? "
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,previoVisitantes.getRg());
		stmt.setString(2,previoVisitantes.getNome());
		stmt.setString(3,previoVisitantes.getEmpresa());
		stmt.setString(4,previoVisitantes.getEmail());
		stmt.setTimestamp(5,dateTimeToSql(previoVisitantes.getInicioliberadode()));
		stmt.setTimestamp(6,dateTimeToSql(previoVisitantes.getInicioliberadoate()));
		stmt.setTimestamp(7,dateTimeToSql(previoVisitantes.getHorarioliberadode()));
		stmt.setTimestamp(8,dateTimeToSql(previoVisitantes.getHorarioliberadoate()));
		stmt.setString(9,previoVisitantes.getDiaaniversario());
		stmt.setString(10,previoVisitantes.getMesaniversario());
		stmt.setString(11,previoVisitantes.getEmpresavisitada());
		stmt.setString(12,previoVisitantes.getBlocoliberado());
		stmt.setString(13,previoVisitantes.getTipovisitante());
		stmt.setString(14,previoVisitantes.getVisitado());
		stmt.setString(15,previoVisitantes.getCod_barra());
		stmt.setString(16,previoVisitantes.getStatus());
		stmt.setString(17,previoVisitantes.getMsg());
		stmt.setString(18,previoVisitantes.getNivel());
		stmt.setBoolean(19,previoVisitantes.isBloqueada());
		stmt.setString(20,previoVisitantes.getAtualizador());
		stmt.setString(21,previoVisitantes.getAutorizado_por());
		stmt.setTimestamp(22,dateTimeToSql(previoVisitantes.getDh_atualizacao()));
		stmt.setLong(23,previoVisitantes.getId_local_acesso());
		stmt.setString(24,previoVisitantes.getObservacao1());
		stmt.setString(25,previoVisitantes.getObservacao2());
		stmt.setString(26,previoVisitantes.getFonevisitado());

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(PrevioVisitantes previoVisitantes) throws SQLException {

		String sql = "update aces_previo_visitantes set "
				+ "rg=?"
				+ ",nome=?"
				+ ",empresa=?"
				+ ",email=?"
				+ ",inicioliberadode=?"
				+ ",inicioliberadoate=?"
				+ ",horarioliberadode=?"
				+ ",horarioliberadoate=?"
				+ ",diaaniversario=?"
				+ ",mesaniversario=?"
				+ ",empresavisitada=?"
				+ ",blocoliberado=?"
				+ ",tipovisitante=?"
				+ ",visitado=?"
				+ ",cod_barra=?"
				+ ",status=?"
				+ ",msg=?"
				+ ",nivel=?" 
				+ ",bloqueada=?"
				+ ",atualizador=?"
				+ ",autorizado_por=?"
				+ ",dh_atualizacao=?"
				+ ",id_local_acesso=?" 
				+ ",observacao1=?"
				+ ",observacao2=?"
				+ ",fonevisitado=?" 

				+ " WHERE id_aces_previo_visitantes = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);


		stmt.setString(1,previoVisitantes.getRg());
		stmt.setString(2,previoVisitantes.getNome());
		stmt.setString(3,previoVisitantes.getEmpresa());
		stmt.setString(4,previoVisitantes.getEmail());
		stmt.setTimestamp(5,dateTimeToSql(previoVisitantes.getInicioliberadode()));
		stmt.setTimestamp(6,dateTimeToSql(previoVisitantes.getInicioliberadoate()));
		stmt.setTimestamp(7,dateTimeToSql(previoVisitantes.getHorarioliberadode()));
		stmt.setTimestamp(8,dateTimeToSql(previoVisitantes.getHorarioliberadoate()));
		stmt.setString(9,previoVisitantes.getDiaaniversario());
		stmt.setString(10,previoVisitantes.getMesaniversario());
		stmt.setString(11,previoVisitantes.getEmpresavisitada());
		stmt.setString(12,previoVisitantes.getBlocoliberado());
		stmt.setString(13,previoVisitantes.getTipovisitante());
		stmt.setString(14,previoVisitantes.getVisitado());
		stmt.setString(15,previoVisitantes.getCod_barra());
		stmt.setString(16,previoVisitantes.getStatus());
		stmt.setString(17,previoVisitantes.getMsg());
		stmt.setString(18,previoVisitantes.getNivel());
		stmt.setBoolean(19,previoVisitantes.isBloqueada());
		stmt.setString(20,previoVisitantes.getAtualizador());
		stmt.setString(21,previoVisitantes.getAutorizado_por());
		stmt.setTimestamp(22,dateTimeToSql(previoVisitantes.getDh_atualizacao()));
		stmt.setLong(23,previoVisitantes.getId_local_acesso());
		stmt.setString(24,previoVisitantes.getObservacao1());
		stmt.setString(25,previoVisitantes.getObservacao2());
		stmt.setString(26,previoVisitantes.getFonevisitado());
		stmt.setLong(27,previoVisitantes.getId_aces_previo_visitantes());

		stmt.execute();

		stmt.close();

	}
	
	public PrevioVisitantes buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+" id_aces_previo_visitantes"
				+ ",rg"
				+ ",nome"
				+ ",empresa"
				+ ",email"
				+ ",inicioliberadode"
				+ ",inicioliberadoate"
				+ ",horarioliberadode"
				+ ",horarioliberadoate"
				+ ",diaaniversario"
				+ ",mesaniversario"
				+ ",empresavisitada"
				+ ",blocoliberado"
				+ ",tipovisitante"
				+ ",visitado"
				+ ",cod_barra"
				+ ",status"
				+ ",msg"
				+ ",nivel" 
				+ ",bloqueada"
				+ ",atualizador"
				+ ",autorizado_por"
				+ ",dh_atualizacao"
				+ ",id_local_acesso" 
				+ ",observacao1"
				+ ",observacao2"
				+ ",fonevisitado" 
				+ " FROM aces_previo_visitantes"
				+ " WHERE id_aces_previo_visitantes = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		PrevioVisitantes previoVisitantes = null;
		if (rs.next()) {
			previoVisitantes = popula(rs);
		}

		rs.close();
		stmt.close();

		return previoVisitantes;
	}
	
	public PrevioVisitantes popula(ResultSet rs) throws SQLException{
		PrevioVisitantes previoVisitantes = new PrevioVisitantes();

		previoVisitantes.setId_aces_previo_visitantes(rs.getLong("id_aces_previo_visitantes"));

		previoVisitantes.setRg(rs.getString("rg"));
		previoVisitantes.setNome(rs.getString("nome"));
		previoVisitantes.setEmpresa(rs.getString("empresa"));
		previoVisitantes.setEmail(rs.getString("email"));
		previoVisitantes.setInicioliberadode(rs.getTimestamp("inicioliberadode"));
		previoVisitantes.setInicioliberadoate(rs.getTimestamp("inicioliberadoate"));
		previoVisitantes.setHorarioliberadode(rs.getTimestamp("horarioliberadode"));
		previoVisitantes.setHorarioliberadoate(rs.getTimestamp("horarioliberadoate"));
		previoVisitantes.setDiaaniversario(rs.getString("diaaniversario"));
		previoVisitantes.setMesaniversario(rs.getString("mesaniversario"));
		previoVisitantes.setEmpresavisitada(rs.getString("empresavisitada"));
		previoVisitantes.setBlocoliberado(rs.getString("blocoliberado"));
		previoVisitantes.setTipovisitante(rs.getString("tipovisitante"));
		previoVisitantes.setVisitado(rs.getString("visitado"));
		previoVisitantes.setCod_barra(rs.getString("cod_barra"));
		previoVisitantes.setStatus(rs.getString("status"));
		previoVisitantes.setMsg(rs.getString("msg"));
		previoVisitantes.setNivel(rs.getString("nivel"));
		previoVisitantes.setBloqueada(rs.getBoolean("bloqueada"));
		previoVisitantes.setAtualizador(rs.getString("atualizador"));
		previoVisitantes.setAutorizado_por(rs.getString("autorizado_por"));
		previoVisitantes.setDh_atualizacao(rs.getTimestamp("dh_atualizacao"));
		previoVisitantes.setId_local_acesso(rs.getLong("id_local_acesso"));
		previoVisitantes.setObservacao1(rs.getString("observacao1"));
		previoVisitantes.setObservacao2(rs.getString("observacao2"));
		previoVisitantes.setFonevisitado(rs.getString("fonevisitado"));
		
		return previoVisitantes;
	}

	public List<PrevioVisitantes> lista() {
		try {
			List<PrevioVisitantes> lista = new ArrayList<PrevioVisitantes>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from aces_previo_visitantes");

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
