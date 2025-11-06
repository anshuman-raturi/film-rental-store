package com.cg.films.service.impl;
 
import org.springframework.stereotype.Service;
import com.cg.films.repository.InventoryRepository;
import com.cg.films.service.InventoryService;
 
@Service
public class InventoryServiceImpl implements InventoryService {
 
    private final InventoryRepository inventoryRepository;
 
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
 
    @Override
    public long getInventoryCountByTitle(String title) {
        return inventoryRepository.countByFilm_Title(title);
    }
}