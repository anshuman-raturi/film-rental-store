package com.cg.films.service.impl;
 
import org.springframework.stereotype.Service;

import com.cg.films.exception.RecordNotFound;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.InventoryRepository;
import com.cg.films.service.InventoryService;
 
@Service
public class InventoryServiceImpl implements InventoryService {
 
    private final InventoryRepository inventoryRepository;
    private final FilmRepository filmRepository;
 
    public InventoryServiceImpl(InventoryRepository inventoryRepository, FilmRepository filmRepository) {
        this.inventoryRepository = inventoryRepository;
        this.filmRepository = filmRepository;
    }
 
    @Override
    public long getInventoryCountByTitle(String title) {
        if (filmRepository.findByTitle(title) == null) {
            throw new RecordNotFound("Film is not available");
        }
        return inventoryRepository.countByFilm_Title(title);
    }
}