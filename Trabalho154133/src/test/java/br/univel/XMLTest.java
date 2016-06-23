package br.univel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class XMLTest {
	static XML xml;
	static ProdutosContainer pc;
	
	@BeforeClass
	static void setUp(){
		xml = new XML();
		pc = new ProdutosContainer();
	}
	
	@Test
	public void testVerificarArqCliente() {
		assertTrue(xml.verificarArquivoExport("Clientes.txt"));
	}
	@Test
	public void testVerificarArqProduto() {
		assertTrue(xml.verificarArquivoExport("Produtos.txt"));
	}@Test
	public void testExportar() {
		assertEquals(true,xml.exportar(pc, "ListaProduto.xml"));
	}
	@Test
	public void testImportarProduto() {
		
	}

	@Test
	public void testImportarCliente() {

	}

}
