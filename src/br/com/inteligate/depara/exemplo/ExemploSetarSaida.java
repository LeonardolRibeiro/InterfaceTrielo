package br.com.inteligate.depara.exemplo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dados.Usuarios;
import br.com.inteligate.depara.dados.Visitantes;
import br.com.inteligate.depara.dao.ConfiguracoesDao;
import br.com.inteligate.depara.dao.EmpresasDao;
import br.com.inteligate.depara.dao.NiveisDao;
import br.com.inteligate.depara.dao.TipoSalarialDao;
import br.com.inteligate.depara.dao.TransBe2Dao;
import br.com.inteligate.depara.dao.UnidadeRemotaDao;
import br.com.inteligate.depara.dao.UsuarioDao;
import br.com.inteligate.depara.dao.VisitantesDao;

public class ExemploSetarSaida {


	static int tamanhoMatricula  = 14;
	public static void main(String[] args) throws SQLException, Exception {

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		ExemploSetarSaida exemploSetarSaida = new ExemploSetarSaida();
		String tl1= "000"; String tl2= "000"; String tl3= "000"; 
		String tbz= "000"; 
		String tr1= "000"; String tr2= "000"; String tr3= "000"; String tr4= "000"; 
		String ts1= "000"; String ts2= "000"; String ts3= "000"; String ts4= "000"; String ts5= "000"; String ts6= "000"; String ts7= "000"; String ts8= "000"; 
		String id= "00"; String im= "00";

		tr1="020"; // 2 segundos
		tr1="030"; // 3 segundos
		String ipControladora ="192.168.141.141";
		
	/*	String bracoQueCai = "0";
		
		
		exemploSetarSaida.setarReles(ipControladora, tr1,tr2,tr3,tr4,bracoQueCai);*/
		
		tl1 = "010";
		tl2 = "025";
		
		exemploSetarSaida.setarSaidaDiretoControladora(ipControladora, tl1,tl2,tl3,tbz,tr1,tr2,tr3,tr4,ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8,id,im);



	}

	/*
	 * TR1 TR2 TR3 TR4  -rele 1,2,3,4
	 * tempo em 100ms. (String 3) Exemplo "005" => meio segundo
	 * bracoQueCai 0 ou 1
	 */
	public void setarReles(String ip, 
			String TR1, String TR2, String TR3, String TR4, String bracoQueCai) throws SQLException{

		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();


		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;

		String comando ="E";
		java.util.Date data = new java.util.Date();


		String complemento = null;
		String concentrador = "01";
		UnidadeRemota unidadeRemota = null;

		unidadeRemota = unidadeRemotaDao.buscaPorIp(ip);
		complemento = null;
		complemento = TR1 + TR2 + TR3 + TR4;

		String tempo = TR1;
		if(tempo.equals("000")){
			tempo = TR2;
		}
		if(tempo.equals("000")){
			tempo = TR3;
		}
		if(tempo.equals("000")){
			tempo = TR4;
		}

		complemento = complemento + "A" + tempo + bracoQueCai;

		transBe2 = new TransBe2();

		transBe2.setIp(ip);
		transBe2.setTipo(comando);
		transBe2.setData(data);
		transBe2.setCracha("00000000000000");
		transBe2.setTransmitido("1");
		transBe2.setConcentrador(concentrador);
		transBe2.setComplemento(complemento);
		transBe2.setD_h_atualizacao(new java.util.Date());

		transBe2Dao.adiciona2(transBe2);

		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();
	}


	/*
	 * TL1 TL2 TL3 -led 1,2,3
	 * TBZ -buzzer
	 * TR1 TR2 TR3 TR4  -rele 1,2,3,4
	 * TS1 TS2 TS3 TS4 TS5 TS6 TS7 TS8 -saida 1,2,3,4,5,6,7,8
	 * todos acima, tempo em 100ms. (String 3) Exemplo "005" => meio segundo
	 * ID -id do display (string 2)
	 * IM -id da mensagem padrao (string 2)
	 */
	public void setarSaidaDiretoControladora(String ip, String TL1, String TL2, String TL3, 
			String TBZ, 
			String TR1, String TR2, String TR3, String TR4, 
			String TS1, String TS2, String TS3, String TS4, String TS5, String TS6, String TS7, String TS8, 
			String ID, String IM) throws SQLException, IOException{

		
		
		int porta = 66;

		InetAddress IPAddress = InetAddress.getByName(ip);

		byte[] sendData = new byte[1024];
		
		// "$ACITL1TL2TL3TBZTR1TR2TR3TR4TS1TS2TS3TS4TS5TS6TS7TS8IDIM#";
		
		String sentence = "$ACI"+TL1+TL2+TL3+TBZ+TR1+TR2+TR3+TR4+TS1+TS2+TS3+TS4+TS5+TS6+TS7+TS8+ID+IM+"#";
		
		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();

		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, porta);
		
		DatagramSocket clientSocket = new DatagramSocket();

		clientSocket.send(sendPacket);
		System.out
				.println("Enviado pacote UDP para " + ip + ":" + porta);

		clientSocket.close();

		
	}

	public ExemploSetarSaida() {

	}

}
