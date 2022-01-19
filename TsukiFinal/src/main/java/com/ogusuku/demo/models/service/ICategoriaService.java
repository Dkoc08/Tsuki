package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Categoria;

public interface ICategoriaService {
	public void save(Categoria categoria);
	public List<Categoria> findAll();
	public Boolean verificarExisteCategoria(String nombre);
}
