package com.InacioGomes.clickbuschallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InacioGomes.clickbuschallenge.entities.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
