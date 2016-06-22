package br.univel;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutosContainer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3637301920955805531L;
	private List<Produto> produto;

	public boolean testeProdutoConteiner() {
		if (produto.isEmpty()) {
			return true;
		}
		return false;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
