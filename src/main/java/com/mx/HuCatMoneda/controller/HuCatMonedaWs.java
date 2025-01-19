package com.mx.HuCatMoneda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.HuCatMoneda.model.HuCatMoneda;
import com.mx.HuCatMoneda.service.HuCatMonedaServImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("HuCatMonedaWs")
@CrossOrigin
public class HuCatMonedaWs {

	@Autowired
	HuCatMonedaServImp imp;

	@GetMapping("listar")
	public ResponseEntity<List<HuCatMoneda>> listar() {
	    try {
	        List<HuCatMoneda> monedas = imp.listar();
	        if (monedas.isEmpty()) {
	            return ResponseEntity.noContent().build(); // 204 lista vacía
	        }
	        return ResponseEntity.ok(monedas); // 200 OK 
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Error 500
	    }
	}

	@PostMapping("buscar")
	public ResponseEntity<HuCatMoneda> buscar(@RequestBody HuCatMoneda hcm) {
	    try {
	        if (hcm.getIdNumCia() == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // 400 ID no proporcionado
	        }
	        HuCatMoneda moneda = imp.buscar(hcm.getIdNumCia());
	        if (moneda != null) {
	            return ResponseEntity.ok(moneda); // 200 OK
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 ID no encontrado
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Error 500
	    }
	}

	@PostMapping("guardar")
	public ResponseEntity<HuCatMoneda> guardar(@RequestBody HuCatMoneda hcm) {
	    try {
	        HuCatMoneda monedaGuardada = imp.guardar(hcm);
	        return ResponseEntity.status(HttpStatus.CREATED).body(monedaGuardada); // 201 Creado con exito
	        
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Error 500
	    }
	}

	@PutMapping("actualizar")
	public ResponseEntity<Void> actualizar(@RequestBody HuCatMoneda hcm) {
	    try {
	        if (hcm.getIdNumCia() == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 ID no proporcionado
	        }

	        HuCatMoneda existente = imp.buscar(hcm.getIdNumCia());
	        if (existente == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 ID no encontrado
	        }

	        imp.actualizar(hcm);
	        return ResponseEntity.ok().build(); // 200 OK
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Error del servidor
	    }
	}


	@DeleteMapping("eliminar")
	public ResponseEntity<Void> eliminar(@RequestBody HuCatMoneda hcm) {
	    try {
	        if (hcm.getIdNumCia() == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //  400 ID no proporcionado
	        }
	        HuCatMoneda moneda = imp.buscar(hcm.getIdNumCia());
	        if (moneda == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 ID no encontrado
	        }
	        imp.eliminar(hcm.getIdNumCia());
	        return ResponseEntity.noContent().build(); // 204 eliminación es exitosa
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Error 500
	    }
	}

	

}
