package com.ogusuku.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ogusuku.demo.models.entity.DetallePedido;

public interface IDetallePedidoDAO extends CrudRepository<DetallePedido, Long> {

}
