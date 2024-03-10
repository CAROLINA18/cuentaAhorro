package com.bluesoft.prueba.bluesoft.response;

import java.util.List;

import com.bluesoft.prueba.bluesoft.model.Cliente;
import com.bluesoft.prueba.bluesoft.model.Cuenta;


public class CuentaResponse {
	private List<Cuenta> cuenta;

	public List<Cuenta> getLista() {
		return cuenta;
	}

	public void setLista(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}


}
