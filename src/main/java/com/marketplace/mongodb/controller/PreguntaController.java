package com.marketplace.mongodb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.marketplace.mongodb.model.Pregunta;
import com.marketplace.mongodb.model.Producto;
import com.marketplace.mongodb.model.Usuario;
import com.marketplace.mongodb.repository.IPregunta;
import com.marketplace.mongodb.service.SequenceService;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	private IPregunta preguntaRepo;
	
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private SequenceService sequenceService;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(PreguntaController.class);
	
	@GetMapping(value = "/{idproducto}")
	public ResponseEntity<?> findByProductResenas(@PathVariable("idproducto") int idProducto) {
		
		LOG.info("Consumiendo servicio GET /pregunta/" + idProducto);
		
		try {
			List<Pregunta> preguntas = preguntaRepo.findByIdProducto(idProducto);
			
			Map<String, Object> body = new HashMap<>();
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", preguntas);
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> savePregunta(@RequestBody Pregunta pregunta) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm.SSS");
		Map<String, Object> body = new HashMap<>();
		
		try {
			int seqId = sequenceService.getNextSequence("pregunta");
			
			pregunta.setId(seqId);
			pregunta.setIdPregunta(seqId);
			pregunta.setFechaHoraPreg(sdf.format(new Date()));
			
			usuario.setCorreo("null");
			pregunta.setRespuesta("null");
			pregunta.setUsuarioResp(usuario);
			
			LOG.info("Consumiendo servicio POST /pregunta");
			LOG.info("Request: " + pregunta.toString());
			
			Pregunta questionSave = preguntaRepo.save(pregunta);
			
			body.put("status", 0);
			body.put("objError", null);
			body.put("objResponse", questionSave);
			
			return ResponseEntity.ok(body);
			
		} catch (Exception e) {
			
			body.put("status", 1);
			body.put("objError", null);
			body.put("objResponse", null);
			
			e.printStackTrace();
			return ResponseEntity.ok(body);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updatePregunta(@RequestBody Pregunta pregunta) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm.SSS");
		Map<String, Object> body = new HashMap<>();
		Optional<Pregunta> getPreg = preguntaRepo.findById(pregunta.getId());
		
		try {
			
			if(getPreg.isPresent()) {
				
				getPreg.get().setUsuarioResp(pregunta.getUsuarioResp());
				getPreg.get().setRespuesta(pregunta.getRespuesta());
				getPreg.get().setFechaHoraResp(sdf.format(new Date()));
				
				LOG.info("Consumiendo servicio PUT /pregunta");
				LOG.info("Requedst: " + pregunta.toString());
				
				Pregunta questionSave = preguntaRepo.save(getPreg.get());
				
				body.put("status", 0);
				body.put("objError", null);
				body.put("objResponse", questionSave);
			}
			
			return ResponseEntity.ok(body);
			
		} catch (Exception e) {
			
			body.put("status", 1);
			body.put("objError", null);
			body.put("objResponse", null);
			
			e.printStackTrace();
			return ResponseEntity.ok(body);
		}
	}
	
}
