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
@Table (name = "detalle_pedido")
public class Detalle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "det_id")
	private Long det_id;
	
	@Column(name = "det_precio")
	private String det_precio;
	
	@Column(name = "det_fecha_entrega")
	private String det_fecha_entrega;
	
	@Column(name = "det_descripcion")
	private String det_descripcion;
	
	@ManyToOne
	@JoinColumn(name = "p_id")
	private Pedidos pedidos;

	public Long getDet_id() {
		return det_id;
	}

	public void setDet_id(Long det_id) {
		this.det_id = det_id;
	}

	public String getDet_precio() {
		return det_precio;
	}

	public void setDet_precio(String det_precio) {
		this.det_precio = det_precio;
	}

	public String getDet_fecha_entrega() {
		return det_fecha_entrega;
	}

	public void setDet_fecha_entrega(String det_fecha_entrega) {
		this.det_fecha_entrega = det_fecha_entrega;
	}

	public String getDet_descripcion() {
		return det_descripcion;
	}

	public void setDet_descripcion(String det_descripcion) {
		this.det_descripcion = det_descripcion;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
