package br.com.inteligate.depara.exemplo;

import java.sql.SQLException;
import java.util.List;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Concentradores;
import br.com.inteligate.depara.dados.TransBe2;
import br.com.inteligate.depara.dados.UnidadeRemota;
import br.com.inteligate.depara.dao.ConcentradoresDao;
import br.com.inteligate.depara.dao.TransBe2Dao;
import br.com.inteligate.depara.dao.UnidadeRemotaDao;

public class ExemploUnidadesRemotas {

	public ExemploUnidadesRemotas() {

	}

	public static void main(String[] args) throws SQLException {
		ExemploUnidadesRemotas exemploUnidadesRemotas = new ExemploUnidadesRemotas();
		exemploUnidadesRemotas.enviaConfiguracao();
	}
	
	public void incluirAlterar() throws SQLException {

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");
		
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		ConcentradoresDao concentradoresDao = new ConcentradoresDao();

		//Codigo - nome do campo na tela
		String codigo = "01";

		//Concentrador
		long id_concentrador = 1;
		Concentradores concentradores = concentradoresDao.buscaPorId(id_concentrador);
		String concentrador = concentradores.getCodigo();

		//Porta
		String porta = "1";

		//Tipo Ip(IP), (RP), (BE), Trix(XT), Hand Key(HK)
		String tipo = "IP";

		//Descricao
		String descricao = "UR 001";

		//desativado
		boolean desativado = false;

		//Ip
		String ip = "192.168.141.142";

		//Chave Acesso Cracha(C) Matricula(M) RFID(R)
		String chaveacesso = "C";

		//Display
		String titulo = "Bem vindo";

		//Modelo 4A-Access 4S-TurnStyle 4D-Door 4G-Generic 4T-Time&Clock< ID-REP-IDdata DG-REP-Digicom XT-Compact
		//FL-Flip BE-Benet B2-Benet2
		String modelo = "4A";

		//Desabilita Visitante Entrada(E) Saida(S) Não(N)
		String desabilitavis = "N";

		//Descricao leitora 1
		String descricaoleitora1 = "Entrada";

		//Sentido da Leitora 1 Entrada(E) Saida(S) Indefinido(X)
		String sentidol1 = "E";

		/*Tipo
"0" (desabilitado)
"1" 1-WIEGAND
"2" 2-CLOCK & DATA
"3" 3-MIFARE (ACURA)
"4" 4-MIFARE (INELTEC)
"5" 5-COD.BARRAS
"6" 6-TECLADO (ACCURA)
"7" 7-NEDAP TAGA
"8" 8-TAG (ACURA)
"9" 9-HID LEITOR TECLADO
"11" 11-MIFARE (TETRAPAK)
"12" 12-COD.BARRAS (CENESP)
"13" 13-MIFARE (CENESP)
"14" 14-MIFARE (TJBA)
"15" 15-MIFARE (POA)
"17" 17-MIFARE (OGMO)
"18" 18-HID Teclado
"19" 19-MIFARE (RODRIMAR)
"20" 20-COD.BARRAS c/Validade
"23" 23-MIFARE (TRIELO-DP)
"24" 24-TM-10
"25" 25-COD.BARRAS(Bradesco) */
		String tipo_leitora1 = "24";

		String descricaoleitora2 = "Saida";
		String sentidol2 = "S";
		String tipo_leitora2 = "24";

		String descricaoleitora3 = null;
		String sentidol3 = "X";
		String tipo_leitora3 = "0";

		//Possui Display
		boolean possui_display = true;

		//TimeZone local 
		/*
"America/Rio_Branco" UTC-5 
"America/Manaus" UTC-4 
"America/Cuiaba" UTC-4, H.V. 
"America/Belem" selected="selected" UTC-3 
"America/Sao_Paulo" UTC-3, H.V. 
"America/Noronha" UTC-2
		 */
		String tz_dls = "America/Belem";

		//Usar Finger Sim(S) Não(N)
		String usafinger = "N";

		//Dupla autorização Sim(S) Não(N)
		String duplavalida = "N";

		// tipo Biometria 
		/*
"0" 1:1
"1" 1:N no módulo
"2" 1:N no servidor
"3" 1:N Hibrido
		 */
		int tipo_biometria = 0;

		// Tipo Controle 
		/*
"PT" Porta
"CT" Catraca
"CTD" Catraca Digicon
"CTW" Catraca Western
"CT4" Catraca 4 Braços
"CC" Cancela
"TR" Torniquete
"AL" Alarme
"CH" Sacolas 
		 */
		String tipocontrole = "PT";

		//Tratamento de Senhas
		/*
"0" - sem digitação
"1" 1 - apenas senha 
"2" 2 - apenas cracha; 
"3" 3 - cracha + senha 
"4" 4 - cracha ou senha
		 */
		String tratasenha = "0";

		//Tamanho da Informação Digitada
		int tamanhodigitado = 0;

		//Tempo Relês
		int tempoacionamento = 0;

		//Modo Relês Independente(1)  Simultâneo(2)
		String acionarele = null;

		//Tempo Porta Aberta
		Integer tempotimeoutportaaberta = null;

		//Empresa
		long id_empresa = 1;

		//Código do Local
		String cod_local = "000REC";

		//Site
		long id_site = 1;

		//TEA
		int tea = 0;

		//TSP
		int tsp = 0;

		//TEA(folga)
		int iar = 0;

		//TSP(folga)
		int ipr = 0;

		//AEA
		int aea = 0;

		//ASP
		int asp = 0;

		//Usar Handkey  Sim(S) Não(N)
		String usahk = "N";

		//Controla Fluxo Sim(S) Não(N)
		String fluxo = "N";

		//Turbo Ligado   Sim(S) Não(N)
		String turbo = "N";

		//Trata Cofre Visitante   Sim(S) Não(N)
		String cofre = "N";

		//Ponto Eletrônico Sim(S) Não(N)
		String ponto = "N";

		//Saída Visitante Sem Cofre  
		boolean libera_saida_vis = false;

		//"Stand Alone"  Sim(S) Não(N)
		String standalone = "N";

		//Desabilita Visitante  Sim(S) Não(N)
		String desabilitavisitante = "N";

		//Modo Automático  Sim(S) Não(N)
		String automatico = "N";

		//Controla Dupla Passagem 
		boolean controladuplapassagem = false;

		//Grava Transações Sim(S) Não(N)
		String gravatrans = "S";

		//Controla Antipassback Sim(S) Não(N)
		String antipassback = "N";

		//Necessita Confirmação    
		boolean necessita_confirmacao = false;

		//Sair depois Hora 
		boolean podesairdepoishora = true;

		//Hora p/ Escala
		boolean verhoraescala = false;

		//Checa Interjornada 
		boolean verinterj = false;

		//Checa DSR 
		boolean verdsr = false;

		//Hora Refeicao 
		boolean verhorrefe = false;

		//Dupla Refeicao 
		boolean verduplarefe = false;

		//Interv. Refeicao  
		boolean verultrefe = false;

		//Restaurante  Sim(S) Não(N)
		String restaurante = "N";

		//Controle de Vagas  
		String controlevagas = "0";

		//Fitness (Paineiras)  
		boolean paineirasfitness = false;

		UnidadeRemota unidadeRemota = unidadeRemotaDao.buscaPorCodigo(codigo);

		if(unidadeRemota!=null){
			System.out.println("Unidade Remota já cadastrado será alterado, Chave:" +unidadeRemota.getId_unidadesremotas());
		}else{
			unidadeRemota = new UnidadeRemota();
		}
		unidadeRemota.setCodigo(codigo);
		unidadeRemota.setDescricao(descricao);
		unidadeRemota.setId_concentrador(id_concentrador);
		unidadeRemota.setConcentrador(concentrador);
		unidadeRemota.setPorta(porta);
		unidadeRemota.setTipo(tipo);
		unidadeRemota.setDesativado(desativado);
		unidadeRemota.setIp(ip);
		unidadeRemota.setChaveacesso(chaveacesso);
		unidadeRemota.setTitulo(titulo);
		unidadeRemota.setModelo(modelo);
		unidadeRemota.setDesabilitavis(desabilitavis);
		unidadeRemota.setDescricaoleitora1(descricaoleitora1);
		unidadeRemota.setSentidol1(sentidol1);
		unidadeRemota.setTipo_leitora1(tipo_leitora1);
		unidadeRemota.setDescricaoleitora2(descricaoleitora2);
		unidadeRemota.setSentidol2(sentidol2);
		unidadeRemota.setTipo_leitora2(tipo_leitora2);
		unidadeRemota.setDescricaoleitora3(descricaoleitora3);
		unidadeRemota.setSentidol3(sentidol3);
		unidadeRemota.setTipo_leitora3(tipo_leitora3);
		unidadeRemota.setPossui_display(possui_display);
		unidadeRemota.setTz_dls(tz_dls);
		unidadeRemota.setDuplavalida(duplavalida);
		unidadeRemota.setUsafinger(usafinger);
		unidadeRemota.setTipocontrole(tipocontrole);
		unidadeRemota.setTratasenha(tratasenha);
		unidadeRemota.setTamanhodigitado(tamanhodigitado);
		unidadeRemota.setTempoacionamento(tempoacionamento);
		unidadeRemota.setAcionarele(acionarele);
		unidadeRemota.setTempotimeoutportaaberta(tempotimeoutportaaberta);
		unidadeRemota.setCod_local(cod_local);
		unidadeRemota.setId_empresa(id_empresa);
		unidadeRemota.setId_site(id_site);
		unidadeRemota.setTea(tea);
		unidadeRemota.setTsp(tsp);
		unidadeRemota.setIar(iar);
		unidadeRemota.setIpr(ipr);
		unidadeRemota.setAea(aea);
		unidadeRemota.setAsp(asp);
		unidadeRemota.setUsahk(usahk);
		unidadeRemota.setFluxo(fluxo);
		unidadeRemota.setTurbo(turbo);
		unidadeRemota.setCofre(cofre);
		unidadeRemota.setPonto(ponto);
		unidadeRemota.setLibera_saida_vis(libera_saida_vis);
		unidadeRemota.setStandalone(standalone);
		unidadeRemota.setDesabilitavisitante(desabilitavisitante);
		unidadeRemota.setDesabilitavis(desabilitavis);
		unidadeRemota.setTipo_biometria(tipo_biometria);
		unidadeRemota.setAutomatico(automatico);
		unidadeRemota.setGravatrans(gravatrans);
		unidadeRemota.setControladuplapassagem(controladuplapassagem);
		unidadeRemota.setAntipassback(antipassback);
		unidadeRemota.setNecessita_confirmacao(necessita_confirmacao);
		unidadeRemota.setPodesairdepoishora(podesairdepoishora);
		unidadeRemota.setVerhoraescala(verhoraescala);
		unidadeRemota.setVerinterj(verinterj);
		unidadeRemota.setVerdsr(verdsr);
		unidadeRemota.setVerhorrefe(verhorrefe);
		unidadeRemota.setVerduplarefe(verduplarefe);
		unidadeRemota.setVerultrefe(verultrefe);
		unidadeRemota.setRestaurante(restaurante);
		unidadeRemota.setControlevagas(controlevagas);
		unidadeRemota.setPaineirasfitness(paineirasfitness);

		if(unidadeRemota.getId_unidadesremotas()==null){
			long chave = unidadeRemotaDao.adiciona(unidadeRemota);
			System.out.println("Unidade Remota adicionado, Chave:" +chave);
		}else{
			unidadeRemotaDao.altera(unidadeRemota);
			System.out.println("Unidade Remota alterado, Chave:" +unidadeRemota.getId_unidadesremotas());
		}


		unidadeRemotaDao.finalize();
		concentradoresDao.finalize();
	}
	
	
public void enviaConfiguracao() throws SQLException{
		
		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");

		TransBe2Dao transBe2Dao = new TransBe2Dao();
		UnidadeRemotaDao unidadeRemotaDao = new UnidadeRemotaDao();
		
	
		// inclui transmissao
		List<String> listaIps = unidadeRemotaDao.listaIpAtivos();
		TransBe2 transBe2 = null;
		
		String comando ="N";
		java.util.Date data = new java.util.Date();
		

		String complemento = null;
		String concentrador = "01";
		UnidadeRemota unidadeRemota = null;
		
		for(int i=0;i<listaIps.size();i++){
			
			unidadeRemota = unidadeRemotaDao.buscaPorIp(listaIps.get(i));
			complemento = null;
			
			transBe2 = new TransBe2();

			transBe2.setIp(listaIps.get(i));
			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha("99999999999999");
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(unidadeRemota.getCodigo());
			transBe2Dao.adiciona2(transBe2);
			
			comando ="A";
			transBe2 = new TransBe2();

			transBe2.setIp(listaIps.get(i));
			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha("99999999999999");
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(unidadeRemota.getCodigo());
			transBe2Dao.adiciona2(transBe2);
			
			comando ="M";
			transBe2 = new TransBe2();

			transBe2.setIp(listaIps.get(i));
			transBe2.setTipo(comando);
			transBe2.setData(data);
			transBe2.setCracha("99999999999999");
			transBe2.setTransmitido("1");
			transBe2.setConcentrador(concentrador);
			transBe2.setComplemento(complemento);
			transBe2.setD_h_atualizacao(new java.util.Date());
			transBe2.setOcorrencia(0);
			transBe2.setProgresso(0);
			transBe2.setPorta(unidadeRemota.getPorta());
			transBe2.setColetor(unidadeRemota.getCodigo());
			transBe2Dao.adiciona2(transBe2);
		}
		

		transBe2Dao.finalize();
		unidadeRemotaDao.finalize();

		
	}


}
