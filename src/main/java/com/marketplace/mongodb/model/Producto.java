package com.marketplace.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {
	
	@Id
	private int id;
	private int idProducto;
	private int idTienda;
	private int idCategoria;
	private String nombre;
	private String descripcion;
	private double precio;
	private Foto foto;
	
	public Producto() {
		super();
	}
	
	public Producto(int id, int idProducto, int idTienda, int idCategoria, String nombre, String descripcion,
			double precio, Foto foto) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idTienda = idTienda;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", idProducto=" + idProducto + ", idTienda=" + idTienda + ", idCategoria="
				+ idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", foto="
				+ foto + "]";
	}
	
	
	
	
}
