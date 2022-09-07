package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ReporteVentasTO;
import com.uce.edu.demo.service.IGestorSupermercadoService;

@Controller
@RequestMapping("/supermercado/")
public class SupermercadoController {

	@Autowired
	private IGestorSupermercadoService gestSuperServ;

	@GetMapping("ingresoProductos")
	public String obtenerPaginaIngresoDatosLibros(Producto producto) {
		return "vistaNuevaProducto";

	}

	@PostMapping("insertarProductos")
	public String insertarProductos(Producto producto, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		this.gestSuperServ.ingresarProducto(producto);
		return "index";
	}

	// consultar stock
	@GetMapping("consultarStock")
	public String paginaClienteRegistrado(Model modelo) {
		modelo.addAttribute("buscar", false);
		return "listaProductosStock";

	}

	@PostMapping("encontrar/registrados")
	public String obtenerClientePorCedula(@RequestParam("codigoBarras") String codigoBarras, Model modelo) {

		Producto producto = this.gestSuperServ.consultarStock(codigoBarras);
		if (producto != null) {
			modelo.addAttribute("buscar", true);
			modelo.addAttribute("producto", producto);
		} else {
			modelo.addAttribute("buscar", false);
			modelo.addAttribute("producto", producto);
		}

		return "listaProductosStock";

	}

	// reporte ventas
	@GetMapping("reporte")
	private String paginaReporte(ReporteVentasTO reporteVentasTO) {
		return "datosReporteVentas";
	}

	@PostMapping("reporteVentas")
	public String buscarReporteVentas(ReporteVentasTO reporteVentasTO, Model modelo) {
		//
//		modelo.addAttribute("listaReportesVentas",
//				this.gestSuperServ.reporteVentas(reporteVentasTO.getFechaVenta().atStartOfDay(),
//						reporteVentasTO.getCategoria(), reporteVentasTO.getCantidad()));
		modelo.addAttribute("listReporteVentas", this.gestSuperServ.reporteVentas(
				reporteVentasTO.getFecha().atStartOfDay(),reporteVentasTO.getCategoria(), reporteVentasTO.getCantidad()));
		return "reporteVentas";

	}
}
