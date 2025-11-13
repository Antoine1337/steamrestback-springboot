package fr.antoine.steamrest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.antoine.steamrest.controller.params.BibliothequeJeuxParams;
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
