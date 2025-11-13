package fr.antoine.steamrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.antoine.steamrest.controller.params.BibliothequeJeuxParams;
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

    public BibliothequeJeux updateBibliothequeJeuxByUtilisateurIdAndJeuxId(Long utilisateurId, Long jeuxId, BibliothequeJeuxParams bibliothequeJeuxParams) {
        BibliothequeJeux foundBibliothequeJeuxToUpdate = this.bibliothequeJeuxRepository.findBibliothequeJeuxByUtilisateurIdAndJeuId(utilisateurId, jeuxId);
        if(foundBibliothequeJeuxToUpdate == null) {
            return null;
        }

        foundBibliothequeJeuxToUpdate.setEstInstalle(bibliothequeJeuxParams.getEstInstalle());
        return this.bibliothequeJeuxRepository.save(foundBibliothequeJeuxToUpdate);
    }
    
    public BibliothequeJeux removeBibliothequeJeuxByUtilisateurIdAndJeuxId(Long utilisateurId, Long jeuxId) {
        BibliothequeJeux foundBibliothequeJeuxToUpdate = this.bibliothequeJeuxRepository.findBibliothequeJeuxByUtilisateurIdAndJeuId(utilisateurId, jeuxId);
        if(foundBibliothequeJeuxToUpdate == null) {
            return null;
        }

        this.bibliothequeJeuxRepository.delete(foundBibliothequeJeuxToUpdate);
        return foundBibliothequeJeuxToUpdate;
    }
    
}
