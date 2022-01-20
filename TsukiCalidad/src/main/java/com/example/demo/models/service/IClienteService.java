package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Cliente;
import com.example.demo.models.entity.Producto;


public interface IClienteService {
	public void save(Cliente cliente);
	public List<Cliente> findAll();
	public void delete(Long id);
	public Boolean verificarExisteCategoria(String dni);
	public Cliente buscarCliente(String dni);
	
	public List<Producto> buscarProducto(String term);


}
