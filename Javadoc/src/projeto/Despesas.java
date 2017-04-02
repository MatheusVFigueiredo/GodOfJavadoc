package projeto;

import exception.ProjetoInvalidoException;
import util.ExcecoesProjetos;
import util.Util;

/**
 * Despesas.
 * Classe onde se armazena cada valor recebido pelo projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param montanteBolsas
 *           - Valor referente as Bolsas.
 * @param montanteCusteio
 *           - Valor referente ao custeio.
 * @param montanteCapital
 *           - Valor Referente ao capital.    
 */

public class Despesas {
	private double montanteBolsas;
	private double montanteCusteio;
	private double montanteCapital;

	public Despesas(double montanteBolsas, double montanteCusteio, double montanteCapital)  {
		this.montanteBolsas = montanteBolsas;
		this.montanteCusteio = montanteCusteio;
		this.montanteCapital = montanteCapital;
	}

	public Despesas() {
	}

	public double getMontanteBolsas() {
		return montanteBolsas;
	}

	public void setMontanteBolsas(double montanteBolsas) throws ProjetoInvalidoException {
		ExcecoesProjetos.validaValores(montanteCapital);
		this.montanteBolsas = montanteBolsas;
	}

	public double getMontanteCusteio() {
		return montanteCusteio;
	}

	public void setMontanteCusteio(double montanteCusteio) throws ProjetoInvalidoException {
		ExcecoesProjetos.validaValores(montanteCusteio);
		this.montanteCusteio = montanteCusteio;
	}

	public double getMontanteCapital() {
		return montanteCapital;
	}

	public void setMontanteCapital(double montanteCapital) throws ProjetoInvalidoException {
		ExcecoesProjetos.validaValores(montanteCapital);
		this.montanteCapital = montanteCapital;
	}

	public double getValorTotal(){
		return this.getMontanteBolsas() + this.getMontanteCapital() + this.getMontanteCusteio();
	}
}
