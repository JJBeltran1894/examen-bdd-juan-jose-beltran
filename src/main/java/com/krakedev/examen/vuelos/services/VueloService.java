package com.krakedev.examen.vuelos.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.repositories.VueloRepository;

@Service
public class VueloService {
	
	@Autowired
	private VueloRepository vRepository;
	
	public VueloService(VueloRepository vRepository) {
		this.vRepository = vRepository;
	}
	
	public Vuelo insertar(Vuelo vuelo) {
		return vRepository.save(vuelo);
	}
	
	public List<Vuelo> listar(){
		return vRepository.findAll();
	}
	
	public Optional<Vuelo> buscarPorId(Long id){
		return vRepository.findById(id);
	}
	
	public Vuelo actualizar(Long id, Vuelo vuelo) {
		Optional<Vuelo> existeV = buscarPorId(id);
		if (existeV !=null) {
			return vRepository.save(vuelo);
		}else {
			return null;
		}
	}
	public boolean eliminar(Long id) {
        if (vRepository.existsById(id)) {
            vRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
	public List<Vuelo> buscarPorAsientosMayores(Integer cantidad) {

	    return vRepository.findByAsientosDisponiblesGreaterThan(cantidad);
	}
}
