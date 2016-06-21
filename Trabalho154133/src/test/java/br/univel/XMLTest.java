package br.univel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XMLTest {

	@Test
	public void testExportar() {
		assertTrue(new XML().verificarArquivoExport("Clientes.txt"));
		assertTrue(new XML().verificarArquivoExport("Produtos.txt"));
	}

	@Test
	public void testImportarProduto() {
		assertTrue(new XML().verificarImportCliente("Clientes.txt"));
	}

	@Test
	public void testImportarCliente() {
		assertTrue(new XML().verificarImportProduto("Produtos.txt"));
	}

}
