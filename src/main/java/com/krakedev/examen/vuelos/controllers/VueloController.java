package com.krakedev.examen.vuelos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.services.VueloService;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {
	
	@Autowired
	private VueloService vService;
	
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody Vuelo vuelo) {
        try {
        	Vuelo creado = vService.insertar(vuelo);
			return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el vuelo");
        }
	}
	
	@GetMapping
    public ResponseEntity<?> listarTodos() {
		try {
			List<Vuelo> vuelos =vService.listar();
			return ResponseEntity.ok(vuelos);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la lista de vuelos");
		}
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable long id) {
		try {
			Optional<Vuelo> vuelo =vService.buscarPorId(id);
			if (vuelo.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo con id " + id + " no encontrado");
			}else {
				return ResponseEntity.ok(vuelo);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar el vuelo");
		}
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Vuelo vuelo) {
		try {
			Vuelo actualizado = vService.actualizar(id, vuelo);
			if (actualizado ==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo " + id + " no existe");
			} else {
				return ResponseEntity.ok(actualizado);
			}
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar vuelo: " + id);
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable long id) {
		try {
			boolean eliminado = vService.eliminar(id);
			if (!eliminado) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo con id " + id + " no existe");
			}
			return ResponseEntity.ok("Vuelo con id: " + id + " eliminado");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar vuelo: " + id);
		}
	}
	
	
	
}
