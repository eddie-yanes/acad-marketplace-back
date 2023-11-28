package com.marketplace.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tiendas")
public class Tienda {
	
	@Id
	private int id;
	
	private int idTienda;
	private String nombre;
	private String urlLogo;
	private String telefono;
	private String correo;
	
	public Tienda() {
		super();
	}

	public Tienda(int id, int idTienda, String nombre, String urlLogo, String telefono, String correo) {
		super();
		this.id = id;
		this.idTienda = idTienda;
		this.nombre = nombre;
		this.urlLogo = urlLogo;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Tienda [id=" + id + ", idTienda=" + idTienda + ", nombre=" + nombre + ", urlLogo=" + urlLogo
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
	
	
}
