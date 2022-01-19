package com.ogusuku.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.IDistritoDAO;
import com.ogusuku.demo.models.entity.Distrito;

@Service
public class DistritoServiceImpl implements IDistritoService{

	@Autowired
	private IDistritoDAO distritoDAO;
	
	
	@Override
	public List<Distrito> findAll() {
		//return (List<Distrito>)distritoDAO.findAll();
		return distritoDAO.findAllByOrderByNombreAsc();
	}

}
