package com.ogusuku.demo.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.IDetallePedidoDAO;
import com.ogusuku.demo.models.entity.DetallePedido;

@Service

public class DetallePedidoServiceImpl implements IDetallePedidoService{

	@Autowired
	private IDetallePedidoDAO detalleDAO;
		
	@Override
	public void save(DetallePedido detallePedido) {
		detalleDAO.save(detallePedido);
		
	}

	@Override
	public List<DetallePedido> findAll() {
		return (List<DetallePedido>)detalleDAO.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		detalleDAO.deleteById(id);
		
	}

}
