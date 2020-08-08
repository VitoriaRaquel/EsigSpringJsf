package com.esig.resources;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esig.domain.Registro;
import com.esig.services.RegistroService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/registro")
@RestController
public class RegistroResource {
	@Autowired
	private RegistroService service;

	
	@PostMapping
	public ResponseEntity<Void> insert( @RequestBody Registro obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@GetMapping
	public ResponseEntity<List<Registro>> findAll() {
		List<Registro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{status}")
	public ResponseEntity<List<Registro>> findAllByStatus(@PathVariable Boolean status) {
		List<Registro> list = service.findAllByStatus(status);
		return ResponseEntity.ok().body(list);
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id) {
		service.updateStatus(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAllStatusCompleted() {
		this.service.deleteAllStatusCompleted();
		return ResponseEntity.noContent().build();
	}

}
