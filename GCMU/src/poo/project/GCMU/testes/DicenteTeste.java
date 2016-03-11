package poo.project.GCMU.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.project.GCMU.Discente;

public class DicenteTeste {
	Discente d1;

	@Before
	/**
	 * Tem como atributos: sala, curso, turma, matricula, name, email, telefone,
	 * senha,matricula, name, email, telefone, senha);
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		d1 = new Discente("infoLab", "info", "A", 123, "Ola", "olavose@gmail.com", 123456, "T123", "123.456.789-11");
	}

	public void test() {

		assertTrue(d1.requisitaChave().equals("ok, Chave Reservada!"));
	}

	@Test
	public void test2() {
		assertTrue(d1.requisitaMateriais().equals("ok, Material reservado!S"));
	}

	@Test
	public void test3() {
		assertTrue(d1.requisitaUtensilios().equals("ok, Utencilio Encontrado!"));

	}
}
