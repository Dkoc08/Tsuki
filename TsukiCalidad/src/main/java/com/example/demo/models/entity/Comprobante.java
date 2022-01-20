package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "comprobante")
public class Comprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id")
	private Long comp_id;
	
	@Column(name = "comp_tipo_comprobante")
	private String comp_tipo_comprobante;
	
	@OneToOne
	@JoinColumn(name = "rec_id")
	private Recibo recibo;
	
	@OneToOne
	@JoinColumn(name = "fac_id")
	private Factura factura;
	
	@OneToOne
	@JoinColumn(name = "p_id")
	private Pedidos pedidos;

	public Long getComp_id() {
		return comp_id;
	}

	public void setComp_id(Long comp_id) {
		this.comp_id = comp_id;
	}

	public String getComp_tipo_comprobante() {
		return comp_tipo_comprobante;
	}

	public void setComp_tipo_comprobante(String comp_tipo_comprobante) {
		this.comp_tipo_comprobante = comp_tipo_comprobante;
	}

	public Recibo getRecibo() {
		return recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
