package poo.project.GCMU.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.project.GCMU.Dicente;

public class DicenteTeste {
	Dicente d1;

	@Before
	public void setUp() throws Exception {
		d1 = new Dicente("infoLab", "info", "A", 123, "Ola", "olavose@gmail.com", "123456", "T123");
	}

	public void test() {

		assertTrue(d1.requisitaChave().equals("ok"));
	}

	@Test
	public void test2() {
		assertTrue(d1.requisitaMateriais().equals("ok"));
	}

	@Test
	public void test3() {
		assertTrue(d1.requisitaUtensilios().equals("ok"));

	}
}
