package br.univel;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteContainer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8207263589205777230L;
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
