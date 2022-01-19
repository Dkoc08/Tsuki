package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ogusuku.demo.models.entity.Pedido;
import com.ogusuku.demo.models.service.IClienteService;
import com.ogusuku.demo.models.service.IPedidoService;
import com.ogusuku.demo.models.service.IUsuarioService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping("/")
	public String pedido(Model model) {
		Pedido pedido = new Pedido();
		model.addAttribute("pedido", pedido);
		model.addAttribute("listaPedido", pedidoService.findAll());
		model.addAttribute("listaCliente", clienteService.findAll());
		model.addAttribute("listaUsuario", usuarioService.findAll());
		return "dashboard/pedido/pedido";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Pedido pedido) {
		pedidoService.save(pedido);
		return "redirect:/pedido/";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		pedidoService.delete(id);
		return "redirect:/pedido/";
	}
}
