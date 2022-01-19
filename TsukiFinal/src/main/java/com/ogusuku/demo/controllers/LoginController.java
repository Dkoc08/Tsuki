package com.ogusuku.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autenticacion")
public class LoginController {

	@RequestMapping("/")
	public String index(@RequestParam(value="error", required=false) String error,
	Model model) {
		if(error != null) {
			model.addAttribute("error","Usuario y/o contraseña incorrecta");
		}
		return "/dashboard/autenticacion/index";
	}
}
