package com.bluesoft.prueba.bluesoft.services;

import org.springframework.http.ResponseEntity;

import com.bluesoft.prueba.bluesoft.model.Cliente;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.model.Movimiento;
import com.bluesoft.prueba.bluesoft.response.ClienteResponseRest;

public interface IClienteService {

	public ResponseEntity<ClienteResponseRest> save(Cliente cliente);


}
