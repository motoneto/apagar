package br.univel;

public class Cliente {

	private int id;
	private String nome;
	private String endereço;
	private int numero;
	private String complemento;
	private String Bairro;
	private String Cidade;
	private String Estado;
	private int CEP;
	private String telefone;
	private String celular;
	
	
	public Cliente(int id, String nome, String endereço, int numero, String complemento, String bairro, String cidade,
			String estado, int cEP, String telefone, String celular) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereço = endereço;
		this.numero = numero;
		this.complemento = complemento;
		Bairro = bairro;
		Cidade = cidade;
		Estado = estado;
		CEP = cEP;
		this.telefone = telefone;
		this.celular = celular;
	}
	
	public Cliente() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
