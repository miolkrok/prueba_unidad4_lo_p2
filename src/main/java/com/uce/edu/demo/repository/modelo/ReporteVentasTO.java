package com.uce.edu.demo.repository.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReporteVentasTO {
	
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDate fecha;
	
	private String categoria;
	
	private Integer cantidad;
	
	public ReporteVentasTO() {
		// TODO Auto-generated constructor stub
	}

	public ReporteVentasTO(LocalDate fecha, String categoria, Integer cantidad) {
		super();
		this.fecha = fecha;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
