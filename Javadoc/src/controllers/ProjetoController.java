package controllers;

import java.io.ObjectInputValidation;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import exception.EntradaInvalidaException;
import exception.ProjetoInvalidoException;
import exception.StringInvalidaException;
import factory.FactoryProjeto;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import repository.RepositoryPessoa;
import repository.RepositoryProjeto;
import util.ExcecoesProjetos;
import util.Util;

/**
 * ProjetoController. 
 * Classe que gerencia todas as operações envolvendo Projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param repositoryprojeto
 *            - variavel que representa a classe RepositoryProjeto.
 * @param factoryProjeto
 *            - variavel que representa a classe FactoryProjeto.
 */

public class ProjetoController {

	private FactoryProjeto factoryProjeto;
	private RepositoryProjeto repositoryProjeto;

	public ProjetoController() {
		this.factoryProjeto = new FactoryProjeto();
		this.repositoryProjeto = new RepositoryProjeto();
	}

	public RepositoryProjeto getRepository() {
		return repositoryProjeto;
	}

	/**
	 * adicionaMonitoria.
	 * Metodo que adiciona um novo projeto do tipo Monitoria.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param disciplina
	 *            - disciplina especifica a que esta direcionado.
	 * @param rendimento
	 *            - expectativa de aprovacao na disciplina.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param periodo
	 *            - periodo letivo em que ocorreu.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return - codigo do projeto de monitoria adicionado
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo,
			Date data, int duracao) throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaMonitoria(nome, disciplina, rendimento, objetivo, periodo, data,
					duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}

	/**
	 * adicionaPET.
	 * Metodo que adiciona um novo projeto do tipo PET.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param impacto
	 *            - impacto social.
	 * @param rendimento
	 *            - expectativa de aprovacao na disciplina.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param prodTecnica
	 *            - quantidade de produtividade do tipo tecnica.
	 * @param prodAcademica
	 *            - quantidade de produtividade do tipo academica.
	 * @param patentes
	 *            - quantidade de produtividade do tipo patente.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return
	 *  		  - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica,
			int prodAcademica, int patentes, Date data, int duracao) throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica,
					patentes, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	/**
	 * adicionaPED. 
	 * Metodo que adiciona um novo projeto do tipo PED.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param categoria
	 *            - modalidades do projeto de P&D.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param prodTecnica
	 *            - quantidade de produtividade do tipo tecnica.
	 * @param prodAcademica
	 *            - quantidade de produtividade do tipo academica.
	 * @param patentes
	 *            - quantidade de produtividade do tipo patente.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return
	 *            - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *            - excecao lancada caso ocorra algum erro.
	 */

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes,
			String objetivo, Date data, int duracao) throws Exception {
		try {
			Projeto projeto = factoryProjeto.criaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo,
					data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new Exception(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}

	/**
	 * adicionaExtensao.
	 * Metodo que adiciona um novo projeto do tipo Extensao.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param impacto
	 *            - impacto social.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return 
	 *            - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, Date data, int duracao)
			throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaExtensao(nome, objetivo, impacto, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	/**
     * atualizaProjeto.
     * Metodo que atualiza as informacoes de um Projeto.
     *
     * @param codigo
     *            - codigo do projeto.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void atualizaProjeto(int codigo, String atributo, String valor) throws EntradaInvalidaException {
		try {
			if (atributo.equals("Data de Inicio")) {
				ExcecoesProjetos.validaDia(valor);
			}
			if (atributo.equals("Objetivo")) {
				ExcecoesProjetos.validaObjetivoAtualizacao(valor);
			}
			ExcecoesProjetos.validaAtualizacao(valor);
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			alteraAtributo(projeto, atributo, valor);
		} catch (Exception e) {
			throw new EntradaInvalidaException(Util.ERRO_ATUALIZAO_PROJETO + e.getMessage());
		}
	}
	
	/**
     * alterarAtributo.
     * Metodo que altera dados de um Projeto.
     *
     * @param projeto
     *            - projeto a ser alterado.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	private void alteraAtributo(Projeto projeto, String atributo, String valor) throws StringInvalidaException {

		if (projeto instanceof PET) {
			projeto = (PET) (projeto);
			Util.alteraAtributoPET((PET) projeto, atributo, valor);
		} else if (projeto instanceof Extensao) {
			projeto = (Extensao) (projeto);
			Util.alteraAtributoExtensao((Extensao) projeto, atributo, valor);
		}
		if (projeto instanceof PED) {
			projeto = (PED) (projeto);
			Util.alteraAtributoPED((PED) projeto, atributo, valor);
		} else if (projeto instanceof Monitoria) {
			projeto = (Monitoria) (projeto);
			Util.alteraAtributoMonitoria((Monitoria) projeto, atributo, valor);
		}
	}
	
	/**
     * getInfoProjeto.
     * Metodo que pesquisa uma determinada informacao sobre um projeto.
     *
     * @param codigo
     *            - codigo do projeto.
     * @param atributo
     *            - atributo para atualizar o projeto.
     *
     * @return
     * 			  - informacao que foi pesquisada.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	public String getInfoProjeto(int codigo, String atributo) throws ProjetoInvalidoException {
		try {
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			ExcecoesProjetos.validaProjeto(projeto);
			if (Util.checarAtributoProjeto(atributo)) {
				throw new Exception(ExcecoesProjetos.ERRO_ATRIBUTO_INVALIDO);
			}
			if (projeto instanceof Monitoria) {
				projeto = (Monitoria) (projeto);
				return Util.retornaAtributoMonitoria((Monitoria) projeto, atributo);
			}
			if (projeto instanceof Extensao) {
				projeto = (Extensao) (projeto);
				return Util.retornaAtributoExtensao((Extensao) projeto, atributo);
			}
			if (projeto instanceof PED) {
				projeto = (PED) (projeto);
				return Util.retornaAtributoPED((PED) projeto, atributo);
			}
			if (projeto instanceof PET) {
				projeto = (PET) (projeto);
				return Util.retornaAtributoPET((PET) projeto, atributo);
			}
			return "";
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}

	}
	
	/**
     * getCodigoProjeto.
     * Metodo que pesquisa o codigo de um projeto.
     *
     * @param nome
     *            - nome do projeto.
     *
     * @return
     * 			  - codigo do projeto pesquisado.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	public int getCodigoProjeto(String nome) throws EntradaInvalidaException {
		try {
			ExcecoesProjetos.validaNome(nome);
			if (repositoryProjeto.getCodigoProjeto(nome) == -1) {
				throw new Exception(ExcecoesProjetos.ERRO_PROJETO_INEXISTENTE);
			}
			return repositoryProjeto.getCodigoProjeto(nome);
		} catch (Exception e) {
			throw new EntradaInvalidaException(Util.ERRO_OBTENCAO_CODIGO + e.getMessage());
		}
	}

	/**
     * removeProjeto.
     * Metodo que remove um projeto do sitema.
     *
     * @param codigo
     *            - codigo do projeto.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void removeProjeto(int codigo) throws ProjetoInvalidoException {
		try {
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			ExcecoesProjetos.validaProjeto(projeto);
			repositoryProjeto.removerProjeto(codigo);
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}
	}
}
