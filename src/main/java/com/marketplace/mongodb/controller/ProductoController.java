package com.marketplace.mongodb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.mongodb.model.Producto;
import com.marketplace.mongodb.repository.IProducto;
import com.marketplace.mongodb.service.SequenceService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProducto productoRepo;
	
	@Autowired
	private SequenceService sequenceService;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(ProductoController.class);
	
	@GetMapping(value = "/{tipobusqueda}/{valor}")
	public ResponseEntity<?> findAllProductos(@PathVariable("tipobusqueda") String tipoBusqueda, @PathVariable("valor") int valor) {
		
		LOG.info("Consumiendo servicio GET /producto/" + tipoBusqueda + "/" + valor);
		
		List<Producto> productos = new ArrayList<>();
		
		try {
			switch (tipoBusqueda) {
			case "P":
				Optional<Producto> producto = productoRepo.findByIdProducto(valor);
				
				if(producto.isPresent()) {
					productos.add(producto.get());
				}
				
				break;
				
			case "T":
				productos = productoRepo.findByIdTienda(valor);
				break;
				
			default:
				productos = productoRepo.findAll();
			}
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", productos);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveProducto(@RequestBody Producto producto) {
		try {
			
			int seqId = sequenceService.getNextSequence("producto");
			
			producto.setId(seqId);
			producto.setIdProducto(seqId);
			
			LOG.info("Consumiendo servicio POST /producto");
			LOG.info("Request: " + producto.toString());
			
			Producto productSave = productoRepo.save(producto);
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", productSave);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateProducto(@RequestBody Producto producto) {
		try {
			
			Producto productSave = null;
			Optional<Producto> getProd = productoRepo.findByIdProducto(producto.getIdProducto());
			Map<String, Object> body = new HashMap<>();
			
			if(getProd.isPresent()) {
				producto.setId(getProd.get().getId());
				
				LOG.info("Consumiendo servicio PUT /producto");
				LOG.info("Request: " + producto.toString());
				
				productSave = productoRepo.save(producto);
				
				body.put("status", 0);
				body.put("objError", null);
				body.put("objResponse", productSave);
			}
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
