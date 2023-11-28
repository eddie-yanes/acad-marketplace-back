package com.marketplace.mongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.marketplace.mongodb.model.Resena;

public interface IResena extends MongoRepository<Resena, Integer> {
	
	@Query("{ 'producto.idProducto': ?0 }")
	public List<Resena> findByIdProducto(int idProducto);
	
}
