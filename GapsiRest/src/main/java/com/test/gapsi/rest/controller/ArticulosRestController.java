/**
 * 
 */
package com.test.gapsi.rest.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.gapsi.rest.entities.Articulos;
import com.test.gapsi.rest.in.ArticuloIn;
import com.test.gapsi.rest.services.ArticulosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Victor
 *
 */
@RestController
@RequestMapping("/api/articulos")
@Api("Servicio para las operaciones sobre Articulos de GAPSI")
public class ArticulosRestController {
	
	 private static final Logger logger = LogManager.getLogger(ArticulosRestController.class);


	@Autowired
	private ArticulosService articulosService;
	
	@ApiOperation(value = "Consulta de Articulos de acuerdo a su ID proporcionado", response = Articulos.class)
	@ApiResponses(value = {
	        @ApiResponse(code = HttpServletResponse.SC_OK, message = "Retorna el Articulo encontrado"),
	        @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Estatus cuando no encontro el Articulo "),
	        @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error"),
	        @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Error en los parametros de entrada")
	}
	)
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarArticulosPorId(
			@ApiParam(value = "Id del articulo a consultar", required = true) @PathVariable("id") String id) {
		logger.debug("Articulo " + id);
		
		Articulos ar  = articulosService.finById(id);
		
		if (ar == null) {
			return new ResponseEntity<>("No se encontro el articulo",HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(ar, HttpStatus.OK);
		}
	    
	}
	
	@ApiOperation(value = "Guarda informacion", response = Articulos.class)
	@ApiResponses(value = {
	        @ApiResponse(code = HttpServletResponse.SC_OK, message = "Guarda el Articulo proporcionado"),
	        @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Estatus cuando no guardo el Articulo "),
	        @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error"),
	        @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Error en los parametros de entrada")
	}
	)
	@PostMapping("/")
	public ResponseEntity<?> guardaArticulo(
			@ApiParam(value = "Ojecto ", required = true) @RequestBody Articulos articulo) {
		logger.debug("Articulo " + articulo);
		
		Integer estatus  = articulosService.guardaArticulo(articulo);
		
		if (estatus == 0) {
			return new ResponseEntity<>("No se guardo el articulo",HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	    
	}
	
	
	@ApiOperation(value = "Actualiza informacion de un articulo ", response = Articulos.class)
	@ApiResponses(value = {
	        @ApiResponse(code = HttpServletResponse.SC_OK, message = "Actualiza el Articulo proporcionado"),
	        @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Estatus cuando no actualizo informacin de algun Articulo "),
	        @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error"),
	        @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Error en los parametros de entrada")
	}
	)
	@PutMapping("/")
	public ResponseEntity<?> actualizaArticulo(
			@ApiParam(value = "Ojecto ", required = true) @RequestBody ArticuloIn articulo) {
		logger.debug("Articulo actualizar " + articulo);
		
		Integer estatus  = articulosService.actualizaArticulo(articulo);
		
		if (estatus == 0) {
			return new ResponseEntity<>("No actualizo informacion, no se encontro el id del articulo",HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	    
	}
	
}
