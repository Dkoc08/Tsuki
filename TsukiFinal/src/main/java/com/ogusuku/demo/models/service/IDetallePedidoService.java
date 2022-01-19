package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.DetallePedido;

public interface IDetallePedidoService {
	public void save(DetallePedido detallePedido);
	public List<DetallePedido> findAll();
	public void delete(Long id);
}
