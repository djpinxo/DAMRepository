package net.ddns.djpinxo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ddns.djpinxo.models.Contenedor;
import net.ddns.djpinxo.repositories.ContenedorRepository;

@RestController
public class ContenedorController {

	@Autowired
	ContenedorRepository contenedorRepository;

	@GetMapping("/contenedores")
	public Iterable<Contenedor> getContenedors() {
		return contenedorRepository.findAll();
	}

	@GetMapping("/contenedores/{id}")
	public Optional<Contenedor> getContenedor(@PathVariable Long id) {
		return contenedorRepository.findById(id);
	}

	@PostMapping("/contenedores")
	public Optional<Contenedor> postContenedor(@RequestBody Contenedor contenedor) {
		Optional<Contenedor> contenedorSaved = contenedorRepository.findById(contenedor.getId());
		if (contenedorSaved.isEmpty()) {
			return Optional.of(contenedorRepository.save(contenedor));
		}
		else return Optional.empty();
	}

	@PutMapping("/contenedores/{id}")
	public Optional<Contenedor> putContenedor(@RequestBody Contenedor contenedor,@PathVariable Long id) {
		Optional<Contenedor> contenedorSaved = contenedorRepository.findById(id);
		if (!contenedorSaved.isEmpty()) {
			contenedor.setId(id);
			contenedorSaved =Optional.of(contenedor);
			contenedorRepository.save(contenedor);
		}
		return contenedorSaved;
	}
	
	@DeleteMapping("/contenedores/{id}")
	public void deleteContenedor(@PathVariable Long id) {
		contenedorRepository.deleteById(id);
	}

}
