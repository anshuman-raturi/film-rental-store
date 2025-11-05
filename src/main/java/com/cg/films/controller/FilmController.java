package com.cg.films.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.List;
import com.cg.films.entity.Film;
import com.cg.films.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/inventory-count")
    public ResponseEntity<Map<String, Object>> getInventoryCount(@RequestParam String title) {
        long count = filmService.getInventoryCountByTitle(title);
        Map<String, Object> response = new HashMap<>();
        response.put("title", title);
        response.put("dvdCount", count);
        return ResponseEntity.ok(response);
    }
}