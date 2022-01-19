package com.ogusuku.demo.models.service;

import java.util.List;

import com.ogusuku.demo.models.entity.Usuario;

public interface IUsuarioService {
	public void save (Usuario usuario);
	public List<Usuario> findAll();
}
