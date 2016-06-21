package br.univel;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteContainer {
	private List<Cliente> cliente;

	public boolean testeClienteConteiner() {
		if (cliente.isEmpty()) {
			return true;
		}
		return false;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

}
