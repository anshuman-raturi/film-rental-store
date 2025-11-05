package com.cg.films.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.cg.films.entity.Film;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.InventoryRepository;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final InventoryRepository inventoryRepository;

    public FilmService(FilmRepository filmRepository, InventoryRepository inventoryRepository) {
        this.filmRepository = filmRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public long getInventoryCountByTitle(String title) {
        return inventoryRepository.countByFilmTitle(title);
    }
}