package com.krakedev.examen.vuelos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "precio_boleto", nullable = false, columnDefinition = "NUMERIC(10,2)")
	private Double precioBoleto;
	
	@Column(name = "asientos_disponibles", nullable = false)
	private int asientosDisponibles;

	public Vuelo() {
		super();
	}

	public Vuelo(Long id, String codigo, Double precioBoleto, int asientosDisponibles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.precioBoleto = precioBoleto;
		this.asientosDisponibles = asientosDisponibles;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecioBoleto() {
		return precioBoleto;
	}

	public void setPrecioBoleto(Double precioBoleto) {
		this.precioBoleto = precioBoleto;
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", codigo=" + codigo + ", precioBoleto=" + precioBoleto + ", asientosDisponibles="
				+ asientosDisponibles + "]";
	}
	
	
}
