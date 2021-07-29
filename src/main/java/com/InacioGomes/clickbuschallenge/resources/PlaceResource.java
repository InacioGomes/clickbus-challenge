package com.InacioGomes.clickbuschallenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.InacioGomes.clickbuschallenge.entities.Place;
import com.InacioGomes.clickbuschallenge.services.PlaceService;

@RestController
@RequestMapping(value = "/places")
public class PlaceResource {
	
	@Autowired
	private PlaceService service;
	
	@GetMapping
	public ResponseEntity<List<Place>> findAll(){
		List<Place> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Place> findById(@PathVariable Long id){
		Place place = service.findById(id);
		return ResponseEntity.ok().body(place);
	}
	
	@PostMapping
	public ResponseEntity<Place> insert(@RequestBody Place obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Place> update(@PathVariable Long id, @RequestBody Place obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok(obj);
	}
}
