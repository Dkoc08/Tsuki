package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String inicio(Model model) {
		return "index";
	}
	
	@RequestMapping("nosotros")
	public String nosotros(Model model) {
		return "menu";
	}
	@RequestMapping("/catalogo")
	public String catalogo(Model model) {
		return "catalogo";
	}
	@RequestMapping("/contacto")
	public String contacto(Model model) {
		return "contact";
	}
}
