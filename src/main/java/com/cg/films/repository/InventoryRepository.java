package com.cg.films.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.films.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("SELECT COUNT(i) FROM Inventory i WHERE i.film.title = :title")
    long countByFilmTitle(@Param("title") String title);
}