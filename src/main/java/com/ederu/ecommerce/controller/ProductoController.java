package com.ederu.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
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
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto=optionalProducto.get();
		LOOGER.info("Producto buscado: {}",producto);
		model.addAttribute("producto", producto);
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto) {
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	@PostMapping(path ="/mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public String recibirId(@RequestBody String user,  Model model) {
		LOOGER.info("Este es la cadena recibida: {}", user );
		String[] splitted = user.split("&");
		splitted=splitted[splitted.length-1].split("=");
		model.addAttribute("usuario", splitted[1]);
		return "productos/mostrar";
	}
	
	@GetMapping("/mostrar2")
	public String mostrar2() {
		return "productos/mostrar2";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		productoService.delete(id);
		return "redirect:/productos";
	}
}
