package br.univel;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdutosContainerTest {
 ProdutosContainer pc = new ProdutosContainer();
	@Test
	public void testTesteProdutoConteiner() {
		assertTrue(pc.testeProdutoConteiner());
	}

}
