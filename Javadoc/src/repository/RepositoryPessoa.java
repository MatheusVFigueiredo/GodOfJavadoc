package repository;

import java.util.HashMap;

import pessoa.Pessoa;

/**
* RepositoryPessoa.
* Classe onde esta armazenada a lista de pessoas do sistema e que e responsavel por  fornecer informacoes sobre essa lista.
*
* @author Matheus de Souza Coutinho
* @author Matheus Vasconcelos Figueiredo
* 
* @param pessoas
*           - lista de pessoas armazenadas.
*/

public class RepositoryPessoa {
	
	private HashMap<String, Pessoa> pessoas;
	
	public RepositoryPessoa(){
		pessoas = new HashMap<>();
	}
	
	public void adicionaPessoa(Pessoa pessoa){
		pessoas.put(pessoa.getCpf(), pessoa);
	}
	
	public void removerPessoa(String cpf){
		pessoas.remove(cpf);
	}
	
	public boolean verificaCpfCadastrado(String cpf){
		return pessoas.containsKey(cpf);
	}
	
	public Pessoa getPessoa(String cpf){
		return pessoas.get(cpf);
	}
}
