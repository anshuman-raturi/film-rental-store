package com.cg.films.service.impl;

import com.cg.films.dto.FilmDTO;
import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.entity.FilmActor;
import com.cg.films.exception.FilmNotFoundException;
import com.cg.films.exception.InvalidLanguageFoundException;
import com.cg.films.exception.NoFilmsFoundForLanguageException;
import com.cg.films.exception.RecordNotFound;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.LanguageRepository;
import com.cg.films.repository.FilmActorRepository;
import com.cg.films.service.FilmService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final FilmActorRepository filmActorRepository;
    private final LanguageRepository languageRepository;

    public FilmServiceImpl(FilmRepository filmRepository, FilmActorRepository filmactorRepository, LanguageRepository languageRepository) {
        this.filmRepository = filmRepository;
        this.filmActorRepository = filmactorRepository;
        this.languageRepository = languageRepository;
    }

    public List<Film> findFilmsByCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }

        List<Film> films = filmRepository.findByCategories_NameIgnoreCase(category);
        if (films.isEmpty()) {
            throw new EntityNotFoundException("No films found for category: " + category);
        }

        return films;
    }
    
    
    //lavanya
	@Override
	public List<FilmDTO> getAllFilmTitlesByLanguage(String name) {
 
 
		if (!languageRepository.existsByName(name)) {
			throw new InvalidLanguageFoundException(name);
		}
 
 
		List<Film> films=filmRepository.findByLanguage_Name(name);
		List<FilmDTO> filmTitleDTO=new ArrayList<>();
		for(Film film:films) {
			filmTitleDTO.add(new FilmDTO(film.getTitle(),film.getDescription(),film.getReleaseYear()));
		}
		if(filmTitleDTO.isEmpty()) {
			throw new NoFilmsFoundForLanguageException(name);
		}
		return filmTitleDTO;
		
	}
 
	@Override
	public List<FilmDTO> getAllFilmsByLanguage(String name) {
		if (!languageRepository.existsByName(name)) {
			throw new InvalidLanguageFoundException(name);
		}
		List<Film> films=filmRepository.findByLanguage_Name(name);
		List<FilmDTO> filmTitleDTO=new ArrayList<>();
		for(Film film:films) {
			filmTitleDTO.add(new FilmDTO(film.getTitle(),film.getDescription(),film.getReleaseYear()));
		}
		if(filmTitleDTO.isEmpty()) {
			throw new NoFilmsFoundForLanguageException(name);
		}
		return filmTitleDTO;
	}
	//end
	
	//anshuman
    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
 
    @Override
    public Film getFilmByTitle(String title) {
        Film film = filmRepository.findByTitle(title);
        if (film == null) {
            throw new RecordNotFound("Film is not available");
        }
        return film;
    }
    //end

    @Override
    public List<Actor> findActorsByFilmName(String filmName) {
        Film film = filmRepository.findByTitleIgnoreCase(filmName);
        if (film == null) {
            throw new FilmNotFoundException(filmName);
        }

        List<FilmActor> filmActors = filmActorRepository.findByFilm(film);
        if (filmActors == null || filmActors.isEmpty()) {
            return Collections.emptyList();
        }

        return filmActors.stream()
                         .map(FilmActor::getActor)
                         .collect(Collectors.toList());
    }

	
}