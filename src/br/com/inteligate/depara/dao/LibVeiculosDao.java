package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.HorarioUsuario;
import br.com.inteligate.depara.dados.LibVeiculos;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class LibVeiculosDao extends BasicDao{

	public LibVeiculosDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public long adiciona(LibVeiculos libVeiculos) throws SQLException {

		   
		String sql = "insert into gera_lib_Veiculos (id_libvei"
				+ ",mat_veiculo"
				+ ",mat_motorista"
				+ ",obs"
				+ ",cracha"
				+ ",placa"
				+ ",veiculo"
				+ ",motorista"
				+ ",operador"
				+ ",dt_inival"
				+ ",dt_fimval"
				+ ",dt_agendamento"
				+ ",dt_devolucao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+") values (nextval('seq_libvei')"
				+ ",?,?,?, ?,?,?, ?,?,?, ?"
				+ ",?,?,?,?"
				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,libVeiculos.getMat_veiculo());
		stmt.setString(2,libVeiculos.getMat_motorista());
		stmt.setString(3,libVeiculos.getObs());
		stmt.setString(4,libVeiculos.getCracha());
		stmt.setString(5,libVeiculos.getPlaca());
		stmt.setString(6,libVeiculos.getVeiculo());
		stmt.setString(7,libVeiculos.getMotorista());
		stmt.setString(8,libVeiculos.getOperador());
		stmt.setTimestamp(9,dateTimeToSql(libVeiculos.getDt_inival()));
		stmt.setTimestamp(10,dateTimeToSql(libVeiculos.getDt_fimval()));
		stmt.setTimestamp(11,dateTimeToSql(libVeiculos.getDt_agendamento()));
		stmt.setTimestamp(12,dateTimeToSql(libVeiculos.getDt_devolucao()));
		stmt.setString(13,libVeiculos.getAtualizador());
		stmt.setTimestamp(14,dateTimeToSql(libVeiculos.getD_h_atualizacao()));

		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}

	public void altera(LibVeiculos libVeiculos) throws SQLException {

		String sql = "update gera_lib_Veiculos set "
				+ "mat_veiculo=?"
				+ ",mat_motorista=?"
				+ ",obs=?"
				+ ",cracha=?"
				+ ",placa=?"
				+ ",veiculo=?"
				+ ",motorista=?"
				+ ",operador=?"
				+ ",dt_inival=?"
				+ ",dt_fimval=?"
				+ ",dt_agendamento=?"
				+ ",dt_devolucao=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ " WHERE id_libvei = ?";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);
		stmt.setString(1,libVeiculos.getMat_veiculo());
		stmt.setString(2,libVeiculos.getMat_motorista());
		stmt.setString(3,libVeiculos.getObs());
		stmt.setString(4,libVeiculos.getCracha());
		stmt.setString(5,libVeiculos.getPlaca());
		stmt.setString(6,libVeiculos.getVeiculo());
		stmt.setString(7,libVeiculos.getMotorista());
		stmt.setString(8,libVeiculos.getOperador());
		stmt.setTimestamp(9,dateTimeToSql(libVeiculos.getDt_inival()));
		stmt.setTimestamp(10,dateTimeToSql(libVeiculos.getDt_fimval()));
		stmt.setTimestamp(11,dateTimeToSql(libVeiculos.getDt_agendamento()));
		stmt.setTimestamp(12,dateTimeToSql(libVeiculos.getDt_devolucao()));
		stmt.setString(13,libVeiculos.getAtualizador());
		stmt.setTimestamp(14,dateTimeToSql(libVeiculos.getD_h_atualizacao()));
		stmt.setLong(15, libVeiculos.getId_libvei());
		stmt.execute();

		stmt.close();

	}

	public LibVeiculos buscaPorId(long id) throws SQLException{

		String sql = "SELECT "
				+ "id_libvei"
				+ ",mat_veiculo"
				+ ",mat_motorista"
				+ ",obs"
				+ ",cracha"
				+ ",placa"
				+ ",veiculo"
				+ ",motorista"
				+ ",operador"
				+ ",dt_inival"
				+ ",dt_fimval"
				+ ",dt_agendamento"
				+ ",dt_devolucao"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ " FROM gera_lib_Veiculos"
				+ " WHERE id_libvei = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		LibVeiculos libVeiculos = null;
		if (rs.next()) {
			libVeiculos = popula(rs);
		}

		rs.close();
		stmt.close();

		return libVeiculos;
	}

	public LibVeiculos popula(ResultSet rs) throws SQLException{
		LibVeiculos libVeiculos = new LibVeiculos();

		libVeiculos.setId_libvei(rs.getLong("id_libvei"));
		libVeiculos.setMat_veiculo(rs.getString("mat_veiculo"));
		libVeiculos.setMat_motorista(rs.getString("mat_motorista"));
		libVeiculos.setObs(rs.getString("obs"));
		
		libVeiculos.setCracha(rs.getString("cracha"));
		libVeiculos.setPlaca(rs.getString("placa"));
		libVeiculos.setVeiculo(rs.getString("veiculo"));
		libVeiculos.setMotorista(rs.getString("motorista"));
		libVeiculos.setOperador(rs.getString("operador"));
		libVeiculos.setDt_inival(rs.getTimestamp("dt_inival"));
		libVeiculos.setDt_fimval(rs.getTimestamp("dt_fimval"));
		libVeiculos.setDt_agendamento(rs.getTimestamp("dt_agendamento"));
		libVeiculos.setDt_devolucao(rs.getTimestamp("dt_agendamento"));
		libVeiculos.setAtualizador(rs.getString("atualizador"));
		libVeiculos.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));

		return libVeiculos;
		
	}

	public List<LibVeiculos> lista() {
		try {
			List<LibVeiculos> lista = new ArrayList<LibVeiculos>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_lib_Veiculos");

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
