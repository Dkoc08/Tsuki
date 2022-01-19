package com.ogusuku.demo.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.IPedidoDAO;
import com.ogusuku.demo.models.entity.Pedido;


@Service
public class PedidoServiceImpl implements IPedidoService{

	@Autowired
	
	private IPedidoDAO pedidoDAO;
	
	@Override
	public void save(Pedido pedido) {
		pedidoDAO.save(pedido);
		
	}

	@Override
	public List<Pedido> findAll() {
		return(List<Pedido>)pedidoDAO.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		pedidoDAO.deleteById(id);
		
	}

}
