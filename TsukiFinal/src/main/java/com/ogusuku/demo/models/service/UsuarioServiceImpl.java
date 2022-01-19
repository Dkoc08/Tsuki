package com.ogusuku.demo.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ogusuku.demo.models.dao.IUsuarioDAO;
import com.ogusuku.demo.models.entity.Rol;
import com.ogusuku.demo.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService , UserDetailsService{

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	private Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException{
		
		Usuario user = usuarioDAO.findByUsuario(usuario);
		
		if(user == null) {
			log.error("Error login: El usuario ingresado no existe");
			throw new UsernameNotFoundException("Usuario no existe");
		}
		
		List<GrantedAuthority> listaRoles = new ArrayList<>();
		for(Rol item: user.getRoles()) {
			listaRoles.add(new SimpleGrantedAuthority(item.getAuthority()));
		}
		
		if(listaRoles.isEmpty()) {
			log.error("Error login: Usuario no tiene roles asignados");
			throw new UsernameNotFoundException("Usuario no tiene rol asignado");
		}
		
		return new User(user.getUsuario(), user.getPassword(), user.getEnabled(),true,true,true,listaRoles);
	}
	
	@Override
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>)usuarioDAO.findAll();
	}
	
	

}
