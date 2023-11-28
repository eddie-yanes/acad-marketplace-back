package com.marketplace.mongodb.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.marketplace.mongodb.model.Producto;

public interface IProducto extends MongoRepository<Producto, Integer> {
	
	public Optional<Producto> findByIdProducto(int idProducto);
	public List<Producto> findByIdTienda(int idTienda);
}
