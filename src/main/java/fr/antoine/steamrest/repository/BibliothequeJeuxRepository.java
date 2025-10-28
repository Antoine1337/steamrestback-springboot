package fr.antoine.steamrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.antoine.steamrest.model.BibliothequeJeux;

public interface BibliothequeJeuxRepository extends CrudRepository<BibliothequeJeux, Long> {

    List<BibliothequeJeux> findBibliothequeJeuxByUtilisateurId(Long utilisateurId);

}
