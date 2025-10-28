package fr.antoine.steamrest.repository;

import org.springframework.data.repository.CrudRepository;

import fr.antoine.steamrest.model.Jeux;

public interface JeuxRepository extends CrudRepository<Jeux, Long> {
}
