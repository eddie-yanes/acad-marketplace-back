package com.marketplace.mongodb.controller;

import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.mongodb.model.Resena;
import com.marketplace.mongodb.repository.IResena;
import com.marketplace.mongodb.service.SequenceService;

@RestController
@RequestMapping("/resena")
public class ResenaController {
	
	@Autowired
	private IResena resenaRepo;
	
	@Autowired
	private SequenceService sequenceService;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(ResenaController.class);
	
	@GetMapping(value = "/{idproducto}")
	public ResponseEntity<?> findByProductResenas(@PathVariable("idproducto") int idProducto) {
		
		LOG.info("Consumiendo servicio GET /resena/" + idProducto);
		
		try {
			List<Resena> resenas = resenaRepo.findByIdProducto(idProducto);
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", resenas);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveResena(@RequestBody Resena resena) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm.SSS");
		
		try {
			int seqId = sequenceService.getNextSequence("resena");
			
			resena.setId(seqId);
			resena.setIdResena(seqId);
			resena.setFechaHora(sdf.format(new Date()));
			
			LOG.info("Consumiendo servicio POST /resena");
			LOG.info("Request: " + resena.toString());
			
			Resena reviewSave = resenaRepo.save(resena);
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", reviewSave);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
