package fr.antoine.steamrest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.antoine.steamrest.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>  {

    Optional<Utilisateur> findUtilisateurByNomUtilisateur(String nomUtilisateur);

}
