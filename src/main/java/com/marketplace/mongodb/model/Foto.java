package com.marketplace.mongodb.model;

public class Foto {
	private int idFoto;
	private int idProducto;
	private String urlFoto;
	
	public Foto() {
		super();
	}

	public Foto(int idFoto, int idProducto, String urlFoto) {
		super();
		this.idFoto = idFoto;
		this.idProducto = idProducto;
		this.urlFoto = urlFoto;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
}
