package com.InacioGomes.clickbuschallenge.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InacioGomes.clickbuschallenge.entities.Place;
import com.InacioGomes.clickbuschallenge.repositories.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository repository;
	
	public List<Place> findAll(){
		return repository.findAll();
	}
	
	public Place findById(Long id) {
		Optional<Place> obj = repository.findById(id);
		return obj.get();
	}
	
	public Place insert(Place obj) {
		obj.setCreatedAt(LocalDateTime.now());
		obj.setUpdatedAt(LocalDateTime.now());
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Place update(Long id, Place obj) {
		Place entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Place entity, Place obj) {
		entity.setName(obj.getName());
		entity.setSlug(obj.getSlug());
		entity.setCity(obj.getCity());
		entity.setState(obj.getState());
		entity.setUpdatedAt(LocalDateTime.now());	
	}
	
}
