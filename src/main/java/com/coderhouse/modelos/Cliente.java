package com.coderhouse.modelos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Schema(description = "Modelo de Cliente")
@Tag(name = "Gestion de Clientes", description = "Endpoints clientes")
@Entity
@Table(name = "Clientes")
public class Cliente {
	@Schema(description = "Id de Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Schema(description = "Nombre de Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private String nombre;
	@Schema(description = "Email de Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private String email;
	@Schema(description = "Telefono de Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private String telefono;
	@Schema(description = "Dirección de Cliente", requiredMode = Schema.RequiredMode.REQUIRED)
	private String direccion;
	
	@OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;
	
	public Cliente() {
		super();
	}
	

	public Cliente(String nombre, String email, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion +  "]";
	}
	
	
}

