package com.ogusuku.demo.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.IReciboDAO;
import com.ogusuku.demo.models.entity.Recibo;

@Service
public class ReciboServiceImpl implements IReciboService{

	@Autowired
	private IReciboDAO reciboDAO;
	
	
	
	@Override
	public void save(Recibo recibo) {
		reciboDAO.save(recibo);
		
	}

	@Override
	public List<Recibo> findAll() {
		return (List<Recibo>)reciboDAO.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		reciboDAO.deleteById(id);
		
	}

	@Override
	public void guardarRecibo(Recibo recibo) {
		reciboDAO.save(recibo);
		
	}


}
