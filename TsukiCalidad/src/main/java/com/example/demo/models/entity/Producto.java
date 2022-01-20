package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private Long pro_id;
	
	@Column(name = "pro_nombre")
	private String pro_nombre;
	
	@Column(name = "pro_descripcion")
	private String pro_descripcion;
	
	@ManyToOne
	@JoinColumn(name = "det_id")
	private Detalle detalle;

	public Long getPro_id() {
		return pro_id;
	}

	public void setPro_id(Long pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_nombre() {
		return pro_nombre;
	}

	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	public void setPro_descripcion(String pro_descripcion) {
		this.pro_descripcion = pro_descripcion;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	
	
}
