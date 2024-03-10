package com.bluesoft.prueba.bluesoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bluesoft.prueba.bluesoft.model.Movimiento;

public interface IMovimientoDao extends CrudRepository<Movimiento,Long>{
	@Query("select m from Movimiento m , Cuenta c   where  c.numeroCuenta = ?1 and c.id = m.cuenta.id")
	List<Movimiento> extracto(int numeroCuenta);
}

