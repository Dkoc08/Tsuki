package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ogusuku.demo.models.entity.Repartidor;
import com.ogusuku.demo.models.service.IRepartidorService;

@Controller
@RequestMapping("/repartidor")
public class RepartidorController {
	
	@Autowired
	private IRepartidorService repartidorService;
	
	@RequestMapping("/")
	public String repartidor(Model model) {
		Repartidor repartidor = new Repartidor();
		model.addAttribute("repartidor", repartidor);
		model.addAttribute("listaRepartidor", repartidorService.findAll());
		return "dashboard/repartidor/repartidor";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Repartidor repartidor) {
		repartidorService.save(repartidor);
		return "redirect:/repartidor/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		repartidorService.delete(id);
		return "redirect:/repartidor/";
	}
}
