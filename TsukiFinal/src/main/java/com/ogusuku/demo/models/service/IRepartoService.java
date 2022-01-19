package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Reparto;

public interface IRepartoService {
	public void guardar(Reparto reparto);
	public List<Reparto> listarRepartos();
	public void delete(Long id);
}
