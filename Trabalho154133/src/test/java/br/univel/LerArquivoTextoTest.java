package br.univel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LerArquivoTextoTest {
	
	@Test
	public void testLerArquivoCliente() {
		assertTrue(new LerArquivoTexto().verificarArquivo("Clientes.txt"));
	}
	public void testLerArquivoProduto() {
		assertTrue(new LerArquivoTexto().verificarArquivo("Produtos.txt"));
	}
}
