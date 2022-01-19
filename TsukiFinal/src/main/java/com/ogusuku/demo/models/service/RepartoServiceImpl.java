package com.ogusuku.demo.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.IRepartoDAO;
import com.ogusuku.demo.models.entity.Reparto;

@Service
public class RepartoServiceImpl implements IRepartoService{

	@Autowired
	private IRepartoDAO repartoDAO;
	
	@Override
	public void guardar(Reparto reparto) {
		repartoDAO.save(reparto);
	}

	@Override
	public List<Reparto> listarRepartos() {
		return (List<Reparto>)repartoDAO.findAll();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repartoDAO.deleteById(id);
	} 

}
