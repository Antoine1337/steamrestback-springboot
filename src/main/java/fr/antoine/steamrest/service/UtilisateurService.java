package fr.antoine.steamrest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import fr.antoine.steamrest.model.Utilisateur;
import fr.antoine.steamrest.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getUtilisateurs() {
        Iterable<Utilisateur> iterableUsers = this.utilisateurRepository.findAll();
        return StreamSupport.stream(iterableUsers.spliterator(), false).toList();
    }

    public Optional<Utilisateur> getUtilisateur(Long id) {
        return this.utilisateurRepository.findById(id);
    }

}
