package com.ogusuku.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ogusuku.demo.models.entity.Cliente;
import com.ogusuku.demo.models.service.IClienteService;
import com.ogusuku.demo.models.service.IDistritoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IDistritoService distritoService;
	
	@RequestMapping("/")
	public String cliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("listaClientes", clienteService.findAll());
		model.addAttribute("listaDistrito", distritoService.findAll());
		return "dashboard/clientes/clientes";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash ) {
		if(result.hasErrors()) {
			model.addAttribute("listaClientes", clienteService.findAll());
			model.addAttribute("listaDistrito", distritoService.findAll());
			return "dashboard/clientes/clientes";
		}
		if(clienteService.verificarExisteCategoria(cliente.getDni())) {
			clienteService.save(cliente);
		}else {
			flash.addFlashAttribute("error", "El cliente ingresado ya existe");
		}
		return "redirect:/clientes/";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
		return "redirect:/clientes/";
	}
}
