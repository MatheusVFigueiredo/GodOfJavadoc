package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import projeto.Projeto;

/**
* RepositoryProjeto.
* Classe onde esta armazenada a lista de projetos do sistema e que e responsavel por  fornecer informacoes sobre essa lista.
*
* @author Matheus de Souza Coutinho
* @author Matheus Vasconcelos Figueiredo
* 
* @param projetos
*           - lista de projetos armazenados.
*/

public class RepositoryProjeto {
	private HashMap<Integer, Projeto> projetos;
	
	public RepositoryProjeto(){
		this.projetos = new HashMap<>();
	}
	
	public void adicionarProjeto(Projeto projeto){
		projetos.put(projeto.getCodigo(), projeto);
	}
	
	public void removerProjeto(int codigo){
		projetos.remove(codigo);
	}
	
	public boolean verificaProjetoCadastrado(int codigo){
		return projetos.containsKey(codigo);
	}
	
	public int getCodigoProjeto(String nome){
		for(Projeto projeto : projetos.values()){
			if(projeto.getNome().equalsIgnoreCase(nome)){
				return projeto.getCodigo();
			}
		}
				return -1;
	}
	public Projeto getProjeto(int codigo){
		return projetos.get(codigo);
	}

	public HashMap<Integer, Projeto> getProjetos() {
		return projetos;
	}
	
	
}
