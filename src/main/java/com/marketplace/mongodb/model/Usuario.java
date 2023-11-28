package com.marketplace.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "usuarios")
public class Usuario {
	@Id
	private int id;
	
	private String correo;
	private String nombre;
	private String clave;
	private String rol;
	private int idTienda;
	private String nomTienda;
	private String urllogo;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String correo, String nombre, String clave, String rol, int idTienda, String nomTienda,
			String urllogo) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.clave = clave;
		this.rol = rol;
		this.idTienda = idTienda;
		this.nomTienda = "";
		this.urllogo = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public String getNomTienda() {
		return nomTienda;
	}

	public void setNomTienda(String nomTienda) {
		this.nomTienda = nomTienda;
	}

	public String getUrllogo() {
		return urllogo;
	}

	public void setUrllogo(String urllogo) {
		this.urllogo = urllogo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo=" + correo + ", nombre=" + nombre + ", clave=" + clave + ", rol=" + rol
				+ ", idTienda=" + idTienda + ", nomTienda=" + nomTienda + ", urllogo=" + urllogo + "]";
	}

	
	
}
