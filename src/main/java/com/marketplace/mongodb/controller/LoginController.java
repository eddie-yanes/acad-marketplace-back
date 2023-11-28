package com.marketplace.mongodb.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.mongodb.model.Usuario;
import com.marketplace.mongodb.repository.IUsuario;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IUsuario usuarioRepo;
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping
	public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuario) {
		
		try {
			
			LOG.info("Consumiendo servicio POST /login/" + usuario);
			
			Map<String, Object> body = new HashMap<>();
			
			Optional<Usuario> usuarioLogin = usuarioRepo.findByCorreo(usuario.getCorreo());
			
			if(usuarioLogin.isPresent()) {
				body.put("status", 0);
				body.put("objError", null);
				body.put("objResponse", usuarioLogin.get());
			} else {
				body.put("status", 1);
				body.put("objError", null);
				body.put("objResponse", null);
			}
			
			return ResponseEntity.ok(body);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
