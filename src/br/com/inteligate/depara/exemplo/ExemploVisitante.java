package br.com.inteligate.depara.exemplo;

import java.sql.SQLException;

import br.com.inteligate.depara.conexao.DataSourceC3p0;
import br.com.inteligate.depara.dados.Empresas;
import br.com.inteligate.depara.dados.Niveis;
import br.com.inteligate.depara.dados.TipoSalarial;
import br.com.inteligate.depara.dados.Usuarios;
import br.com.inteligate.depara.dados.Visitantes;
import br.com.inteligate.depara.dao.ConfiguracoesDao;
import br.com.inteligate.depara.dao.EmpresasDao;
import br.com.inteligate.depara.dao.NiveisDao;
import br.com.inteligate.depara.dao.TipoSalarialDao;
import br.com.inteligate.depara.dao.UsuarioDao;
import br.com.inteligate.depara.dao.VisitantesDao;

public class ExemploVisitante {


	static int tamanhoMatricula  = 14;
	public static void main(String[] args) throws SQLException {

		DataSourceC3p0.configurar("D:\\Projetos\\UDP\\work_depara\\Depara\\config.props");
		
		ExemploVisitante exemploVisitante = new ExemploVisitante();
		exemploVisitante.criaCrachaVisitante("2");

		exemploVisitante.cadastroVisitante();

	}

	public void cadastroVisitante() throws SQLException{

		VisitantesDao visitantesDao = new VisitantesDao();
		EmpresasDao empresasDao = new EmpresasDao();
		UsuarioDao usuarioDao =  new UsuarioDao();

		Visitantes visitantes = new Visitantes();

		//Documento - nome do campo na tela
		String rg = "123";

		// Nome 
		String nome = "Maria de Oliveira";



		// Empresa Visitante
		String empresavisitante = "Grafica xyz";

		//Empresa
		long id_empresa = 1; 
		Empresas empresas = empresasDao.buscaPorId(id_empresa);
		String empresa = empresas.getNomefantasia();

		// Nome Visitado
		String nomevisitado = "JOSÉ DA SILVA";
		Usuarios usuario = usuarioDao.buscaPorNome(nomevisitado);

		// Fone Visitado -  vem da pesq. visitado
		String fonevisitado = usuario.getRamal();
		String matvisitado = usuario.getMatricula();
		long id_visitado = usuario.getId_usuarios();

		// Local
		long id_local_acesso = 1; // tabela aces_localdeacesso

		// Status
		long id_status = 1; // tabela aces_status

		// Validade Especial
		java.util.Date validade_especial = new java.util.Date();
		validade_especial.setDate( validade_especial.getDate() + 5);

		// Mat. Cracha 
		String cracha = "00000000000002";

		// Data Cadastro
		java.util.Date datacadastramento = new java.util.Date();

		visitantes.setRg(rg);
		visitantes.setNome(nome);
		visitantes.setEmpresavisitante(empresavisitante);
		visitantes.setId_empresa(id_empresa);
		visitantes.setEmpresa(empresa);
		visitantes.setId_visitado(id_visitado);
		visitantes.setNomevisitado(nomevisitado);
		visitantes.setFonevisitado(fonevisitado);
		visitantes.setMatvisitado(matvisitado);
		visitantes.setId_local_acesso(id_local_acesso);
		visitantes.setId_status(id_status);
		visitantes.setValidade_especial(validade_especial);
		visitantes.setCracha(cracha);
		visitantes.setDatacadastramento(datacadastramento);

		visitantes.setD_h_atualizacao(new java.util.Date());

		long chave = visitantesDao.adiciona(visitantes);
		System.out.println("Chave:" +chave);


		visitantesDao.finalize();
		empresasDao.finalize();
		usuarioDao.finalize();
	}

	public void criaCrachaVisitante(String codigo) throws SQLException{

		UsuarioDao usuarioDao = new UsuarioDao();
		NiveisDao niveisDao = new NiveisDao();
		EmpresasDao empresasDao = new EmpresasDao();

		String matricula = codigo;

		matricula=("00000000000000"+matricula).substring(14+matricula.length()-tamanhoMatricula);

		long idsite = 1;
		long id_empresa = 1;
		String nomecompleto = "Visitante 2";
		String nomeabreviado = "V2";
		String tipo = "V"; //"F"-Funcionário "V"-Visitante "P"-Provisório
		long id_gera_niveis = 1;
		Niveis niveis = niveisDao.buscaPorId(id_gera_niveis);
		String nivel = niveis.getCodigo();

		String cracha = matricula; // verificar se o acesso é pelo cracha e qual o tipo do cracha
		// dependendo do tipo de cracha, apenas parte do cracha é validado pelo 4com.
		// neste caso configurar a tabela gera_configuracoes com o intervalo a ser validado no cracha

		Empresas empresa = empresasDao.buscaPorId(id_empresa);

		String codigoEmpresa = empresa.getCodigo();

		Usuarios usuarios = usuarioDao.buscaPorMatricula(matricula);

		if(usuarios!=null){
			System.out.println("Usuario já cadastrado será alterado, Chave:" +usuarios.getId_usuarios());
		}else{
			usuarios = new Usuarios();
		}

		usuarios.setMatricula(matricula);
		usuarios.setCracha(cracha);
		usuarios.setIdsite(idsite);
		usuarios.setId_empresa(id_empresa);
		usuarios.setEmpresa(codigoEmpresa);
		usuarios.setNomecompleto(nomecompleto);
		usuarios.setNomeabreviado(nomeabreviado);
		usuarios.setTipo(tipo);

		usuarios.setId_gera_niveis(id_gera_niveis);
		usuarios.setNivel(nivel);

		usuarios.setId_centroderesponsabilidade(1l);
		usuarios.setId_classificacao(1l);
		usuarios.setGrpduplaut("0");

		usuarios.setPermissaoacesso("S");
		usuarios.setControlafluxo("1");
		usuarios.setPeriodicidadetrab("d");
		usuarios.setId_nivel_ant(0l);
		usuarios.setNivel_ant("000");
		usuarios.setEnvialista(true);
		usuarios.setAtividade("I");
		usuarios.setTpprestacao("1");
		usuarios.setUtiliza_complemento(1);
		usuarios.setD_h_atualizacao(new java.util.Date());

		// valores default
		usuarios.setUltimadtlocal("200707011200");

		if(usuarios.getId_usuarios()==null){
			long chave = usuarioDao.adiciona(usuarios);
			System.out.println("Usuario adicionado, Chave:" +chave);
		}else{
			usuarioDao.altera(usuarios);
			System.out.println("Usuario alterado, Chave:" +usuarios.getId_usuarios());
		}

		usuarioDao.finalize();
		niveisDao.finalize();
		empresasDao.finalize();
	}

	public ExemploVisitante() {

	}

}
