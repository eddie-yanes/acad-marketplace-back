package com.marketplace.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.marketplace.mongodb.model.Categoria;

public interface ICategoria extends MongoRepository<Categoria, Integer> {

}
