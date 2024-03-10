package com.bluesoft.prueba.bluesoft.response;

import java.util.List;

import com.bluesoft.prueba.bluesoft.model.Cliente;


public class ClienteResponse {
	private List<Cliente> cliente;

	public List<Cliente> getLista() {
		return cliente;
	}

	public void setLista(List<Cliente> cliente) {
		this.cliente = cliente;
	}


}
