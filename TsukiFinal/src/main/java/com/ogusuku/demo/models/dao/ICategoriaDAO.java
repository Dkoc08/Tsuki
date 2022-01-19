package com.ogusuku.demo.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.ogusuku.demo.models.entity.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long> {
	public List<Categoria> findAllByOrderByNombre();
	public List<Categoria> findByNombre(String nombre);
	
	
	
}
