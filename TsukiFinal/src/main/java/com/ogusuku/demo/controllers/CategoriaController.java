package com.ogusuku.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ogusuku.demo.models.entity.Categoria;
import com.ogusuku.demo.models.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping("/")
	public String categoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		model.addAttribute("listaCategoria", categoriaService.findAll());
		return"dashboard/categoria/categoria";
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("listaCategoria", categoriaService.findAll());
			return "dashboard/categoria/categoria";
		}
		if(categoriaService.verificarExisteCategoria(categoria.getNombre())) {
			categoriaService.save(categoria);
		}else {
			flash.addFlashAttribute("error", "Categoría ingresada ya existe");
		}
		return "redirect:/categoria/";
	}
}
