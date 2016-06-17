package br.univel;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Produto {

	private int id;
	private String descricao;
	private BigDecimal preco;

	public Produto(int id, String descricao, BigDecimal preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
