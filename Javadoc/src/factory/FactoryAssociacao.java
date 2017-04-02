package factory;

import java.util.Date;

import participacao.AlunoGraduando;
import participacao.AlunoPosGraduando;
import participacao.Participacao;
import participacao.Professor;
import participacao.Profissional;

/**
 * FactoryAssociacao. 
 * Classe que faz a criacao de novos objetos do tipo participacao.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 */

public class FactoryAssociacao {
	
	/**
	 * criaParticipacaoProfessor.
	 * Metodo que cria um novo objeto do tipo Professor.
	 *
	 * @param cpf
	 *            - cpf unico da pessoa.
	 * @param codigo
	 *            - codigo do projeto.
	 * @param data
	 *            - data de início da participacao.
	 * @param duracao
	 *            - duração em meses da participacao.
	 * @param qtdHoras
	 *            - quantidade de horas semanais a serem dedicadas ao projeto.
	 * @param valorHora
	 *            - valor da hora para essa participacao.
	 * @param coordenador
	 *            - Indica se a participacao do professor e como coordenador ou nao.
	 *
	 * @return 
	 * 			  - objeto criado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public Participacao criaParticipacaoProfessor(String cpf, int codigo, Date data, int duracao, int qtdHoras,
			double valorHora, boolean coordenador) throws Exception {
		Participacao part = new Professor(cpf, codigo, data, duracao, qtdHoras, valorHora, coordenador);
		return part;
	}

	/**
	 * criaParticipacaoGraduando.
	 * Metodo que cria um novo objeto do tipo AlunoGraduando.
	 *
	 * @param cpf
	 *            - cpf unico da pessoa.
	 * @param codigo
	 *            - codigo do projeto.
	 * @param data
	 *            - data de início da participacao.
	 * @param duracao
	 *            - duração em meses da participacao.
	 * @param qtdHoras
	 *            - quantidade de horas semanais a serem dedicadas ao projeto.
	 * @param valorHora
	 *            - valor da hora para essa participacao.
	 * @return 
	 * 			  - objeto criado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public Participacao criaParticipacaoGraduando(String cpf, int codigo, Date data, int duracao, int qtdHoras,
			double valorHora) throws Exception {
		Participacao part = new AlunoGraduando(cpf, codigo, data, duracao, qtdHoras, valorHora);
		return part;
	}

	/**
	 * criaParticipacaoProfissional.
	 * Metodo que cria um novo objeto do tipo Profissional.
	 *
	 * @param cpf
	 *            - cpf unico da pessoa.
	 * @param codigo
	 *            - codigo do projeto.
	 * @param data
	 *            - data de início da participacao.
	 * @param duracao
	 *            - duração em meses da participacao.
	 * @param qtdHoras
	 *            - quantidade de horas semanais a serem dedicadas ao projeto.
	 * @param valorHora
	 *            - valor da hora para essa participacao.
	 * @param cargo
	 *            - Indica o cargo que o profissional ocupa.
	 *
	 * @return 
	 * 			  - objeto criado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public Participacao criaParticipacaoProfissional(String cpf, int codigo, Date data, int duracao, int quantHoras,
			double valorHora, String cargo) throws Exception {
		Participacao part = new Profissional(cpf, codigo, data, duracao, quantHoras, valorHora, cargo);
		return part;
	}

	/**
	 * criaParticipacaoProfissional.
	 * Metodo que cria um novo objeto do tipo Profissional.
	 *
	 * @param cpf
	 *            - cpf unico da pessoa.
	 * @param codigo
	 *            - codigo do projeto.
	 * @param data
	 *            - data de início da participacao.
	 * @param duracao
	 *            - duração em meses da participacao.
	 * @param qtdHoras
	 *            - quantidade de horas semanais a serem dedicadas ao projeto.
	 * @param valorHora
	 *            - valor da hora para essa participacao.
	 * @param nivel
	 *            - mostra se o aluno esta vinculado a mestrado ou doutorado.
	 *
	 * @return 
	 * 			  - objeto criado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public Participacao criaParticipacaoPosGraduando(String cpf, int codigo, String nivel, Date data, int duracao,
			int quantHoras, double valorHora) throws Exception {
		Participacao part = new AlunoPosGraduando(cpf, codigo, nivel, data, duracao, quantHoras, valorHora);
		return part;
	}
	

}
