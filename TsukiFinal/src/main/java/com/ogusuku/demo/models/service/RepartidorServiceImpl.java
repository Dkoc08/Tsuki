package com.ogusuku.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.IRepartidorDAO;
import com.ogusuku.demo.models.entity.Repartidor;

@Service
public class RepartidorServiceImpl implements IRepartidorService{

	@Autowired
	private IRepartidorDAO repartidorDAO;
	
	@Override
	public void save(Repartidor repartidor) {
		repartidorDAO.save(repartidor);
	}

	@Override
	public List<Repartidor> findAll() {
		return (List<Repartidor>)repartidorDAO.findAll();
	}

	@Override
	public void delete(Long id) {
		repartidorDAO.deleteById(id);
	}
	
}
