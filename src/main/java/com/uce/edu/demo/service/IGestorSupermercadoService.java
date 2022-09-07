package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoDTO;

public interface IGestorSupermercadoService {

	public void ingresarProducto(Producto producto);

//	public void realizarVenta(List<Producto> lista, String cedula, String numeroVenta); 

	public void realizarVenta(List<Producto> lista, Integer cantidad, String cedulaCliente, String numeroVenta);

	public Producto consultarStock(String codigoBarras);

	public List<ProductoDTO> reporteVentas(LocalDateTime fechaVenta, String categoria, Integer cantidad);

}
