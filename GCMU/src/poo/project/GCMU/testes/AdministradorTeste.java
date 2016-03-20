package poo.project.GCMU.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.project.GCMU.classes.Administrador;

public class AdministradorTeste {
	Administrador A1;

	/**
	 * tem como atributos, respectivamente: senha, matricula, name, email,
	 * telefone, matricula, name, email e telefone;
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		A1 = new Administrador(0, "123", 123, "Ola", "olavose@gmail.com", 123456, "123.456.789-10");
	}

	@Test
	public void testAutorizaPessoa() {
		assertTrue(A1.AutorizaPessoa().equals("ok, você está autorizado!"));

	}

	@Test
	public void testCadastro() {
		assertTrue(A1.Cadastro().equals("ok, cadastro efetuado!"));
	}

	@Test
	public void testAtualizacao() {
		assertTrue(A1.Atualizacao().equals("ok, Atualização efetuada!"));
	}

	@Test
	public void testRemocao() {
		assertTrue(A1.Remocao().equals("ok, Remoção efetuada!"));
	}

}
