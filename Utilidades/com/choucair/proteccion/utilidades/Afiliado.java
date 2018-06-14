package com.choucair.proteccion.utilidades;

public class Afiliado {

	private String tipoID;
	private String numID;
	private final String clave = "4";
	private String usuario;
	
	
	public Afiliado(String tipoID, String numID, String usuario) {
		super();
		this.tipoID = tipoID;
		this.numID = numID;
		this.usuario = usuario;
	}


	public String getTipoID() {
		return tipoID;
	}


	public void setTipoID(String tipoID) {
		this.tipoID = tipoID;
	}


	public String getNumID() {
		return numID;
	}


	public void setNumID(String numID) {
		this.numID = numID;
	}


	public String getClave() {
		return clave;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
