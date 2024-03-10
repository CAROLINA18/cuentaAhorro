package com.bluesoft.prueba.bluesoft.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaResponseRest extends ResponseRest {
	
	private CuentaResponse cuentaResponse = new CuentaResponse();

	public CuentaResponse getListaResponse() {
		return cuentaResponse;
	}

	public void setListaResponse(CuentaResponse cuentaResponse) {
		this.cuentaResponse = cuentaResponse;
	}

}
