package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Recibo;

public interface IReciboService {
	public void save(Recibo recibo);
	public List<Recibo> findAll();
	public void delete(Long id);
	 public void guardarRecibo(Recibo recibo);
}
