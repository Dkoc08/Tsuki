package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Producto;

public interface IProductoService {
	public void save(Producto producto);
	public List<Producto> findAll();
	public void delete(Long id);
	//public Boolean verificarExisteProducto(String sabor);
	public Producto buscarProducto(long id);
	
}
