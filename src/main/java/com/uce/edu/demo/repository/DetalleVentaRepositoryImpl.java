package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleVenta);
	}

	@Override
	public DetalleVenta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleVenta.class, id);
	}

	@Override
	public void actualizar(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalleVenta);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
