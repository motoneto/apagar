package br.univel;

import java.util.List;

public class Principal {

public static void main(String[] args) {
	LerArquivoTexto arq = new LerArquivoTexto();
	List<String> lista = arq.lerArquivo();
	
	ProdutoParser parser = new ProdutoParser();
	List<Produto> listaPrd = parser.getProduto(lista);
	ExportarXML out = new ExportarXML();
	ImportarXML in = new ImportarXML();

	out.exportar(listaPrd);
	in.importar();

}
}
