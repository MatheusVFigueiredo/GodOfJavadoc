package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pessoa.Pessoa;
import pessoa.RepositoryPessoa;

public class RepositoryPessoaTeste {

	private String stringGenerica;
	private boolean testeBoolean;
	private boolean testeBoolean2;
	private RepositoryPessoa repository;
	private Pessoa pessoa;
	private Pessoa pessoa2;

	@Before
	public void setUp() throws Exception {
		repository = new RepositoryPessoa();
		pessoa = new Pessoa("024.685.014-52", "Dilma", "LulaLindo@gmail.com");
	}

	@Test
	public void testVerificaCpfCadastrado() {

		testeBoolean2 = false;
		testeBoolean = repository.verificaCpfCadastrado("024.685.014-52");
		Assert.assertEquals(testeBoolean2, testeBoolean);

	}

	@Test
	public void testGetPessoa() {

		repository.adicionaPessoa(pessoa);
		pessoa2 = repository.getPessoa("024.685.014-52");
		Assert.assertEquals(pessoa, pessoa2);

	}

}
