package com.bluesoft.prueba.bluesoft.services;

import org.springframework.http.ResponseEntity;

import com.bluesoft.prueba.bluesoft.model.Cliente;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.model.Movimiento;
import com.bluesoft.prueba.bluesoft.response.ClienteResponseRest;
import com.bluesoft.prueba.bluesoft.response.CuentaResponseRest;

public interface ICuentaService {
	public ResponseEntity<CuentaResponseRest> seeSaldo(int numeroCuenta);

	public ResponseEntity<CuentaResponseRest> save(Cuenta cuenta);

}
