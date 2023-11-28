package com.marketplace.mongodb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.mongodb.model.Categoria;
import com.marketplace.mongodb.repository.ICategoria;

@RestController
@RequestMapping("/cat")
public class CategoriaController {
	
	@Autowired
	private ICategoria categoriaRepo;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(CategoriaController.class);
	
	@GetMapping
	public ResponseEntity<?> findAllCategorias() {
		
		LOG.info("Consumiendo servicio GET /cat");
		
		try {
			List<Categoria> categorias = categoriaRepo.findAll();
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", categorias);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveCategoria(@RequestBody Categoria categoria) {
		try {
			
			LOG.info("Consumiendo servicio POST /cat");
			LOG.info("Request: " + categoria.toString());
			
			Categoria categorySave = categoriaRepo.save(categoria);
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", categorySave);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
