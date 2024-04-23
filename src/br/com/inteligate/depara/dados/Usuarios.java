package br.com.inteligate.depara.dados;

public class Usuarios {

	private Long id_usuarios;
	private String matricula;
	private String cracha;
	private String versao;
	private String nomecompleto;
	private String nomeabreviado;
	private Long id_empresa;
	private String empresa;
	private Long id_classificacao;
	private String classificacao;
	private Long id_centroderesponsabilidade;
	private String centroderesponsabilidade;
	private Long id_gera_niveis;
	private String nivel;
	private String permissaoacesso;
	private String identidade;
	private String senha;
	private String veiculo;
	private String placa;
	private String motivo;
	private java.util.Date iniciovalidade;
	private java.util.Date fimvalidade;
	private String contrato;
	private String tipo;
	private String email;
	private String hktemplate;
	private int hkautoridade;
	private int hkrejeicao;
	private java.util.Date dtliberaref;
	private int qtdrefeicoesaodia;
	private int qtdrefusadas;
	private java.util.Date validadepa;
	private String unidadespermitidas;
	private int horariomovel;
	private Long id_tiposalarial;
	private String tiposal;
	private String atualizador;
	private java.util.Date d_h_atualizacao;
	private String imprimiretiqueta;
	private String cpf;
	private String codareafone1;
	private String fone1;
	private String codareafone2;
	private String fone2;
	private String endereco;
	private String tiposanguineo;
	private String grpduplaut;
	private String finger1;
	private String finger2;
	private String nivel_ant;
	private Long id_nivel_ant;
	private String mat_chefia;
	private String cod_site;
	private String hierarquia;
	private String controlafluxo;
	private boolean libera_biometria;
	private String ultimolocal;
	private String ultimarefe;
	private String ultimadtlocal;
	private boolean podevariasrefe;
	private boolean podeusarrefe;
	private boolean tem_valetrans;
	private boolean tem_valerefe;
	private String ultimoponto;
	private String refe_beneficio;
	private java.util.Date refe_val_ate;
	private java.util.Date dt_integracao;
	private java.util.Date dt_inireserva;
	private java.util.Date dt_fimreserva;
	private java.util.Date dt_venccnh;
	private boolean motorista_aut;
	private String classe_seguranca;
	private String mat_motorista;
	private String descveiculo;
	private String corveiculo;
	private String nr_renavan;
	private String nr_cnh;
	private String cracha_original;
	private String jornada;
	private String permissaoesquecimento;
	private Long idsite;
	private String finger3;
	private String finger4;
	private String finger21;
	private String finger22;
	private String finger23;
	private String finger24;
	private boolean liberaduplapassagem;
	private Long andar_id_andar;
	private java.util.Date data_aniversario;
	private String ramal;
	private java.util.Date dt_primeiro_provisorio;
	private int idedo;
	private int imao;
	private String id_cracha;
	private Long pis;
	private boolean liberarep;
	private boolean envialista;
	private Integer numero_provisorio;
	private java.util.Date dtadmterceiro;
	private java.util.Date dtdemterceiro;
	private String codfaixa;
	private String requmat;
	private String respnome;
	private String respemail;
	private String respfone;
	private String atividade;
	private java.util.Date  asovalidade;
	private boolean homologacaogt;
	private String tpprestacao;
	private String servicoprestado;
	private String periodicidadetrab;
	private String diassemana;
	private boolean faltadoc;
	private String docfaltante;
	private String ctps;
	private String cargo;
	private String cod_barras;
	private String motivobaixa;
	private Long id_local_visita;
	private Long id_categoria;
	private Long id_visitado;
	private java.util.Date hracessando;
	private java.util.Date dt_inativo;
	private java.util.Date venc_nr10;
	private java.util.Date venc_nr35;
	private boolean participacipa;
	private boolean nr10;
	private boolean nr35;
	private String acessando;
	private boolean verhoraescala;
	private boolean nr11;
	private boolean nr18;
	private boolean nr06;
	private boolean nr33;
	private java.util.Date venc_nr11;
	private java.util.Date venc_nr18;
	private java.util.Date venc_nr06;
	private java.util.Date venc_nr33;
	private String opcao_nr11;
	private String opcao_nr18;
	private String sexo;
	private Integer deficiente;
	private boolean tem_pendencia;
	private boolean acesso_fit; 
	private boolean exibir_mensagem; 
	private String mensagem_display;
	private int totalhorasjornada;
	private boolean verificainterjornada; 
	private java.util.Date primeiraentradaij;
	private boolean listanegra;
	private java.util.Date ultimoduplapassagem;
	private String seg_nv_vis;
	private int utiliza_complemento;
	private Long id_tipo_usuario;
	private int entrada_porto;
	private int saida_porto;
	private String tp_operacao;
	private int idcatrefe;
	private int verifica_credito_empresa;
	private java.util.Date venc_treina_admi;
	private java.util.Date venc_treina_espec;
	private java.util.Date venc_treina_perio;
	private java.util.Date venc_epi;
	private java.util.Date venc_ficha_registro;
	private java.util.Date venc_rg;
	private java.util.Date venc_cpf;
	private java.util.Date venc_exames_compl;
	private java.util.Date venc_pcmat;
	private java.util.Date venc_pcmso;
	private java.util.Date venc_carteira_trab;
	private int ehbrigadista;
	private java.util.Date ultimarefesec;
	private java.util.Date ultimarefepri;
	private String numcartaoestacionamento;
	private String veiculo2;
	private String placa2;
	private String corveiculo2;
	private boolean visitante_especial;
	public Long getId_usuarios() {
		return id_usuarios;
	}
	public void setId_usuarios(Long id_usuarios) {
		this.id_usuarios = id_usuarios;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCracha() {
		return cracha;
	}
	public void setCracha(String cracha) {
		this.cracha = cracha;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getNomecompleto() {
		return nomecompleto;
	}
	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}
	public String getNomeabreviado() {
		return nomeabreviado;
	}
	public void setNomeabreviado(String nomeabreviado) {
		this.nomeabreviado = nomeabreviado;
	}
	public Long getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Long getId_classificacao() {
		return id_classificacao;
	}
	public void setId_classificacao(Long id_classificacao) {
		this.id_classificacao = id_classificacao;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public Long getId_centroderesponsabilidade() {
		return id_centroderesponsabilidade;
	}
	public void setId_centroderesponsabilidade(Long id_centroderesponsabilidade) {
		this.id_centroderesponsabilidade = id_centroderesponsabilidade;
	}
	public String getCentroderesponsabilidade() {
		return centroderesponsabilidade;
	}
	public void setCentroderesponsabilidade(String centroderesponsabilidade) {
		this.centroderesponsabilidade = centroderesponsabilidade;
	}
	public Long getId_gera_niveis() {
		return id_gera_niveis;
	}
	public void setId_gera_niveis(Long id_gera_niveis) {
		this.id_gera_niveis = id_gera_niveis;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getPermissaoacesso() {
		return permissaoacesso;
	}
	public void setPermissaoacesso(String permissaoacesso) {
		this.permissaoacesso = permissaoacesso;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public java.util.Date getIniciovalidade() {
		return iniciovalidade;
	}
	public void setIniciovalidade(java.util.Date iniciovalidade) {
		this.iniciovalidade = iniciovalidade;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHktemplate() {
		return hktemplate;
	}
	public void setHktemplate(String hktemplate) {
		this.hktemplate = hktemplate;
	}
	public int getHkautoridade() {
		return hkautoridade;
	}
	public void setHkautoridade(int hkautoridade) {
		this.hkautoridade = hkautoridade;
	}
	public int getHkrejeicao() {
		return hkrejeicao;
	}
	public void setHkrejeicao(int hkrejeicao) {
		this.hkrejeicao = hkrejeicao;
	}
	public java.util.Date getDtliberaref() {
		return dtliberaref;
	}
	public void setDtliberaref(java.util.Date dtliberaref) {
		this.dtliberaref = dtliberaref;
	}
	public int getQtdrefeicoesaodia() {
		return qtdrefeicoesaodia;
	}
	public void setQtdrefeicoesaodia(int qtdrefeicoesaodia) {
		this.qtdrefeicoesaodia = qtdrefeicoesaodia;
	}
	public int getQtdrefusadas() {
		return qtdrefusadas;
	}
	public void setQtdrefusadas(int qtdrefusadas) {
		this.qtdrefusadas = qtdrefusadas;
	}
	public String getUnidadespermitidas() {
		return unidadespermitidas;
	}
	public void setUnidadespermitidas(String unidadespermitidas) {
		this.unidadespermitidas = unidadespermitidas;
	}
	public int getHorariomovel() {
		return horariomovel;
	}
	public void setHorariomovel(int horariomovel) {
		this.horariomovel = horariomovel;
	}
	public Long getId_tiposalarial() {
		return id_tiposalarial;
	}
	public void setId_tiposalarial(Long id_tiposalarial) {
		this.id_tiposalarial = id_tiposalarial;
	}
	public String getTiposal() {
		return tiposal;
	}
	public void setTiposal(String tiposal) {
		this.tiposal = tiposal;
	}
	public String getAtualizador() {
		return atualizador;
	}
	public void setAtualizador(String atualizador) {
		this.atualizador = atualizador;
	}
	public String getImprimiretiqueta() {
		return imprimiretiqueta;
	}
	public void setImprimiretiqueta(String imprimiretiqueta) {
		this.imprimiretiqueta = imprimiretiqueta;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCodareafone1() {
		return codareafone1;
	}
	public void setCodareafone1(String codareafone1) {
		this.codareafone1 = codareafone1;
	}
	public String getFone1() {
		return fone1;
	}
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}
	public String getCodareafone2() {
		return codareafone2;
	}
	public void setCodareafone2(String codareafone2) {
		this.codareafone2 = codareafone2;
	}
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTiposanguineo() {
		return tiposanguineo;
	}
	public void setTiposanguineo(String tiposanguineo) {
		this.tiposanguineo = tiposanguineo;
	}
	public String getGrpduplaut() {
		return grpduplaut;
	}
	public void setGrpduplaut(String grpduplaut) {
		this.grpduplaut = grpduplaut;
	}
	public String getFinger1() {
		return finger1;
	}
	public void setFinger1(String finger1) {
		this.finger1 = finger1;
	}
	public String getFinger2() {
		return finger2;
	}
	public void setFinger2(String finger2) {
		this.finger2 = finger2;
	}
	public String getNivel_ant() {
		return nivel_ant;
	}
	public void setNivel_ant(String nivel_ant) {
		this.nivel_ant = nivel_ant;
	}
	public Long getId_nivel_ant() {
		return id_nivel_ant;
	}
	public void setId_nivel_ant(Long id_nivel_ant) {
		this.id_nivel_ant = id_nivel_ant;
	}
	public String getMat_chefia() {
		return mat_chefia;
	}
	public void setMat_chefia(String mat_chefia) {
		this.mat_chefia = mat_chefia;
	}
	public String getCod_site() {
		return cod_site;
	}
	public void setCod_site(String cod_site) {
		this.cod_site = cod_site;
	}
	public String getHierarquia() {
		return hierarquia;
	}
	public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}
	public String getControlafluxo() {
		return controlafluxo;
	}
	public void setControlafluxo(String controlafluxo) {
		this.controlafluxo = controlafluxo;
	}
	public boolean isLibera_biometria() {
		return libera_biometria;
	}
	public void setLibera_biometria(boolean libera_biometria) {
		this.libera_biometria = libera_biometria;
	}
	public String getUltimolocal() {
		return ultimolocal;
	}
	public void setUltimolocal(String ultimolocal) {
		this.ultimolocal = ultimolocal;
	}
	public String getUltimarefe() {
		return ultimarefe;
	}
	public void setUltimarefe(String ultimarefe) {
		this.ultimarefe = ultimarefe;
	}
	public String getUltimadtlocal() {
		return ultimadtlocal;
	}
	public void setUltimadtlocal(String ultimadtlocal) {
		this.ultimadtlocal = ultimadtlocal;
	}
	public boolean isPodevariasrefe() {
		return podevariasrefe;
	}
	public void setPodevariasrefe(boolean podevariasrefe) {
		this.podevariasrefe = podevariasrefe;
	}
	public boolean isPodeusarrefe() {
		return podeusarrefe;
	}
	public void setPodeusarrefe(boolean podeusarrefe) {
		this.podeusarrefe = podeusarrefe;
	}
	public boolean isTem_valetrans() {
		return tem_valetrans;
	}
	public void setTem_valetrans(boolean tem_valetrans) {
		this.tem_valetrans = tem_valetrans;
	}
	public boolean isTem_valerefe() {
		return tem_valerefe;
	}
	public void setTem_valerefe(boolean tem_valerefe) {
		this.tem_valerefe = tem_valerefe;
	}
	public String getUltimoponto() {
		return ultimoponto;
	}
	public void setUltimoponto(String ultimoponto) {
		this.ultimoponto = ultimoponto;
	}
	public String getRefe_beneficio() {
		return refe_beneficio;
	}
	public void setRefe_beneficio(String refe_beneficio) {
		this.refe_beneficio = refe_beneficio;
	}
	
	public boolean isMotorista_aut() {
		return motorista_aut;
	}
	public void setMotorista_aut(boolean motorista_aut) {
		this.motorista_aut = motorista_aut;
	}
	public String getClasse_seguranca() {
		return classe_seguranca;
	}
	public void setClasse_seguranca(String classe_seguranca) {
		this.classe_seguranca = classe_seguranca;
	}
	public String getMat_motorista() {
		return mat_motorista;
	}
	public void setMat_motorista(String mat_motorista) {
		this.mat_motorista = mat_motorista;
	}
	public String getDescveiculo() {
		return descveiculo;
	}
	public void setDescveiculo(String descveiculo) {
		this.descveiculo = descveiculo;
	}
	public String getCorveiculo() {
		return corveiculo;
	}
	public void setCorveiculo(String corveiculo) {
		this.corveiculo = corveiculo;
	}
	public String getNr_renavan() {
		return nr_renavan;
	}
	public void setNr_renavan(String nr_renavan) {
		this.nr_renavan = nr_renavan;
	}
	public String getNr_cnh() {
		return nr_cnh;
	}
	public void setNr_cnh(String nr_cnh) {
		this.nr_cnh = nr_cnh;
	}
	public String getCracha_original() {
		return cracha_original;
	}
	public void setCracha_original(String cracha_original) {
		this.cracha_original = cracha_original;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getPermissaoesquecimento() {
		return permissaoesquecimento;
	}
	public void setPermissaoesquecimento(String permissaoesquecimento) {
		this.permissaoesquecimento = permissaoesquecimento;
	}
	public Long getIdsite() {
		return idsite;
	}
	public void setIdsite(Long idsite) {
		this.idsite = idsite;
	}
	public String getFinger3() {
		return finger3;
	}
	public void setFinger3(String finger3) {
		this.finger3 = finger3;
	}
	public String getFinger4() {
		return finger4;
	}
	public void setFinger4(String finger4) {
		this.finger4 = finger4;
	}
	public String getFinger21() {
		return finger21;
	}
	public void setFinger21(String finger21) {
		this.finger21 = finger21;
	}
	public String getFinger22() {
		return finger22;
	}
	public void setFinger22(String finger22) {
		this.finger22 = finger22;
	}
	public String getFinger23() {
		return finger23;
	}
	public void setFinger23(String finger23) {
		this.finger23 = finger23;
	}
	public String getFinger24() {
		return finger24;
	}
	public void setFinger24(String finger24) {
		this.finger24 = finger24;
	}
	public boolean isLiberaduplapassagem() {
		return liberaduplapassagem;
	}
	public void setLiberaduplapassagem(boolean liberaduplapassagem) {
		this.liberaduplapassagem = liberaduplapassagem;
	}
	public Long getAndar_id_andar() {
		return andar_id_andar;
	}
	public void setAndar_id_andar(Long andar_id_andar) {
		this.andar_id_andar = andar_id_andar;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public int getIdedo() {
		return idedo;
	}
	public void setIdedo(int idedo) {
		this.idedo = idedo;
	}
	public int getImao() {
		return imao;
	}
	public void setImao(int imao) {
		this.imao = imao;
	}
	public String getId_cracha() {
		return id_cracha;
	}
	public void setId_cracha(String id_cracha) {
		this.id_cracha = id_cracha;
	}
	public boolean isLiberarep() {
		return liberarep;
	}
	public void setLiberarep(boolean liberarep) {
		this.liberarep = liberarep;
	}
	public boolean isEnvialista() {
		return envialista;
	}
	public void setEnvialista(boolean envialista) {
		this.envialista = envialista;
	}
	public Integer getNumero_provisorio() {
		return numero_provisorio;
	}
	public void setNumero_provisorio(Integer numero_provisorio) {
		this.numero_provisorio = numero_provisorio;
	}
	public String getCodfaixa() {
		return codfaixa;
	}
	public void setCodfaixa(String codfaixa) {
		this.codfaixa = codfaixa;
	}
	public String getRequmat() {
		return requmat;
	}
	public void setRequmat(String requmat) {
		this.requmat = requmat;
	}
	public String getRespnome() {
		return respnome;
	}
	public void setRespnome(String respnome) {
		this.respnome = respnome;
	}
	public String getRespemail() {
		return respemail;
	}
	public void setRespemail(String respemail) {
		this.respemail = respemail;
	}
	public String getRespfone() {
		return respfone;
	}
	public void setRespfone(String respfone) {
		this.respfone = respfone;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public boolean isHomologacaogt() {
		return homologacaogt;
	}
	public void setHomologacaogt(boolean homologacaogt) {
		this.homologacaogt = homologacaogt;
	}
	public String getTpprestacao() {
		return tpprestacao;
	}
	public void setTpprestacao(String tpprestacao) {
		this.tpprestacao = tpprestacao;
	}
	public String getServicoprestado() {
		return servicoprestado;
	}
	public void setServicoprestado(String servicoprestado) {
		this.servicoprestado = servicoprestado;
	}
	public String getPeriodicidadetrab() {
		return periodicidadetrab;
	}
	public void setPeriodicidadetrab(String periodicidadetrab) {
		this.periodicidadetrab = periodicidadetrab;
	}
	public String getDiassemana() {
		return diassemana;
	}
	public void setDiassemana(String diassemana) {
		this.diassemana = diassemana;
	}
	public String getDocfaltante() {
		return docfaltante;
	}
	public void setDocfaltante(String docfaltante) {
		this.docfaltante = docfaltante;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}
	public String getMotivobaixa() {
		return motivobaixa;
	}
	public void setMotivobaixa(String motivobaixa) {
		this.motivobaixa = motivobaixa;
	}
	public Long getId_local_visita() {
		return id_local_visita;
	}
	public void setId_local_visita(Long id_local_visita) {
		this.id_local_visita = id_local_visita;
	}
	public Long getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}
	public Long getId_visitado() {
		return id_visitado;
	}
	public void setId_visitado(Long id_visitado) {
		this.id_visitado = id_visitado;
	}
	public java.util.Date getHracessando() {
		return hracessando;
	}
	public void setHracessando(java.util.Date hracessando) {
		this.hracessando = hracessando;
	}
	public boolean isParticipacipa() {
		return participacipa;
	}
	public void setParticipacipa(boolean participacipa) {
		this.participacipa = participacipa;
	}
	public boolean isNr10() {
		return nr10;
	}
	public void setNr10(boolean nr10) {
		this.nr10 = nr10;
	}
	public boolean isNr35() {
		return nr35;
	}
	public void setNr35(boolean nr35) {
		this.nr35 = nr35;
	}
	public String getAcessando() {
		return acessando;
	}
	public void setAcessando(String acessando) {
		this.acessando = acessando;
	}
	public boolean isVerhoraescala() {
		return verhoraescala;
	}
	public void setVerhoraescala(boolean verhoraescala) {
		this.verhoraescala = verhoraescala;
	}
	public boolean isNr11() {
		return nr11;
	}
	public void setNr11(boolean nr11) {
		this.nr11 = nr11;
	}
	public boolean isNr18() {
		return nr18;
	}
	public void setNr18(boolean nr18) {
		this.nr18 = nr18;
	}
	public boolean isNr06() {
		return nr06;
	}
	public void setNr06(boolean nr06) {
		this.nr06 = nr06;
	}
	public boolean isNr33() {
		return nr33;
	}
	public void setNr33(boolean nr33) {
		this.nr33 = nr33;
	}
	public String getOpcao_nr11() {
		return opcao_nr11;
	}
	public void setOpcao_nr11(String opcao_nr11) {
		this.opcao_nr11 = opcao_nr11;
	}
	public String getOpcao_nr18() {
		return opcao_nr18;
	}
	public void setOpcao_nr18(String opcao_nr18) {
		this.opcao_nr18 = opcao_nr18;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getDeficiente() {
		return deficiente;
	}
	public void setDeficiente(Integer deficiente) {
		this.deficiente = deficiente;
	}
	public boolean isTem_pendencia() {
		return tem_pendencia;
	}
	public void setTem_pendencia(boolean tem_pendencia) {
		this.tem_pendencia = tem_pendencia;
	}
	public boolean isAcesso_fit() {
		return acesso_fit;
	}
	public void setAcesso_fit(boolean acesso_fit) {
		this.acesso_fit = acesso_fit;
	}
	public boolean isExibir_mensagem() {
		return exibir_mensagem;
	}
	public void setExibir_mensagem(boolean exibir_mensagem) {
		this.exibir_mensagem = exibir_mensagem;
	}
	public String getMensagem_display() {
		return mensagem_display;
	}
	public void setMensagem_display(String mensagem_display) {
		this.mensagem_display = mensagem_display;
	}
	public int getTotalhorasjornada() {
		return totalhorasjornada;
	}
	public void setTotalhorasjornada(int totalhorasjornada) {
		this.totalhorasjornada = totalhorasjornada;
	}
	public boolean isVerificainterjornada() {
		return verificainterjornada;
	}
	public void setVerificainterjornada(boolean verificainterjornada) {
		this.verificainterjornada = verificainterjornada;
	}
	public boolean isListanegra() {
		return listanegra;
	}
	public void setListanegra(boolean listanegra) {
		this.listanegra = listanegra;
	}
	public String getSeg_nv_vis() {
		return seg_nv_vis;
	}
	public void setSeg_nv_vis(String seg_nv_vis) {
		this.seg_nv_vis = seg_nv_vis;
	}
	public Long getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(Long id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	public int getEntrada_porto() {
		return entrada_porto;
	}
	public void setEntrada_porto(int entrada_porto) {
		this.entrada_porto = entrada_porto;
	}
	public int getSaida_porto() {
		return saida_porto;
	}
	public void setSaida_porto(int saida_porto) {
		this.saida_porto = saida_porto;
	}
	public String getTp_operacao() {
		return tp_operacao;
	}
	public void setTp_operacao(String tp_operacao) {
		this.tp_operacao = tp_operacao;
	}
	public int getIdcatrefe() {
		return idcatrefe;
	}
	public void setIdcatrefe(int idcatrefe) {
		this.idcatrefe = idcatrefe;
	}
	public int getVerifica_credito_empresa() {
		return verifica_credito_empresa;
	}
	public void setVerifica_credito_empresa(int verifica_credito_empresa) {
		this.verifica_credito_empresa = verifica_credito_empresa;
	}
	public java.util.Date getFimvalidade() {
		return fimvalidade;
	}
	public void setFimvalidade(java.util.Date fimvalidade) {
		this.fimvalidade = fimvalidade;
	}
	public java.util.Date getValidadepa() {
		return validadepa;
	}
	public void setValidadepa(java.util.Date validadepa) {
		this.validadepa = validadepa;
	}
	public java.util.Date getD_h_atualizacao() {
		return d_h_atualizacao;
	}
	public void setD_h_atualizacao(java.util.Date d_h_atualizacao) {
		this.d_h_atualizacao = d_h_atualizacao;
	}
	public java.util.Date getRefe_val_ate() {
		return refe_val_ate;
	}
	public void setRefe_val_ate(java.util.Date refe_val_ate) {
		this.refe_val_ate = refe_val_ate;
	}
	public java.util.Date getDt_integracao() {
		return dt_integracao;
	}
	public void setDt_integracao(java.util.Date dt_integracao) {
		this.dt_integracao = dt_integracao;
	}
	public java.util.Date getDt_inireserva() {
		return dt_inireserva;
	}
	public void setDt_inireserva(java.util.Date dt_inireserva) {
		this.dt_inireserva = dt_inireserva;
	}
	public java.util.Date getDt_fimreserva() {
		return dt_fimreserva;
	}
	public void setDt_fimreserva(java.util.Date dt_fimreserva) {
		this.dt_fimreserva = dt_fimreserva;
	}
	public java.util.Date getDt_venccnh() {
		return dt_venccnh;
	}
	public void setDt_venccnh(java.util.Date dt_venccnh) {
		this.dt_venccnh = dt_venccnh;
	}
	public java.util.Date getData_aniversario() {
		return data_aniversario;
	}
	public void setData_aniversario(java.util.Date data_aniversario) {
		this.data_aniversario = data_aniversario;
	}
	public java.util.Date getDt_primeiro_provisorio() {
		return dt_primeiro_provisorio;
	}
	public void setDt_primeiro_provisorio(java.util.Date dt_primeiro_provisorio) {
		this.dt_primeiro_provisorio = dt_primeiro_provisorio;
	}
	public java.util.Date getDtadmterceiro() {
		return dtadmterceiro;
	}
	public void setDtadmterceiro(java.util.Date dtadmterceiro) {
		this.dtadmterceiro = dtadmterceiro;
	}
	public java.util.Date getDtdemterceiro() {
		return dtdemterceiro;
	}
	public void setDtdemterceiro(java.util.Date dtdemterceiro) {
		this.dtdemterceiro = dtdemterceiro;
	}
	public java.util.Date getAsovalidade() {
		return asovalidade;
	}
	public void setAsovalidade(java.util.Date asovalidade) {
		this.asovalidade = asovalidade;
	}
	public java.util.Date getDt_inativo() {
		return dt_inativo;
	}
	public void setDt_inativo(java.util.Date dt_inativo) {
		this.dt_inativo = dt_inativo;
	}
	public java.util.Date getVenc_nr10() {
		return venc_nr10;
	}
	public void setVenc_nr10(java.util.Date venc_nr10) {
		this.venc_nr10 = venc_nr10;
	}
	public java.util.Date getVenc_nr35() {
		return venc_nr35;
	}
	public void setVenc_nr35(java.util.Date venc_nr35) {
		this.venc_nr35 = venc_nr35;
	}
	public java.util.Date getVenc_nr11() {
		return venc_nr11;
	}
	public void setVenc_nr11(java.util.Date venc_nr11) {
		this.venc_nr11 = venc_nr11;
	}
	public java.util.Date getVenc_nr18() {
		return venc_nr18;
	}
	public void setVenc_nr18(java.util.Date venc_nr18) {
		this.venc_nr18 = venc_nr18;
	}
	public java.util.Date getVenc_nr06() {
		return venc_nr06;
	}
	public void setVenc_nr06(java.util.Date venc_nr06) {
		this.venc_nr06 = venc_nr06;
	}
	public java.util.Date getVenc_nr33() {
		return venc_nr33;
	}
	public void setVenc_nr33(java.util.Date venc_nr33) {
		this.venc_nr33 = venc_nr33;
	}
	public java.util.Date getPrimeiraentradaij() {
		return primeiraentradaij;
	}
	public void setPrimeiraentradaij(java.util.Date primeiraentradaij) {
		this.primeiraentradaij = primeiraentradaij;
	}
	public java.util.Date getUltimoduplapassagem() {
		return ultimoduplapassagem;
	}
	public void setUltimoduplapassagem(java.util.Date ultimoduplapassagem) {
		this.ultimoduplapassagem = ultimoduplapassagem;
	}
	public java.util.Date getVenc_treina_admi() {
		return venc_treina_admi;
	}
	public void setVenc_treina_admi(java.util.Date venc_treina_admi) {
		this.venc_treina_admi = venc_treina_admi;
	}
	public java.util.Date getVenc_treina_espec() {
		return venc_treina_espec;
	}
	public void setVenc_treina_espec(java.util.Date venc_treina_espec) {
		this.venc_treina_espec = venc_treina_espec;
	}
	public java.util.Date getVenc_treina_perio() {
		return venc_treina_perio;
	}
	public void setVenc_treina_perio(java.util.Date venc_treina_perio) {
		this.venc_treina_perio = venc_treina_perio;
	}
	public java.util.Date getVenc_epi() {
		return venc_epi;
	}
	public void setVenc_epi(java.util.Date venc_epi) {
		this.venc_epi = venc_epi;
	}
	public java.util.Date getVenc_ficha_registro() {
		return venc_ficha_registro;
	}
	public void setVenc_ficha_registro(java.util.Date venc_ficha_registro) {
		this.venc_ficha_registro = venc_ficha_registro;
	}
	public java.util.Date getVenc_rg() {
		return venc_rg;
	}
	public void setVenc_rg(java.util.Date venc_rg) {
		this.venc_rg = venc_rg;
	}
	public java.util.Date getVenc_cpf() {
		return venc_cpf;
	}
	public void setVenc_cpf(java.util.Date venc_cpf) {
		this.venc_cpf = venc_cpf;
	}
	public java.util.Date getVenc_exames_compl() {
		return venc_exames_compl;
	}
	public void setVenc_exames_compl(java.util.Date venc_exames_compl) {
		this.venc_exames_compl = venc_exames_compl;
	}
	public java.util.Date getVenc_pcmat() {
		return venc_pcmat;
	}
	public void setVenc_pcmat(java.util.Date venc_pcmat) {
		this.venc_pcmat = venc_pcmat;
	}
	public java.util.Date getVenc_pcmso() {
		return venc_pcmso;
	}
	public void setVenc_pcmso(java.util.Date venc_pcmso) {
		this.venc_pcmso = venc_pcmso;
	}
	public java.util.Date getVenc_carteira_trab() {
		return venc_carteira_trab;
	}
	public void setVenc_carteira_trab(java.util.Date venc_carteira_trab) {
		this.venc_carteira_trab = venc_carteira_trab;
	}
	public int getEhbrigadista() {
		return ehbrigadista;
	}
	public void setEhbrigadista(int ehbrigadista) {
		this.ehbrigadista = ehbrigadista;
	}
	public String getNumcartaoestacionamento() {
		return numcartaoestacionamento;
	}
	public void setNumcartaoestacionamento(String numcartaoestacionamento) {
		this.numcartaoestacionamento = numcartaoestacionamento;
	}
	public String getVeiculo2() {
		return veiculo2;
	}
	public void setVeiculo2(String veiculo2) {
		this.veiculo2 = veiculo2;
	}
	public String getPlaca2() {
		return placa2;
	}
	public void setPlaca2(String placa2) {
		this.placa2 = placa2;
	}
	public String getCorveiculo2() {
		return corveiculo2;
	}
	public void setCorveiculo2(String corveiculo2) {
		this.corveiculo2 = corveiculo2;
	}
	public boolean isVisitante_especial() {
		return visitante_especial;
	}
	public void setVisitante_especial(boolean visitante_especial) {
		this.visitante_especial = visitante_especial;
	}
	public java.util.Date getUltimarefesec() {
		return ultimarefesec;
	}
	public void setUltimarefesec(java.util.Date ultimarefesec) {
		this.ultimarefesec = ultimarefesec;
	}
	public java.util.Date getUltimarefepri() {
		return ultimarefepri;
	}
	public void setUltimarefepri(java.util.Date ultimarefepri) {
		this.ultimarefepri = ultimarefepri;
	}
	public Long getPis() {
		return pis;
	}
	public void setPis(Long pis) {
		this.pis = pis;
	}
	public boolean isFaltadoc() {
		return faltadoc;
	}
	public void setFaltadoc(boolean faltadoc) {
		this.faltadoc = faltadoc;
	}
	public int getUtiliza_complemento() {
		return utiliza_complemento;
	}
	public void setUtiliza_complemento(int utiliza_complemento) {
		this.utiliza_complemento = utiliza_complemento;
	}

}
