package com.ogusuku.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ogusuku.demo.models.entity.Cliente;

public interface IClienteDAO1 extends CrudRepository<Cliente, Long> {
		public Cliente  findByDni(String dni);
}
