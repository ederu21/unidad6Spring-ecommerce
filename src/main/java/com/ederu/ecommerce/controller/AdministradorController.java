package com.ederu.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ederu.ecommerce.model.Orden;
import com.ederu.ecommerce.model.Producto;
import com.ederu.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private ProductoService productoService;
	
	private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

	
	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos= productoService.findAll();
		model.addAttribute("productos",productos);
		
		return "administrador/home";
	}
	
	
}
