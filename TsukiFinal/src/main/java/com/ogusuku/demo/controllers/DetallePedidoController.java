package com.ogusuku.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ogusuku.demo.models.entity.DetallePedido;
import com.ogusuku.demo.models.service.ICategoriaService;
import com.ogusuku.demo.models.service.IDetallePedidoService;
import com.ogusuku.demo.models.service.IPedidoService;


@Controller
@RequestMapping("/detalle")
public class DetallePedidoController {
	@Autowired
	private IDetallePedidoService detalleService;
	
	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping("/")
	public String detallePedido(Model model) {
		DetallePedido detallePedido = new DetallePedido();
		model.addAttribute("detallePedido", detallePedido);
		model.addAttribute("listaDetallePedido", detalleService.findAll());
		model.addAttribute("listaPedido", pedidoService.findAll());
		model.addAttribute("listaCategoria", categoriaService.findAll());
		return "dashboard/pedido/detalle";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(DetallePedido detallePedido) {
		detalleService.save(detallePedido);
		return "redirect:/pedido/";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		detalleService.delete(id);
		return "redirect:/pedido/";
	}
	
	@RequestMapping("/listadetalle")
	public String listapedido(Model model) {
		DetallePedido detallePedido = new DetallePedido();
		model.addAttribute("detallePedido", detallePedido);
		model.addAttribute("listaDetallePedido", detalleService.findAll());
		model.addAttribute("listaPedido", pedidoService.findAll());
		model.addAttribute("listaCategoria", categoriaService.findAll());
		return "dashboard/pedido/listadetalle";
	}
	
	
}
