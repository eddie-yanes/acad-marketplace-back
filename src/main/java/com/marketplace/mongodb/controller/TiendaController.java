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
import com.marketplace.mongodb.model.Tienda;
import com.marketplace.mongodb.repository.ITienda;

@RestController
@RequestMapping("/tienda")
public class TiendaController {
	
	@Autowired
	private ITienda tiendaRepo;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(TiendaController.class);
	
	@GetMapping
	public ResponseEntity<?> findAllTiendas() {
		
		LOG.info("Consumiendo servicio GET /tienda");
		
		try {
			List<Tienda> tiendas = tiendaRepo.findAll();
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", tiendas);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveTienda(@RequestBody Tienda tienda) {
		try {
			
			LOG.info("Consumiendo servicio POST /tienda");
			LOG.info("Request: " + tienda.toString());
			
			Tienda shopSave = tiendaRepo.save(tienda);
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", shopSave);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
