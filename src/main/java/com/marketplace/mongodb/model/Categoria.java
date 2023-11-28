package com.marketplace.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class Categoria {
	
	@Id
	private int id;
	
	private int idCategoria;
	private String nombre;
	
	public Categoria() {
		super();
	}

	public Categoria(int id, int idCategoria, String nombre) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
	
	
	
}
