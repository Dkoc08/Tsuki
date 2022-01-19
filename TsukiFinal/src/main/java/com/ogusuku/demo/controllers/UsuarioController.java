package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ogusuku.demo.models.entity.Usuario;
import com.ogusuku.demo.models.service.IRolService;
import com.ogusuku.demo.models.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IRolService rolService;
	
	@RequestMapping("/")
	public String usuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaUsuarios", usuarioService.findAll());
		model.addAttribute("listaRol", rolService.findAll());
		return "dashboard/usuarios/usuarios";
	}

	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String guardar(Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/usuarios/";
	}

}
