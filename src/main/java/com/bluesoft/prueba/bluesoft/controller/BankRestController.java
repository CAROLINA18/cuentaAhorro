package com.bluesoft.prueba.bluesoft.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluesoft.prueba.bluesoft.model.Cliente;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.model.Movimiento;
import com.bluesoft.prueba.bluesoft.response.ClienteResponseRest;
import com.bluesoft.prueba.bluesoft.response.CuentaResponseRest;
import com.bluesoft.prueba.bluesoft.response.MovimientoResponseRest;
import com.bluesoft.prueba.bluesoft.services.IClienteService;
import com.bluesoft.prueba.bluesoft.services.ICuentaService;
import com.bluesoft.prueba.bluesoft.services.IMovimientoService;


@RestController
@RequestMapping("/bank")
public class BankRestController {
	
	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private ICuentaService serviceCuenta;
	
	@Autowired
	private IMovimientoService serviceMovimiento;

	
/*	@GetMapping
	public ResponseEntity<CuentaResponseRest> searchListas(){
		ResponseEntity<CuentaResponseRest> response = service.search();
				return response;
	}*/
	
	@PostMapping("/crear-cliente")
	public ResponseEntity<ClienteResponseRest> save(@RequestBody Cliente cliente ){
		ResponseEntity<ClienteResponseRest> response = serviceCliente.save(cliente);
				return response;
	}
	
	@PostMapping("/crear-cuenta")
	public ResponseEntity<CuentaResponseRest> save(@RequestBody Cuenta cuenta ){
		ResponseEntity<CuentaResponseRest> response = serviceCuenta.save(cuenta);
				return response;
	}
	@PostMapping("/saldo/{numeroCuenta}")
	public ResponseEntity<CuentaResponseRest> seeSaldo(@PathVariable int numeroCuenta ){
		ResponseEntity<CuentaResponseRest> response = serviceCuenta.seeSaldo(numeroCuenta);
				return response;
	}
	
	@PostMapping("/crear-movimiento")
	public ResponseEntity<MovimientoResponseRest> save(@RequestBody Movimiento movimiento ){
		ResponseEntity<MovimientoResponseRest> response = serviceMovimiento.save(movimiento);
				return response;
	}
	
	@PostMapping("/extracto/{numeroCuenta}")
	public ResponseEntity<MovimientoResponseRest> extractoCuenta(@PathVariable int numeroCuenta ){
		ResponseEntity<MovimientoResponseRest> response = serviceMovimiento.extractoMensual(numeroCuenta);
				return response;
	}
	


}
