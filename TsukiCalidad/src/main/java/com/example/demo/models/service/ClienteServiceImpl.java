package com.example.demo.models.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IClienteDAO;
import com.example.demo.models.dao.IClienteDAO1;
//import com.example.demo.models.dao.IProductoDAO;
import com.example.demo.models.entity.Cliente;
import com.example.demo.models.entity.Producto;



@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Autowired
	private IClienteDAO1 clienteDAO1;
	
	//@Autowired
	//private IProductoDAO productoDAO;
	
	@Override
	public void save(Cliente cliente) {
		clienteDAO.save(cliente);		
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDAO.findAll();
	}
	

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDAO.deleteById(id);
	}

	@Override
	public Boolean verificarExisteCategoria(String dni) {
		List<Cliente> lista = clienteDAO.findByDni(dni);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;
		}else {
			rpta = false;
		}
		return rpta;
	}

	@Override
	public Cliente buscarCliente(String dni) {
		return clienteDAO1.findByDni(dni);
	}

	@Override
	public List<Producto> buscarProducto(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<Producto> buscarProducto(String term) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public List<Producto> buscarProducto(String term) {
		return productoDAO.findByNombre(term);
	}*/

	


	

}
