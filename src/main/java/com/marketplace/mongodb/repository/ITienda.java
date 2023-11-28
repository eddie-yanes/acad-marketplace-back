package com.marketplace.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.marketplace.mongodb.model.Tienda;

public interface ITienda extends MongoRepository<Tienda, Integer> {

}
