package com.ogusuku.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ogusuku.demo.models.dao.IProductoDAO;
import com.ogusuku.demo.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	public void save(Producto producto) {
		productoDAO.save(producto);
		
	}

	@Override
	public List<Producto> findAll() {
		return(List<Producto>)productoDAO.findAll();
		//return productoDAO.findAllByOrderBySaborAsc();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDAO.deleteById(id);
	}

	/*@Override
	public Boolean verificarExisteProducto(String sabor) {
		List<Producto> lista = productoDAO.findBySabor(sabor);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;
		}else {
			rpta = false;
		}
		return rpta;
	}*/

	@Override
	public Producto buscarProducto(long id) {
		return productoDAO.findById(id).orElse(null);
	}



	

	
}