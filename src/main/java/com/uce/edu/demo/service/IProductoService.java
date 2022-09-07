package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoDTO;

public interface IProductoService {

	public void insertar(Producto producto);

	public Producto buscar(Integer id);

	public void actualizar(Producto producto);

	public void borrar(Integer id);

	public Producto buscarCodigoBarras(String codigo);
	
	public Producto buscarConsultaStockCriteria(String codigoBarras);
	
	public List<ProductoDTO> reporte(LocalDateTime fecha, String categoria, Integer cantidad);

}
