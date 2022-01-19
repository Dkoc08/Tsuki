package com.ogusuku.demo.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.ogusuku.demo.models.entity.Distrito;

public interface IDistritoDAO extends CrudRepository<Distrito, Long> {
	public List<Distrito> findByNombre(String nombre);
	public List<Distrito> findAllByOrderByNombreAsc();
}
