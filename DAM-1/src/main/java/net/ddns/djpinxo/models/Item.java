package net.ddns.djpinxo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	@ManyToOne
	private Contenedor contenedor;

	public Item() {
		super();
	}

	public Item(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public Contenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
	

}
