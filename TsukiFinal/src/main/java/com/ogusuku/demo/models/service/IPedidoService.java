package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Pedido;

public interface IPedidoService {
	public void save(Pedido pedido);
	public List<Pedido> findAll();
	public void delete(Long id);
	
}
