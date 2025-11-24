package fr.antoine.steamrest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.antoine.steamrest.model.SessionToken;

public interface SessionTokenRepository extends CrudRepository<SessionToken, Long> {

    Optional<SessionToken> findSessionTokenByToken(String token);

}
