package fr.antoine.steamrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.antoine.steamrest.model.BibliothequeJeux;
import fr.antoine.steamrest.service.BibliothequeJeuxService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BibliothequeJeuxController {

    private BibliothequeJeuxService bibliothequeJeuxService;

    public BibliothequeJeuxController(BibliothequeJeuxService bibliothequeJeuxService) {
        this.bibliothequeJeuxService = bibliothequeJeuxService;
    }

    @GetMapping("/utilisateurs/{id}/bibliothequejeux")
    public List<BibliothequeJeux> getBibliothequeJeuxByUtilisateurId(@PathVariable Long id) {
        return this.bibliothequeJeuxService.getBibliothequeJeuxByUtilisateurId(id);
    }
}
