/**
 * 
 */
package com.test.gapsi.rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Victor
 *
 */
@Entity
@Table(name = "tbl_articulos")
public class Articulos implements Serializable {

	@Id
	@Column(name = "ID_ARTICULO")
	@ApiModelProperty(notes = "The database generated product ID")
	private String idArticulo;
	
	@Column(name = "NOMBRE")
	@ApiModelProperty(notes = "Nombre del articulo")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	@ApiModelProperty(notes = "Descripcion del articulo")
	private String descripcion;
	
	@Column(name = "PRECIO")
	@ApiModelProperty(notes = "Precio del articulo", required = true)
	private double precio;
	
	@Column(name = "MODELO")
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
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
		return "Articulos [idArticulo=" + idArticulo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", modelo=" + modelo + "]";
	}
	
	
	

}
