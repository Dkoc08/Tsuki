package com.ogusuku.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id")
	private Long id;
	
	@NotEmpty
	@Size(min=1, max=8)
	@Column(name="cli_dni")
	private String dni;
	
	@NotEmpty
	@Column(name="cli_nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name="cli_apellido")
	private String apellido;
	
	@NotEmpty
	@Column(name="cli_direccion")
	private String direccion;
	
	@NotEmpty
	@Column(name="cli_celular")
	private String celular;
	
	@NotEmpty
	@Email(message = "El correo debe ser válido")
	@Column(name="cli_correo")
	private String correo;
	
	
	@ManyToOne
	@JoinColumn(name="d_id")
	private Distrito distrito;
	
	// g y s

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	
	
}
