package com.ogusuku.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogusuku.demo.models.dao.ICategoriaDAO;
import com.ogusuku.demo.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

		@Autowired
		private ICategoriaDAO categoriaDAO;
	@Override
	public void save(Categoria categoria) {
		categoriaDAO.save(categoria);
		
	}

	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>)categoriaDAO.findAll();
		//return categoriaDAO.findAllByOrderByNombreAsc();
	}

	@Override
	public Boolean verificarExisteCategoria(String nombre) {
		List<Categoria> lista = categoriaDAO.findByNombre(nombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;
		}else {
			rpta = false;
		}
		return rpta;
	}

	
}
