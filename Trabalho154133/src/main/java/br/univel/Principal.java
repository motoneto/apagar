package br.univel;

import java.util.ArrayList;
import java.util.List;

public class Principal {

public static void main(String[] args) {
	LerArquivoTexto arq = new LerArquivoTexto();
	List<String> listaP = new ArrayList<String>();
	List<String> listaC = new ArrayList<String>();
//	listaP = arq.lerArquivo("Produtos.txt");
	listaC = arq.lerArquivo("Clientes.txt");
	
	Parser parser = new Parser();
	
	List<Produto> listaPrd = parser.getProduto(listaP);
//	List<Cliente> listaCli = parser.getCliente(listaC);
	
//	listaCli.forEach(System.out::println);
	
//	ClienteContainer cc = new ClienteContainer();
	ProdutosContainer pc = new ProdutosContainer();

	pc.setProduto(listaPrd);
//	cc.setCliente(listaCli);
//	cc.getCliente().forEach(e->{System.out.println(e);});
	XML xml = new XML();
	xml.exportar(pc,"ListaProduto.xml");
//	xml.exportar(cc,"listaClientes.xml");
	
//	List<Cliente> listaClientes = xml.importarCliente("ListaClientes.xml");
	
	List<Produto> listaProdutos = xml.importarProduto("ListaProduto.xml");
	
	Serializar serial = new Serializar();
	
	serial.SerializarProdutos("Produto.dat");
//	serial.SerializarClientes("Cliente.dat");
	
	serial.ImportSerialProdutos("Produto.dat");
//	serial.ImportSerialClientes("Cliente.dat");

}
}
