package com.bluesoft.prueba.bluesoft.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluesoft.prueba.bluesoft.dao.ICuentaDao;
import com.bluesoft.prueba.bluesoft.model.Cliente;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.response.CuentaResponseRest;



@Service
public class CuentaServiceImpl implements ICuentaService {
	
	@Autowired
	private ICuentaDao cuentaDao;


	@Override
	@Transactional
	public ResponseEntity<CuentaResponseRest> save(Cuenta cuenta) {
		CuentaResponseRest response  = new CuentaResponseRest();
		List<Cuenta> list = new ArrayList<>();

		try {
				Cuenta CuentaSave= cuentaDao.save(cuenta);	
				list.add(CuentaSave);			 
				response.getListaResponse().setLista(list);
				response.setMetadata("Respuesta ok", "00", "registro guardado ");
			
		
		}catch(Exception e) {
			System.out.print(e);
			response.setMetadata("Respuesta Fallida", "500", "Error guardando");
			e.getStackTrace();
			return new ResponseEntity<CuentaResponseRest>(response , HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<CuentaResponseRest>(response , HttpStatus.CREATED);

	}


	@Override
	public ResponseEntity<CuentaResponseRest> seeSaldo(int numeroCuenta) {
		CuentaResponseRest response = new CuentaResponseRest();
		Date fecha = new Date();
		try {
			
			List<Cuenta> cuenta = cuentaDao.seeSaldoByCuenta(numeroCuenta);
			response.getListaResponse().setLista(cuenta);
			response.setMetadata("Exito", "200", fecha.toString()  );

		}catch(Exception e) {
			response.setMetadata("Respuesta Fallida", "500", fecha.toString());
			e.getStackTrace();
			return new ResponseEntity<CuentaResponseRest>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CuentaResponseRest>(response , HttpStatus.OK);
	}

	
	


}
