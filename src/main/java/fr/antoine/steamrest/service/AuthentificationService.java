package fr.antoine.steamrest.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.antoine.steamrest.model.SessionToken;
import fr.antoine.steamrest.model.Utilisateur;
import fr.antoine.steamrest.repository.SessionTokenRepository;

@Service
public class AuthentificationService {

    private SessionTokenRepository sessionTokenRepository;

    private UtilisateurService utilisateurService;

    public AuthentificationService(SessionTokenRepository sessionTokenRepository, UtilisateurService utilisateurService) {
        this.sessionTokenRepository = sessionTokenRepository;
        this.utilisateurService = utilisateurService;
    }

    public Optional<Utilisateur> estValide(String token) {

        Optional<SessionToken> sessionToken = this.sessionTokenRepository.findSessionTokenByToken(token);
        if(sessionToken.isPresent()) {
            return this.utilisateurService.getUtilisateur(sessionToken.get().getUtilisateurId());
        }

        return Optional.empty();

    }


    public String creerSession(String nomUtilisateur, String motDePasse) {
        Optional<Utilisateur> utilisateur = this.utilisateurService.getUtilisateurParNomUtilisateur(nomUtilisateur);

        if(utilisateur.isPresent()) {
            Utilisateur u = utilisateur.get();
            if(u.getMotDePasse().equals(motDePasse)) {
                UUID sessionTokenUUID = UUID.randomUUID();
                SessionToken sessionToken = new SessionToken();

                sessionToken.setToken(sessionTokenUUID.toString());
                sessionToken.setUtilisateurId(u.getUtilisateurId());
                this.sessionTokenRepository.save(sessionToken);

                return sessionTokenUUID.toString();
            }
        }

        return null;
    }




}
