package fr.antoine.steamrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.antoine.steamrest.service.AuthentificationService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AuthentificationController {

    private AuthentificationService authentificationService;

    public AuthentificationController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }


    @PostMapping("/api/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthParams authParams) {
        String token = this.authentificationService.creerSession(authParams.nomUtilisateur, authParams.motDePasse);

        if(token == null) {
            LoginResponse response = new LoginResponse();
            response.message = "Authentification échouée, mot de passe ou nom d'utilisateur invalide.";
            response.token = null;
            return ResponseEntity.ok().body(response);
        }

        LoginResponse response = new LoginResponse();
        response.message = "Connexion réussie, bienvenue";
        response.token = token;
        return ResponseEntity.ok().body(response);
    }


    private static class LoginResponse {
        public String message;
        public String token;
    }

    private static class AuthParams {
        public String nomUtilisateur;
        public String motDePasse;
    }
    
}
