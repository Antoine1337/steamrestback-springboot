package fr.antoine.steamrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.antoine.steamrest.model.Jeux;
import fr.antoine.steamrest.service.JeuxService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class JeuxController {

    private JeuxService jeuxService;

    public JeuxController(JeuxService jeuxService) {
        this.jeuxService = jeuxService;
    }

    @GetMapping("/jeux")
    public List<Jeux> getAllJeux() {
        return this.jeuxService.getAllJeux();
    }

    @GetMapping("/jeux/{id}")
    public ResponseEntity<Jeux> getJeux(@PathVariable Long id) {
        Optional<Jeux> jeux = this.jeuxService.getJeux(id);
        if(jeux.isPresent()) {
            return ResponseEntity.status(200).body(jeux.get());
        }
        return ResponseEntity.status(404).body(null);
    }
    
}
