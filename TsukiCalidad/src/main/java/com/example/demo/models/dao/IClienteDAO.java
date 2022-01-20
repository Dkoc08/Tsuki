package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	public List<Cliente> findByDni(String dni);
	
}
