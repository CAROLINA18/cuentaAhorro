package com.bluesoft.prueba.bluesoft.response;

import java.util.List;

import com.bluesoft.prueba.bluesoft.model.Cliente;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.model.Movimiento;


public class MovimientoResponse {
	private List<Movimiento> movimiento;

	public List<Movimiento> getLista() {
		return movimiento;
	}

	public void setLista(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}


}
