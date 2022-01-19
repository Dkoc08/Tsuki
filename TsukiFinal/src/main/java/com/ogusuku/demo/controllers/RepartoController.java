package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ogusuku.demo.models.entity.Reparto;
import com.ogusuku.demo.models.service.IPedidoService;
import com.ogusuku.demo.models.service.IRepartidorService;
import com.ogusuku.demo.models.service.IRepartoService;

@Controller
@RequestMapping("/reparto")
public class RepartoController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private IRepartidorService repartidorService;
	
	@Autowired
	private IRepartoService repartoService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Reparto reparto = new Reparto();
		model.addAttribute("reparto", reparto);
		model.addAttribute("listaPedidos", pedidoService.findAll());
		model.addAttribute("listaRepartidor", repartidorService.findAll());
		model.addAttribute("listaRepartos", repartoService.listarRepartos());
		return "dashboard/reparto/reparto";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Reparto reparto) {
		repartoService.guardar(reparto);
		return "redirect:/reparto/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		repartoService.delete(id);
		return "redirect:/reparto/";
	}
	
	
}
