package com.ogusuku.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ogusuku.demo.models.entity.Pedido;

public interface IPedidoDAO extends CrudRepository<Pedido, Long>{

}
