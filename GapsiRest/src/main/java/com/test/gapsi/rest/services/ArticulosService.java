/**
 * 
 */
package com.test.gapsi.rest.services;

import com.test.gapsi.rest.entities.Articulos;
import com.test.gapsi.rest.in.ArticuloIn;

/**
 * @author victor
 *
 */
public interface ArticulosService {

	Articulos finById(String id);
	
	Integer guardaArticulo(Articulos articulo);
	
	Integer actualizaArticulo(ArticuloIn articulo);
	
}
