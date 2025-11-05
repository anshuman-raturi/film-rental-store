package com.cg.films.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Actor;
 
public interface ActorRepository extends JpaRepository<Actor, Long> {
}