package fr.antoine.steamrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.antoine.steamrest.model.Utilisateur;
import fr.antoine.steamrest.service.UtilisateurService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs() {
        return this.utilisateurService.getUtilisateurs();
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = this.utilisateurService.getUtilisateur(id);
        if(utilisateur.isPresent()) {
            return ResponseEntity.status(200).body(utilisateur.get());
        }
        return ResponseEntity.status(404).body(null);
    }

}
