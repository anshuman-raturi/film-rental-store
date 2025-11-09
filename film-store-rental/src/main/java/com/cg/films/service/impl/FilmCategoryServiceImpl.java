package com.cg.films.service.impl;

import com.cg.films.entity.Film;
import com.cg.films.entity.Category;
import com.cg.films.exception.RecordNotFound;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.CategoryRepository;
import com.cg.films.repository.FilmCategoryRepository;
import com.cg.films.service.FilmCategoryService;
import org.springframework.stereotype.Service;

@Service
public class FilmCategoryServiceImpl implements FilmCategoryService {

    private final FilmRepository filmRepository;
    private final CategoryRepository categoryRepository;
    private final FilmCategoryRepository filmCategoryRepository;

    public FilmCategoryServiceImpl(FilmRepository filmRepository,
                                   CategoryRepository categoryRepository,
                                   FilmCategoryRepository filmCategoryRepository) {
        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
        this.filmCategoryRepository = filmCategoryRepository;
    }

    @Override
    public boolean isMovieInCategory(String filmName, String categoryName) {
        Film film = filmRepository.findByTitle(filmName);
        Category category = categoryRepository.findByName(categoryName);

        if (film == null || category == null) {
            throw new RecordNotFound("Film or Category not found");
        }

        return filmCategoryRepository.existsByFilmAndCategory(film, category);
    }
}