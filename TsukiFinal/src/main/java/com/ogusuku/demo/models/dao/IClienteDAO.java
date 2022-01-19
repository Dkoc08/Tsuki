package com.ogusuku.demo.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ogusuku.demo.models.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	public List<Cliente> findByDni(String dni);
	
}
