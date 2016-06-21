package br.univel;

import java.util.List;

public class Principal {

public static void main(String[] args) {
	LerArquivoTexto arq = new LerArquivoTexto();
	
	List<String> listaP = arq.lerArquivo("Produtos.txt");
//	List<String> listaC = arq.lerArquivo("Cliente.txt");
	
	Parser parser = new Parser();
	
	List<Produto> listaPrd = parser.getProduto(listaP);
//	List<Cliente> listaCli = parser.getCliente(listaC);
	
//	ClienteContainer cc = new ClienteContainer();
	ProdutosContainer pc = new ProdutosContainer();

	pc.setProduto(listaPrd);
//	cc.setLista(listaCli);
	XML xml = new XML();
	xml.exportar(pc,"ListaProduto.xml");
//	xml.exportar(cc,"listaClientes.xml");
	
//	xml.importarCliente("ListaClientes.xml");
//	xml.importarProduto("ListaProduto.xml");
	
	Serializar serial = new Serializar();
	
//	serial.SerializarClientes(listaCli, "Cliente.dat");
	serial.SerializarProdutos(pc.getProduto(), "Produto.dat");
	
//	serial.ImportSerialProdutos("Produto.dat");
//	serial.ImportSerialClientes("Cliente.dat");

}
}
