package com.marketplace.mongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.mongodb.model.Usuario;
import com.marketplace.mongodb.repository.IUsuario;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private IUsuario usuarioRepo;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(UsuarioController.class);
	
	@GetMapping
	public ResponseEntity<?> findAllUsuarios() {
		
		LOG.info("Consumiendo servicio GET /user/");
		
		try {
			List<Usuario> usuarios = usuarioRepo.findAll();
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {
		try {
			LOG.info("Consumiendo servicio POST /user");
			LOG.info("Request: " + usuario.toString());
			
			Usuario userSave = usuarioRepo.save(usuario);
			return new ResponseEntity<Usuario>(userSave, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
