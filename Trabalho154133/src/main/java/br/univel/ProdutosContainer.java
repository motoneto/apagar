package br.univel;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ProdutosContainer {
private List<Produto> produto;

public List<Produto> getProduto() {
	return produto;
}

public void setProduto(List<Produto> produto) {
	this.produto = produto;
}
}
