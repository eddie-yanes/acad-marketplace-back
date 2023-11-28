package com.marketplace.mongodb.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.marketplace.mongodb.model.Usuario;

public interface IUsuario extends MongoRepository<Usuario, Integer> {
	
	public Optional<Usuario> findByCorreo(String correo);
	
}
