package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ogusuku.demo.models.entity.Producto;
import com.ogusuku.demo.models.service.ICategoriaService;
import com.ogusuku.demo.models.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IProductoService productoService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Producto producto= new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", categoriaService.findAll());
		model.addAttribute("listaProductos", productoService.findAll());
		return "dashboard/producto/producto";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(Producto producto) {
		productoService.save(producto);
		return"redirect:/producto/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		productoService.delete(id);
		return "redirect:/producto/";
	}
	
}
