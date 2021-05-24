package com.test.gapsi.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.gapsi.rest.entities.Articulos;
import com.test.gapsi.rest.in.ArticuloIn;
import com.test.gapsi.rest.repositories.ArticulosRepository;

/**
 * @author victor
 *
 */
@Service
public class ArticulosServiceImpl implements ArticulosService {

	@Autowired
	private ArticulosRepository articulosRepository;
	
	@Override
	public Articulos finById(String id) {
		Optional<Articulos> ar = articulosRepository.findById(id);
		
		Articulos entity = (ar.isPresent() ? ar.get() : null);
		
		return entity;
	}

	@Override
	public Integer guardaArticulo(Articulos articulo) {
		Articulos ar= articulosRepository.save(articulo);
		return (ar!=null ? 1 : 0);
	}

	@Override
	public Integer actualizaArticulo(ArticuloIn articulo) {

		return articulosRepository.actualizaArticulo(
				articulo.getDescripcion(), articulo.getModelo(), articulo.getIdArticulo());
	}
	
}
