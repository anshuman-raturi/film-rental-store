package com.cg.films.service.impl;
 
import com.cg.films.dto.ActorDTO;
import com.cg.films.entity.Actor;
import com.cg.films.exception.InvalidActorNameException;
import com.cg.films.repository.ActorRepository;
import com.cg.films.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class ActorServiceImpl implements ActorService {
 
    @Autowired
    private ActorRepository actorRepository;
 
    @Override
    public List<String> getFilmsByActor(Long actorId) {
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
        return actor.getFilmActors()
                .stream()
                .map(fa -> fa.getFilm().getTitle())
                .collect(Collectors.toList());
    }
 
    @Override
    public List<String> getFilmsByActorFullName(String fullName) {
    	String[] parts = fullName.trim().split(" ");
      
    	if (parts.length < 2) {
    		throw new InvalidActorNameException("Please enter both first name and last name.");
    	}
  
    	String firstName = parts[0];
    	String lastName = parts[1];
  
    	java.util.Optional<Actor> actorOpt = actorRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
    	Actor actor = actorOpt.orElseThrow(() -> new InvalidActorNameException("Actor not found"));
  
    	return actor.getFilmActors()
    			.stream()
    			.map(fa -> fa.getFilm().getTitle())
    			.collect(Collectors.toList());
    }
    @Override
    public List<ActorDTO> getAllActors() {
        return actorRepository.findAll()
                .stream()
                .map(actor -> new ActorDTO(
                        actor.getActorId(),
                        actor.getFirstName() + " " + actor.getLastName()
                ))
                .collect(Collectors.toList());
    }
}