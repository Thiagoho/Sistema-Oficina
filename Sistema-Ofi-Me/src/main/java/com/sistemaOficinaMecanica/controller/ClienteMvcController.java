package com.sistemaOficinaMecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemaOficinaMecanica.servic.ClienteServic;

@Controller
@RequestMapping("/clientes")
public class ClienteMvcController {
	
	private final ClienteServic servic;
	
	@Autowired
	public ClienteMvcController(ClienteServic servic) {
		this.servic = servic;
		
	}
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("clientes", servic.listarTodos());
		return "clientes"; // Nome do HTML na pasta /templates
	}
}
