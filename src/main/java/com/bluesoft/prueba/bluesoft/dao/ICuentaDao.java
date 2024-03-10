package com.bluesoft.prueba.bluesoft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bluesoft.prueba.bluesoft.model.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta,Long>{
	
	@Query("select l from Cuenta l where  l.numeroCuenta = ?1")
	List<Cuenta> seeSaldoByCuenta(int numeroCuenta);

}
