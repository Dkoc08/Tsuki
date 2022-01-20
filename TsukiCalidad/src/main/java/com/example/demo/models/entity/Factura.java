package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "fac_id")
	private Long fac_id;
	
	@Column(name = "fac_detalle")
	private String fac_detalle;
	
	@Column(name = "fac_ruc")
	private int fac_ruc;
	
	@Column(name = "fac_subtotal")
	private Double fac_subtotal;
	
	@Column(name = "fac_igv")
	private Double fac_igv;
	
	@Column(name = "fac_total")
	private Double fac_total;

	public Long getFac_id() {
		return fac_id;
	}

	public void setFac_id(Long fac_id) {
		this.fac_id = fac_id;
	}

	public String getFac_detalle() {
		return fac_detalle;
	}

	public void setFac_detalle(String fac_detalle) {
		this.fac_detalle = fac_detalle;
	}

	public int getFac_ruc() {
		return fac_ruc;
	}

	public void setFac_ruc(int fac_ruc) {
		this.fac_ruc = fac_ruc;
	}

	public Double getFac_subtotal() {
		return fac_subtotal;
	}

	public void setFac_subtotal(Double fac_subtotal) {
		this.fac_subtotal = fac_subtotal;
	}

	public Double getFac_igv() {
		return fac_igv;
	}

	public void setFac_igv(Double fac_igv) {
		this.fac_igv = fac_igv;
	}

	public Double getFac_total() {
		return fac_total;
	}

	public void setFac_total(Double fac_total) {
		this.fac_total = fac_total;
	}
	
	
}
