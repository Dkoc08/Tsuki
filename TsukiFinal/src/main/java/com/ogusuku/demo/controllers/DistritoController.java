package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ogusuku.demo.models.service.IDistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {
	@Autowired
	private IDistritoService distritoService;
	
	@RequestMapping("/")
	public String distrito(Model model) {
		model.addAttribute("listaDistrito", distritoService.findAll());
		return "dashboard/distrito/distrito";
	}
}
