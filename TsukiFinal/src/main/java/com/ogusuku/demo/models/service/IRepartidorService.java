package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Repartidor;

public interface IRepartidorService {
	public void save(Repartidor repartidor);
	public List<Repartidor> findAll();
	public void delete(Long id);
}
