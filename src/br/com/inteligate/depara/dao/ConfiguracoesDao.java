package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.inteligate.depara.dados.Classificacoes;

public class ConfiguracoesDao extends BasicDao{

	public ConfiguracoesDao() {

	}

	public int tamanhoMatricula() throws SQLException{
		String sql = "SELECT "
				+ "Valor"
				+ " FROM gera_parametros"
				+ " WHERE parametro = 'TAMMAT'";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);


		ResultSet rs = stmt.executeQuery();
		int tamMat = rs.getInt("Valor");
		rs.close();
		stmt.close();
		return tamMat;

	}
}
