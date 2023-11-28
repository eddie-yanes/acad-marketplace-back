package com.marketplace.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "resenas")
public class Resena {
	
	@Id
	private int id;
	private int idResena;
	private Producto producto;
	private int calificacion;
	private String resena;
	private String fechaHora;
	private Usuario usuario;
	
	public Resena() {
		super();
	}

	public Resena(int id, int idResena, Producto producto, int calificacion, String resena, String fechaHora,
			Usuario usuario) {
		super();
		this.id = id;
		this.idResena = idResena;
		this.producto = producto;
		this.calificacion = calificacion;
		this.resena = resena;
		this.fechaHora = fechaHora;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdResena() {
		return idResena;
	}

	public void setIdResena(int idResena) {
		this.idResena = idResena;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Resena [id=" + id + ", idResena=" + idResena + ", producto=" + producto + ", calificacion="
				+ calificacion + ", resena=" + resena + ", fechaHora=" + fechaHora + ", usuario=" + usuario + "]";
	}
	
	
}
