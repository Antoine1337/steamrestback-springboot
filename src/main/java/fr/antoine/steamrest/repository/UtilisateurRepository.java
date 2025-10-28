package fr.antoine.steamrest.repository;

import org.springframework.data.repository.CrudRepository;

import fr.antoine.steamrest.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>  {
}
