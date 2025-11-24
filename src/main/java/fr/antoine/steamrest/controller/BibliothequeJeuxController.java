package fr.antoine.steamrest.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import fr.antoine.steamrest.controller.params.BibliothequeJeuxParams;
import fr.antoine.steamrest.model.BibliothequeJeux;
import fr.antoine.steamrest.model.Utilisateur;
import fr.antoine.steamrest.service.AuthentificationService;
import fr.antoine.steamrest.service.BibliothequeJeuxService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BibliothequeJeuxController {

    private BibliothequeJeuxService bibliothequeJeuxService;

    private AuthentificationService authentificationService;

    public BibliothequeJeuxController(BibliothequeJeuxService bibliothequeJeuxService, AuthentificationService authentificationService) {
        this.bibliothequeJeuxService = bibliothequeJeuxService;
        this.authentificationService = authentificationService;
    }

    @GetMapping("/utilisateurs/{id}/bibliothequejeux")
    public List<BibliothequeJeux> getBibliothequeJeuxByUtilisateurId(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorisationToken,  @PathVariable Long id) {
        String token = authorisationToken.replace("Bearer ", "");

        Optional<Utilisateur> utilisationConnecte = this.authentificationService.estValide(token);
        if(utilisationConnecte.isPresent()) {
            if(id.equals(utilisationConnecte.get().getUtilisateurId())) {
                return this.bibliothequeJeuxService.getBibliothequeJeuxByUtilisateurId(id);
            }
        }

        return Collections.emptyList();
    }

    @PutMapping("/utilisateurs/{idUser}/bibliothequejeux/{idJeux}")
    public ResponseEntity<BibliothequeJeux> updateBibliothequeJeuxByUtilisateurIdAndJeuxId(@PathVariable Long idUser, @PathVariable Long idJeux, @RequestBody BibliothequeJeuxParams bibliothequeJeuxParams) {
        BibliothequeJeux bj = this.bibliothequeJeuxService.updateBibliothequeJeuxByUtilisateurIdAndJeuxId(idUser, idJeux, bibliothequeJeuxParams);
        if(bj == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().body(bj);
    }

    @DeleteMapping("/utilisateurs/{idUser}/bibliothequejeux/{idJeux}")
    public ResponseEntity<BibliothequeJeux> deleteBibliothequeJeuxByUtilisateurIdAndJeuxId(@PathVariable Long idUser, @PathVariable Long idJeux) {
        BibliothequeJeux bj = this.bibliothequeJeuxService.removeBibliothequeJeuxByUtilisateurIdAndJeuxId(idUser, idJeux);
        if(bj == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().body(bj);
    }

}
