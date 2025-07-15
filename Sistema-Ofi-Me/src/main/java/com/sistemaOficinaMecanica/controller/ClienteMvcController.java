package com.sistemaOficinaMecanica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemaOficinaMecanica.dto.ClienteDTO;
import com.sistemaOficinaMecanica.model.Cliente;
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
	public String listarClientes(Model model) {
	    List<Cliente> clientes = servic.listarTodos();
	    model.addAttribute("clientes", clientes);
	    return "clientes"; // Vai procurar 'templates/clientes.html'
	}

	
	@GetMapping("/novo")
	public String novoForm(Model model) {
		model.addAttribute("cliente", new ClienteDTO());
		return "clientes-form";
	}
	

	
	@PostMapping
	public String salvar(@ModelAttribute("cliente") ClienteDTO dto) {
		servic.salvar(dto); //O salvar esta dando erro?
		return "redirect:/clientes";
	}
}
