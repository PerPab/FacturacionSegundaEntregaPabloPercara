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

@Entity
@Tag(name = "Gestion de Productos", description = "Endpoints productos")
@Schema(description = "Esquema de productos")
@Table(name = "Productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id de Producto", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long id;
	@Schema(description = "Nombre Producto")
	private String nombre;
	@Schema(description = "Descripcion Producto")
	private String descripcion;
	@Schema(description = "Precio Producto")
	private Double precioUnitario;
	@Schema(description = "Stock Producto")
	private Integer stock;
	
	
	@OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detallesVenta;
	
	public Producto() {
		super();
	}
	

	public Producto(String nombre, String descripcion, Double precioUnitario, Integer stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.stock = stock;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", stock=" + stock  + "]";
	}
	
	
}

    
    