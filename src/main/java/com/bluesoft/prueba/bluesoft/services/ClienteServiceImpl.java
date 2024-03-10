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

import com.bluesoft.prueba.bluesoft.dao.IClienteDao;
import com.bluesoft.prueba.bluesoft.dao.ICuentaDao;
import com.bluesoft.prueba.bluesoft.dao.IMovimientoDao;
import com.bluesoft.prueba.bluesoft.model.Cuenta;
import com.bluesoft.prueba.bluesoft.model.Movimiento;
import com.bluesoft.prueba.bluesoft.response.ClienteResponseRest;
import com.bluesoft.prueba.bluesoft.model.Cliente;



@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional
	public ResponseEntity<ClienteResponseRest> save(Cliente cliente) {
		ClienteResponseRest response  = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();

		try {
			
			Optional<Cliente> clienteExiste = clienteDao.findByCedula(cliente.getCedula());
			
			if(!clienteExiste.isPresent() ) {
				Cliente ClienteSave= clienteDao.save(cliente);
				
				Movimiento movimientoSave = null;
			
			if( ClienteSave.getNombre() != null && ClienteSave != null  ) {
				list.add(ClienteSave);			 
				response.getListaResponse().setLista(list);
				response.setMetadata("Respuesta ok", "00", "registro guardado");
			}
		}else {
			
			return new ResponseEntity<ClienteResponseRest>(response , HttpStatus.BAD_REQUEST);
		}	
		}catch(Exception e) {
			response.setMetadata("Respuesta Fallida", "500", "Error guardando");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response , HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ClienteResponseRest>(response , HttpStatus.CREATED);

	}

	
	


}
