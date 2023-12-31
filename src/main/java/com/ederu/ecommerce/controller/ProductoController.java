package com.ederu.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ederu.ecommerce.model.Producto;
import com.ederu.ecommerce.model.Usuario;
import com.ederu.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOOGER= LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String show() {
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		LOOGER.info("Este es el objeto producto {}", producto );
		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.save(producto);
		return "redirect:/productos";
	}
}
