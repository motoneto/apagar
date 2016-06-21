package br.univel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteContainerTest {

	@Test
	public void testTesteClienteConteiner() {
		assertTrue(new ClienteContainer().testeClienteConteiner());
	}

}
