package com.bluesoft.prueba.bluesoft.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseRest extends ResponseRest {
	
	private ClienteResponse clienteResponse = new ClienteResponse();

	public ClienteResponse getListaResponse() {
		return clienteResponse;
	}

	public void setListaResponse(ClienteResponse clienteResponse) {
		this.clienteResponse = clienteResponse;
	}

}
