package fr.antoine.steamrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.antoine.steamrest.model.BibliothequeJeux;
import fr.antoine.steamrest.repository.BibliothequeJeuxRepository;

@Service
public class BibliothequeJeuxService {

    private BibliothequeJeuxRepository bibliothequeJeuxRepository;

    public BibliothequeJeuxService(BibliothequeJeuxRepository bibliothequeJeuxRepository) {
        this.bibliothequeJeuxRepository = bibliothequeJeuxRepository;
    }


    public List<BibliothequeJeux> getBibliothequeJeuxByUtilisateurId(Long utilisateurId) {
        return this.bibliothequeJeuxRepository.findBibliothequeJeuxByUtilisateurId(utilisateurId);
    }
    
    
}
