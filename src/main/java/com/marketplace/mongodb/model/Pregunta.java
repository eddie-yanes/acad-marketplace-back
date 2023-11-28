package com.marketplace.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preguntas")
public class Pregunta {
	
	@Id
	private int id;
	private int idPregunta;
	private Producto producto;
	private String pregunta;
	private String respuesta;
	private String fechaHoraPreg;
	private String fechaHoraResp;
	private Usuario usuarioPreg;
	private Usuario usuarioResp;
	
	public Pregunta() {
		super();
	}

	public Pregunta(int id, int idPregunta, Producto producto, String pregunta, String respuesta, String fechaHoraPreg,
			String fechaHoraResp, Usuario usuarioPreg, Usuario usuarioResp) {
		super();
		this.id = id;
		this.idPregunta = idPregunta;
		this.producto = producto;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.fechaHoraPreg = fechaHoraPreg;
		this.fechaHoraResp = fechaHoraResp;
		this.usuarioPreg = usuarioPreg;
		this.usuarioResp = usuarioResp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getFechaHoraPreg() {
		return fechaHoraPreg;
	}

	public void setFechaHoraPreg(String fechaHoraPreg) {
		this.fechaHoraPreg = fechaHoraPreg;
	}

	public String getFechaHoraResp() {
		return fechaHoraResp;
	}

	public void setFechaHoraResp(String fechaHoraResp) {
		this.fechaHoraResp = fechaHoraResp;
	}

	public Usuario getUsuarioPreg() {
		return usuarioPreg;
	}

	public void setUsuarioPreg(Usuario usuarioPreg) {
		this.usuarioPreg = usuarioPreg;
	}

	public Usuario getUsuarioResp() {
		return usuarioResp;
	}

	public void setUsuarioResp(Usuario usuarioResp) {
		this.usuarioResp = usuarioResp;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", idPregunta=" + idPregunta + ", producto=" + producto + ", pregunta=" + pregunta
				+ ", respuesta=" + respuesta + ", fechaHoraPreg=" + fechaHoraPreg + ", fechaHoraResp=" + fechaHoraResp
				+ ", usuarioPreg=" + usuarioPreg + ", usuarioResp=" + usuarioResp + "]";
	}
	
	
	
	
}
