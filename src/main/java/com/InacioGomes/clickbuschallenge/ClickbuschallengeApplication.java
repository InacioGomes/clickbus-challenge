package com.InacioGomes.clickbuschallenge;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.InacioGomes.clickbuschallenge.entities.Place;
import com.InacioGomes.clickbuschallenge.repositories.PlaceRepository;

@SpringBootApplication
public class ClickbuschallengeApplication implements CommandLineRunner{
	
	@Autowired
	private PlaceRepository placeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClickbuschallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Place p1 = new Place(null, "Central Park", "Red Wing, MN 55066", "New York", "New York");
		Place p2 = new Place(null, "Niagara Falls", "322 prospect St", "New York", "New York");
		
		placeRepository.save(p1);
		placeRepository.save(p2);
	}

}
