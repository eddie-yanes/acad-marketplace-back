package com.marketplace.mongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.marketplace.mongodb.model.Pregunta;

public interface IPregunta extends MongoRepository<Pregunta, Integer> {
	
	@Query("{ 'producto.idProducto': ?0 }")
	public List<Pregunta> findByIdProducto(int idProducto);
}
