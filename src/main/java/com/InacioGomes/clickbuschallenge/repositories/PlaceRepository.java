package com.InacioGomes.clickbuschallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InacioGomes.clickbuschallenge.entities.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

	List<Place>findByNameContaining(String name);
}
