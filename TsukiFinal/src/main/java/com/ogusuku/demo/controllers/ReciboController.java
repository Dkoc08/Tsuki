package com.ogusuku.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ogusuku.demo.models.entity.Cliente;
import com.ogusuku.demo.models.entity.DetalleRecibo;
import com.ogusuku.demo.models.entity.Producto;
import com.ogusuku.demo.models.entity.Recibo;
import com.ogusuku.demo.models.service.IClienteService;
import com.ogusuku.demo.models.service.IProductoService;
import com.ogusuku.demo.models.service.IReciboService;



@Controller
@RequestMapping("/recibo")
public class ReciboController {
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IReciboService reciboService;
	
	@Autowired
	IProductoService productoService;
	
	
	@RequestMapping("/")
	public String inicio() {
		return "dashboard/recibo/recibo";
	}
	@RequestMapping(value= "/buscar", method = RequestMethod.POST)
	public String buscar(String dni, Model model, RedirectAttributes flash) {
		Cliente cliente =clienteService.buscarCliente(dni);
		if(cliente==null) {
			flash.addFlashAttribute("error", "El cliente no existe");
			return "redirect:/recibo/";
		}
		Recibo recibo= new Recibo();
		recibo.setCliente(cliente);
		model.addAttribute("recibo", recibo);
		return"dashboard/recibo/vender";
		
	}
	@RequestMapping(value="/cargar_producto/{term}", produces= {"application/json"})
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term){
		return clienteService.buscarProducto(term);
	}
	
	@RequestMapping("/form")
	public String guardar(Recibo recibo,
			@RequestParam(name = "item_id[]", required =true) Integer[] itemId,
			@RequestParam(name = "cantidad[]", required = true) Integer[] cantidad,
			RedirectAttributes flash,
	        SessionStatus status) {
		
		
		for(int i=0; i<itemId.length; i++) {
			Producto producto = productoService.buscarProducto(itemId[i]);
			
				DetalleRecibo linea=new DetalleRecibo();
				linea.setCantidad(cantidad[i]);
				linea.setProducto(producto);
				recibo.addDetalleFactura(linea);
		}
		
		reciboService.guardarRecibo(recibo);
		status.setComplete();
		
		flash.addFlashAttribute("success", "Recibo registrado con éxito");
		
		return "redirect:/recibo/";
	
}
}
