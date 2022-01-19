package com.ogusuku.demo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="recibo")
public class Recibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rec_id")
	private Long id;
	
	@Column(name="rec_detalle")
	private String detalle;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="rec_fecha_creacion")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="cli_id")
	private Cliente cliente;
	
	@OneToMany(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="rec_id", nullable= false)
	private List<DetalleRecibo> ListaDetalles;
	
	@PrePersist
	@PreUpdate
	public void prePersistencia() {
		fecha =new Date();
	}
	public Recibo() {
		this.ListaDetalles =new ArrayList<>();
	}
	
	public void addDetalleFactura(DetalleRecibo detalle) {
		this.ListaDetalles.add(detalle);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
