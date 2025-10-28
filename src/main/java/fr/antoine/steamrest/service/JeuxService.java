package fr.antoine.steamrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.antoine.steamrest.model.Jeux;
import fr.antoine.steamrest.repository.JeuxRepository;

@Service
public class JeuxService {

    private final JeuxRepository jeuxRepository;

    public JeuxService(JeuxRepository jeuxRepository) {
        this.jeuxRepository = jeuxRepository;
    }


    public List<Jeux> getAllJeux() {
        List<Jeux> jeux = new ArrayList<>();
        this.jeuxRepository.findAll().forEach(jeux::add);

        return jeux;
    }

    public Optional<Jeux> getJeux(Long id) {
        return this.jeuxRepository.findById(id);
    }

    
}
