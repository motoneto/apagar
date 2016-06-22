package br.univel;

import java.util.List;

public class Principal {

public static void main(String[] args) {
	LerArquivoTexto arq = new LerArquivoTexto();
	
//	List<String> listaP = arq.lerArquivo("Produtos.txt");
	List<String> listaC = arq.lerArquivo("Clientes.txt");
	
	Parser parser = new Parser();
	
//	List<Produto> listaPrd = parser.getProduto(listaP);
	List<Cliente> listaCli = parser.getCliente(listaC);
	
	ClienteContainer cc = new ClienteContainer();
//	ProdutosContainer pc = new ProdutosContainer();

//	pc.setProduto(listaPrd);
	cc.setCliente(listaCli);
	XML xml = new XML();
//	xml.exportar(pc,"ListaProduto.xml");
	xml.exportar(cc,"listaClientes.xml");
	
	List<Cliente> listaqvem = xml.importarCliente("ListaClientes.xml");
	
//	List<Produto> listaqvem = xml.importarProduto("ListaProduto.xml");
	
//	Serializar serial = new Serializar();
	
//	serial.SerializarProdutos("Produto.dat");
//	serial.SerializarClientes("Cliente.dat");
	
//	serial.ImportSerialProdutos("Produto.dat");
//	serial.ImportSerialClientes("Cliente.dat");

}
}
