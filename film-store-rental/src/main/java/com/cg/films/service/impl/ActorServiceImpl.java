package com.cg.films.service.impl;
 
import com.cg.films.entity.Actor;
import com.cg.films.exception.MultipleActorsFoundException;
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
    public List<Actor> getAllActors() {
        return actorRepository.findAll()
                .stream()
                .map(a -> new Actor())
                .collect(Collectors.toList());
   }
 
 
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
    public List<String> getFilmsByActorFirstName(String firstName) {
        List<Actor> actors = actorRepository.findByFirstNameIgnoreCase(firstName);
        if (actors.size() == 1) {
            return actors.get(0).getFilmActors()
                    .stream()
                    .map(fa -> fa.getFilm().getTitle())
                    .collect(Collectors.toList());
        } else {
            throw new MultipleActorsFoundException("Multiple actors found. Please use ID for precise search.");
        }
    }
 
    @Override
    public List<String> getFilmsByActorLastName(String lastName) {
        List<Actor> actors = actorRepository.findByLastNameIgnoreCase(lastName);
        if (actors.size() == 1) {
            return actors.get(0).getFilmActors()
                    .stream()
                    .map(fa -> fa.getFilm().getTitle())
                    .collect(Collectors.toList());
        } else {
            throw new MultipleActorsFoundException("Multiple actors found. Please use ID for precise search.");
        }
    }
 
	
 
	
}