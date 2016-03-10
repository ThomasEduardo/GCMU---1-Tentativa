package poo.project.GCMU.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.project.GCMU.Docente;

public class DocenteTeste {
	Docente dc1;

	/**
	 * Tem como atributos: cargo, area, turno, matricula, name, email,
	 * telefone,senha, matricula, name, email, telefone, senha);
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dc1 = new Docente("secretario", "secretaria", "integral", 1234, "olavose", "olavose@gmail.com", 123456,
				"T12345", "123.456.789-12", 7777);
	}

	@Test
	public void test() {

		assertTrue(dc1.requisitaChave().equals("ok, Chave Reservada!"));
	}

	@Test
	public void test2() {
		assertTrue(dc1.requisitaMateriais().equals("ok, Material reservado!"));
	}

	@Test
	public void test3() {
		assertTrue(dc1.requisitaUtensilios().equals("ok, Utencilio Encontrado!"));

	}
}
