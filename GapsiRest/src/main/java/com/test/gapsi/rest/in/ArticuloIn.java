package com.test.gapsi.rest.in;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ArticuloIn implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3169375626067360638L;

	@ApiModelProperty(notes = "The database generated product ID")
	private String idArticulo;
	
	private String descripcion;
	
	private String modelo;

	/**
	 * @return the idArticulo
	 */
	public String getIdArticulo() {
		return idArticulo;
	}

	/**
	 * @param idArticulo the idArticulo to set
	 */
	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "ArticuloIn [idArticulo=" + idArticulo + ", descripcion=" + descripcion + ", modelo=" + modelo + "]";
	}


	
	
	
}
