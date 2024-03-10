package com.bluesoft.prueba.bluesoft.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bluesoft.prueba.bluesoft.model.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {
	@Query("select l from Cliente l where  l.cedula = ?1")
	Optional<Cliente> findByCedula(int cedula);

}
