package br.univel;

import java.util.List;

public class Principal {

public static void main(String[] args) {
	LerArquivoTexto arq = new LerArquivoTexto();
	
	List<String> listaP = arq.lerProdutos();
	List<String> listaC = arq.lerClientes();
	
	Parser parser = new Parser();
	
	List<Produto> listaPrd = parser.getProduto(listaP);
	List<Cliente> listaCli = parser.getCliente(listaC);
	
	ExportarXML out = new ExportarXML();
	ImportarXML in = new ImportarXML();

	out.exportarProduto(listaPrd);
	out.exportarCliente(listaCli);
	
	in.importarCliente();
	in.importarProduto();

}
}
