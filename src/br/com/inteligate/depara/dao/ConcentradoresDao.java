package br.com.inteligate.depara.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Classificacoes;
import br.com.inteligate.depara.dados.Concentradores;
import br.com.inteligate.depara.dados.UnidadeRemota;

public class ConcentradoresDao extends BasicDao{

	public ConcentradoresDao() {

		try {
			this.connection = DataSourceC3p0.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long adiciona(Concentradores concentradores) throws SQLException {

		String sql = "insert into gera_concentradores (id_concentradores"
				+ ",codigo"
				+ ",descricao"
				+ ",porta1"
				+ ",porta2"
				+ ",porta3"
				+ ",porta4"
				+ ",porta5"
				+ ",porta6"
				+ ",porta7"
				+ ",porta8"
				+ ",porta9"
				+ ",portaa"
				+ ",portaip"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",ativo"
				+ ",usasincronismo"
				+ ",porta01"
				+ ",porta02"
				+ ",porta03"
				+ ",porta04"
				+ ",porta05"
				+ ",porta06"
				+ ",porta07"
				+ ",porta08"
				+ ",porta09"
				+ ",porta10"
				+ ",porta11"
				+ ",porta12"
				+ ",porta13"
				+ ",porta14"
				+ ",porta15"
				+ ",porta16"
				+ ",porta17"
				+ ",porta18"
				+ ",porta19"
				+ ",porta20"
				+ ",porta21"
				+ ",porta22"
				+ ",porta23"
				+ ",porta24"
				+ ",porta25"
				+ ",porta26"
				+ ",porta27"
				+ ",porta28"
				+ ",porta29"
				+ ",porta30"
				+ ",porta31"
				+ ",porta32"
				+ ",porta33"
				+ ",porta34"
				+ ",porta35"
				+ ",porta36"
				+ ",porta37"
				+ ",porta38"
				+ ",porta39"
				+ ",porta40"
				+") values (nextval('SEQ_CONCENTRADORES')"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?"

				+ ")";

		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1,concentradores.getCodigo());
		stmt.setString(2,concentradores.getDescricao());
		stmt.setString(3,concentradores.getPorta1());
		stmt.setString(4,concentradores.getPorta2());
		stmt.setString(5,concentradores.getPorta3());
		stmt.setString(6,concentradores.getPorta4());
		stmt.setString(7,concentradores.getPorta5());
		stmt.setString(8,concentradores.getPorta6());
		stmt.setString(9,concentradores.getPorta7());
		stmt.setString(10,concentradores.getPorta8());
		stmt.setString(11,concentradores.getPorta9());
		stmt.setString(12,concentradores.getPortaa());
		stmt.setString(13,concentradores.getPortaip());
		stmt.setString(14,concentradores.getAtualizador());
		stmt.setTimestamp(15,dateTimeToSql(concentradores.getD_h_atualizacao()));
		stmt.setBoolean(16,concentradores.isAtivo());
		stmt.setBoolean(17,concentradores.isUsasincronismo());
		stmt.setString(18,concentradores.getPorta01());
		stmt.setString(19,concentradores.getPorta02());
		stmt.setString(20,concentradores.getPorta03());
		stmt.setString(21,concentradores.getPorta04());
		stmt.setString(22,concentradores.getPorta05());
		stmt.setString(23,concentradores.getPorta06());
		stmt.setString(24,concentradores.getPorta07());
		stmt.setString(25,concentradores.getPorta08());
		stmt.setString(26,concentradores.getPorta09());
		stmt.setString(27,concentradores.getPorta10());
		stmt.setString(28,concentradores.getPorta11());
		stmt.setString(29,concentradores.getPorta12());
		stmt.setString(30,concentradores.getPorta13());
		stmt.setString(31,concentradores.getPorta14());
		stmt.setString(32,concentradores.getPorta15());
		stmt.setString(33,concentradores.getPorta16());
		stmt.setString(34,concentradores.getPorta17());
		stmt.setString(35,concentradores.getPorta18());
		stmt.setString(36,concentradores.getPorta19());
		stmt.setString(37,concentradores.getPorta20());
		stmt.setString(38,concentradores.getPorta21());
		stmt.setString(39,concentradores.getPorta22());
		stmt.setString(40,concentradores.getPorta23());
		stmt.setString(41,concentradores.getPorta24());
		stmt.setString(42,concentradores.getPorta25());
		stmt.setString(43,concentradores.getPorta26());
		stmt.setString(44,concentradores.getPorta27());
		stmt.setString(45,concentradores.getPorta28());
		stmt.setString(46,concentradores.getPorta29());
		stmt.setString(47,concentradores.getPorta30());
		stmt.setString(48,concentradores.getPorta31());
		stmt.setString(49,concentradores.getPorta32());
		stmt.setString(50,concentradores.getPorta33());
		stmt.setString(51,concentradores.getPorta34());
		stmt.setString(52,concentradores.getPorta35());
		stmt.setString(53,concentradores.getPorta36());
		stmt.setString(54,concentradores.getPorta37());
		stmt.setString(55,concentradores.getPorta38());
		stmt.setString(56,concentradores.getPorta39());
		stmt.setString(57,concentradores.getPorta40());
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
	    long key = rs.getLong(1);
		rs.close();
		stmt.close();
		return key;

	}
	
	public void altera(Concentradores concentradores) throws SQLException {

		String sql = "update gera_concentradores set "
				+ "codigo=?"
				+ ",descricao=?"
				+ ",porta1=?"
				+ ",porta2=?"
				+ ",porta3=?"
				+ ",porta4=?"
				+ ",porta5=?"
				+ ",porta6=?"
				+ ",porta7=?"
				+ ",porta8=?"
				+ ",porta9=?"
				+ ",portaa=?"
				+ ",portaip=?"
				+ ",atualizador=?"
				+ ",d_h_atualizacao=?"
				+ ",ativo=?"
				+ ",usasincronismo=?"
				+ ",porta01=?"
				+ ",porta02=?"
				+ ",porta03=?"
				+ ",porta04=?"
				+ ",porta05=?"
				+ ",porta06=?"
				+ ",porta07=?"
				+ ",porta08=?"
				+ ",porta09=?"
				+ ",porta10=?"
				+ ",porta11=?"
				+ ",porta12=?"
				+ ",porta13=?"
				+ ",porta14=?"
				+ ",porta15=?"
				+ ",porta16=?"
				+ ",porta17=?"
				+ ",porta18=?"
				+ ",porta19=?"
				+ ",porta20=?"
				+ ",porta21=?"
				+ ",porta22=?"
				+ ",porta23=?"
				+ ",porta24=?"
				+ ",porta25=?"
				+ ",porta26=?"
				+ ",porta27=?"
				+ ",porta28=?"
				+ ",porta29=?"
				+ ",porta30=?"
				+ ",porta31=?"
				+ ",porta32=?"
				+ ",porta33=?"
				+ ",porta34=?"
				+ ",porta35=?"
				+ ",porta36=?"
				+ ",porta37=?"
				+ ",porta38=?"
				+ ",porta39=?"
				+ ",porta40=?"
				+ " WHERE id_concentradores = ?";


		PreparedStatement stmt;

		stmt = connection.prepareStatement(sql);

		stmt.setString(1,concentradores.getCodigo());
		stmt.setString(2,concentradores.getDescricao());
		stmt.setString(3,concentradores.getPorta1());
		stmt.setString(4,concentradores.getPorta2());
		stmt.setString(5,concentradores.getPorta3());
		stmt.setString(6,concentradores.getPorta4());
		stmt.setString(7,concentradores.getPorta5());
		stmt.setString(8,concentradores.getPorta6());
		stmt.setString(9,concentradores.getPorta7());
		stmt.setString(10,concentradores.getPorta8());
		stmt.setString(11,concentradores.getPorta9());
		stmt.setString(12,concentradores.getPortaa());
		stmt.setString(13,concentradores.getPortaip());
		stmt.setString(14,concentradores.getAtualizador());
		stmt.setTimestamp(15,dateTimeToSql(concentradores.getD_h_atualizacao()));
		stmt.setBoolean(16,concentradores.isAtivo());
		stmt.setBoolean(17,concentradores.isUsasincronismo());
		stmt.setString(18,concentradores.getPorta01());
		stmt.setString(19,concentradores.getPorta02());
		stmt.setString(20,concentradores.getPorta03());
		stmt.setString(21,concentradores.getPorta04());
		stmt.setString(22,concentradores.getPorta05());
		stmt.setString(23,concentradores.getPorta06());
		stmt.setString(24,concentradores.getPorta07());
		stmt.setString(25,concentradores.getPorta08());
		stmt.setString(26,concentradores.getPorta09());
		stmt.setString(27,concentradores.getPorta10());
		stmt.setString(28,concentradores.getPorta11());
		stmt.setString(29,concentradores.getPorta12());
		stmt.setString(30,concentradores.getPorta13());
		stmt.setString(31,concentradores.getPorta14());
		stmt.setString(32,concentradores.getPorta15());
		stmt.setString(33,concentradores.getPorta16());
		stmt.setString(34,concentradores.getPorta17());
		stmt.setString(35,concentradores.getPorta18());
		stmt.setString(36,concentradores.getPorta19());
		stmt.setString(37,concentradores.getPorta20());
		stmt.setString(38,concentradores.getPorta21());
		stmt.setString(39,concentradores.getPorta22());
		stmt.setString(40,concentradores.getPorta23());
		stmt.setString(41,concentradores.getPorta24());
		stmt.setString(42,concentradores.getPorta25());
		stmt.setString(43,concentradores.getPorta26());
		stmt.setString(44,concentradores.getPorta27());
		stmt.setString(45,concentradores.getPorta28());
		stmt.setString(46,concentradores.getPorta29());
		stmt.setString(47,concentradores.getPorta30());
		stmt.setString(48,concentradores.getPorta31());
		stmt.setString(49,concentradores.getPorta32());
		stmt.setString(50,concentradores.getPorta33());
		stmt.setString(51,concentradores.getPorta34());
		stmt.setString(52,concentradores.getPorta35());
		stmt.setString(53,concentradores.getPorta36());
		stmt.setString(54,concentradores.getPorta37());
		stmt.setString(55,concentradores.getPorta38());
		stmt.setString(56,concentradores.getPorta39());
		stmt.setString(57,concentradores.getPorta40());
		stmt.setLong(58,concentradores.getId_concentradores());


		stmt.execute();

		stmt.close();

	}
	
	public Concentradores buscaPorId(long id) throws SQLException{
				
		String sql = "SELECT "
				+" id_concentradores"
				+ ",codigo"
				+ ",descricao"
				+ ",porta1"
				+ ",porta2"
				+ ",porta3"
				+ ",porta4"
				+ ",porta5"
				+ ",porta6"
				+ ",porta7"
				+ ",porta8"
				+ ",porta9"
				+ ",portaa"
				+ ",portaip"
				+ ",atualizador"
				+ ",d_h_atualizacao"
				+ ",ativo"
				+ ",usasincronismo"
				+ ",porta01"
				+ ",porta02"
				+ ",porta03"
				+ ",porta04"
				+ ",porta05"
				+ ",porta06"
				+ ",porta07"
				+ ",porta08"
				+ ",porta09"
				+ ",porta10"
				+ ",porta11"
				+ ",porta12"
				+ ",porta13"
				+ ",porta14"
				+ ",porta15"
				+ ",porta16"
				+ ",porta17"
				+ ",porta18"
				+ ",porta19"
				+ ",porta20"
				+ ",porta21"
				+ ",porta22"
				+ ",porta23"
				+ ",porta24"
				+ ",porta25"
				+ ",porta26"
				+ ",porta27"
				+ ",porta28"
				+ ",porta29"
				+ ",porta30"
				+ ",porta31"
				+ ",porta32"
				+ ",porta33"
				+ ",porta34"
				+ ",porta35"
				+ ",porta36"
				+ ",porta37"
				+ ",porta38"
				+ ",porta39"
				+ ",porta40"
				+ " FROM gera_concentradores"
				+ " WHERE id_concentradores = ?";
		PreparedStatement stmt = this.connection
				.prepareStatement(sql);
		stmt.setLong(1, id);

		ResultSet rs = stmt.executeQuery();
		Concentradores concentradores = null;
		if (rs.next()) {
			concentradores = popula(rs);
		}

		rs.close();
		stmt.close();

		return concentradores;
	}
	
	public Concentradores popula(ResultSet rs) throws SQLException{
		Concentradores concentradores = new Concentradores();

		concentradores.setId_concentradores(rs.getLong("id_concentradores"));
		concentradores.setCodigo(rs.getString("codigo"));
		concentradores.setDescricao(rs.getString("descricao"));
		concentradores.setPorta1(rs.getString("porta1"));
		concentradores.setPorta2(rs.getString("porta2"));
		concentradores.setPorta3(rs.getString("porta3"));
		concentradores.setPorta4(rs.getString("porta4"));
		concentradores.setPorta5(rs.getString("porta5"));
		concentradores.setPorta6(rs.getString("porta6"));
		concentradores.setPorta7(rs.getString("porta7"));
		concentradores.setPorta8(rs.getString("porta8"));
		concentradores.setPorta9(rs.getString("porta9"));
		concentradores.setPortaa(rs.getString("portaa"));
		concentradores.setPortaip(rs.getString("portaip"));
		concentradores.setAtualizador(rs.getString("atualizador"));
		concentradores.setD_h_atualizacao(rs.getTimestamp("d_h_atualizacao"));
		concentradores.setAtivo(rs.getBoolean("ativo"));
		concentradores.setUsasincronismo(rs.getBoolean("usasincronismo"));
		concentradores.setPorta01(rs.getString("porta01"));
		concentradores.setPorta02(rs.getString("porta02"));
		concentradores.setPorta03(rs.getString("porta03"));
		concentradores.setPorta04(rs.getString("porta04"));
		concentradores.setPorta05(rs.getString("porta05"));
		concentradores.setPorta06(rs.getString("porta06"));
		concentradores.setPorta07(rs.getString("porta07"));
		concentradores.setPorta08(rs.getString("porta08"));
		concentradores.setPorta09(rs.getString("porta09"));
		concentradores.setPorta10(rs.getString("porta10"));
		concentradores.setPorta11(rs.getString("porta11"));
		concentradores.setPorta12(rs.getString("porta12"));
		concentradores.setPorta13(rs.getString("porta13"));
		concentradores.setPorta14(rs.getString("porta14"));
		concentradores.setPorta15(rs.getString("porta15"));
		concentradores.setPorta16(rs.getString("porta16"));
		concentradores.setPorta17(rs.getString("porta17"));
		concentradores.setPorta18(rs.getString("porta18"));
		concentradores.setPorta19(rs.getString("porta19"));
		concentradores.setPorta20(rs.getString("porta20"));
		concentradores.setPorta21(rs.getString("porta21"));
		concentradores.setPorta22(rs.getString("porta22"));
		concentradores.setPorta23(rs.getString("porta23"));
		concentradores.setPorta24(rs.getString("porta24"));
		concentradores.setPorta25(rs.getString("porta25"));
		concentradores.setPorta26(rs.getString("porta26"));
		concentradores.setPorta27(rs.getString("porta27"));
		concentradores.setPorta28(rs.getString("porta28"));
		concentradores.setPorta29(rs.getString("porta29"));
		concentradores.setPorta30(rs.getString("porta30"));
		concentradores.setPorta31(rs.getString("porta31"));
		concentradores.setPorta32(rs.getString("porta32"));
		concentradores.setPorta33(rs.getString("porta33"));
		concentradores.setPorta34(rs.getString("porta34"));
		concentradores.setPorta35(rs.getString("porta35"));
		concentradores.setPorta36(rs.getString("porta36"));
		concentradores.setPorta37(rs.getString("porta37"));
		concentradores.setPorta38(rs.getString("porta38"));
		concentradores.setPorta39(rs.getString("porta39"));
		concentradores.setPorta40(rs.getString("porta40"));

		return concentradores;
	}

	public List<Concentradores> lista() {
		try {
			List<Concentradores> lista = new ArrayList<Concentradores>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from gera_concentradores");

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
