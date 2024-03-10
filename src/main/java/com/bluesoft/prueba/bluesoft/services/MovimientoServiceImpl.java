package com.bluesoft.prueba.bluesoft.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import com.bluesoft.prueba.bluesoft.dao.IMovimientoDao;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.model.Movimiento;
import com.bluesoft.prueba.bluesoft.response.CuentaResponseRest;
import com.bluesoft.prueba.bluesoft.response.MovimientoResponseRest;



@Service
public class MovimientoServiceImpl implements IMovimientoService {
	
	@Autowired
	private IMovimientoDao movimientoDao;
	
	@Override
	@Transactional
	public ResponseEntity<MovimientoResponseRest> save(Movimiento movimiento) {
		MovimientoResponseRest response  = new MovimientoResponseRest();
		List<Movimiento> list = new ArrayList<>();

		try {
				LocalDate hoy = LocalDate.now();
		        LocalTime ahora = LocalTime.now();
				movimiento.setFechaHora(LocalDateTime.of(hoy, ahora));
				Movimiento movimientoSave= movimientoDao.save(movimiento);	
				list.add(movimientoSave);			 
				response.getListaResponse().setLista(list);
				response.setMetadata("Respuesta ok", "00", "registro guardado ");
			
		
		}catch(Exception e) {
			System.out.print(e);
			response.setMetadata("Respuesta Fallida", "500", "Error guardando");
			e.getStackTrace();
			return new ResponseEntity<MovimientoResponseRest>(response , HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<MovimientoResponseRest>(response , HttpStatus.CREATED);

	}
	
	@Override
	public ResponseEntity<MovimientoResponseRest> extractoMensual(int numeroCuenta) {
		MovimientoResponseRest response = new MovimientoResponseRest();
		
		Date fecha = new Date();
		try {
			
			List<Movimiento> movimientos = movimientoDao.extracto(numeroCuenta);
			response.getListaResponse().setLista(movimientos);
			response.setMetadata("Exito", "200", fecha.toString());

		}catch(Exception e) {
			System.out.println(e);
			response.setMetadata("Respuesta Fallida", "500", fecha.toString());
			e.getStackTrace();
			return new ResponseEntity<MovimientoResponseRest>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<MovimientoResponseRest>(response , HttpStatus.OK);
	}


	
	


}
