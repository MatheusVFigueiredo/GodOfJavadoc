package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.FactoryPessoa;
import pessoa.Pessoa;
import pessoa.PessoaController;
import pessoa.RepositoryPessoa;

public class PessoaControllerTeste {

	private FactoryPessoa factoryPessoa;
	private Pessoa pessoa;
	private Pessoa pessoa2;
	private PessoaController pessoaController;
	private String stringGenerica;
	private RepositoryPessoa repository;

	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa("024.685.014-52", "Dilma", "LulaLindo@gmail.com");
		factoryPessoa = new FactoryPessoa();
		pessoaController = new PessoaController();
		repository = new RepositoryPessoa();
	}

	@Test
	public void testCadastraPessoa() throws Exception {

		stringGenerica = pessoaController.cadastraPessoa("024.685.014-52", "Dilma", "LulaLindo@gmail.com");
		Assert.assertEquals("024.685.014-52", stringGenerica);

	}

	@Test
	public void testCriaPessoa() throws Exception {

		pessoa2 = pessoaController.criaPessoa("024.685.014-52", "Dilma", "LulaLindo@gmail.com");
		Assert.assertEquals(pessoa, pessoa2);

	}

}
