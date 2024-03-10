package com.bluesoft.prueba.bluesoft.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimientoResponseRest extends ResponseRest {
	
	private MovimientoResponse movimientoResponse = new MovimientoResponse();

	public MovimientoResponse getListaResponse() {
		return movimientoResponse;
	}

	public void setListaResponse(MovimientoResponse movimientoResponse) {
		this.movimientoResponse = movimientoResponse;
	}

}
