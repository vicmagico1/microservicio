
package com.test.gapsi.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.test.gapsi.rest.entities.Articulos;

/**
 * @author victor
 *
 */
public interface ArticulosRepository extends JpaRepository<Articulos, String> {

	@Transactional
	@Modifying
	@Query("update Articulos u set u.descripcion = :descripcion, u.modelo = :modelo where u.idArticulo = :idArticulo")
	Integer actualizaArticulo(@Param("descripcion") String descripcion,
			@Param("modelo") String modelo,
			@Param("idArticulo") String idArticulo);
	
}