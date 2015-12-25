
package poo.project.GCMU.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.project.GCMU.Administrador;


public class AdministradorTeste {
	Administrador A1;

	@Before
	public void setUp() throws Exception {
		A1 = new Administrador("123", 123, "Ola", "olavose@gmail.com", "123456");
	}

	public void test() {

		assertTrue(A1.Autoriza().equals("ok, cadastro efetuado"));
	}

}
