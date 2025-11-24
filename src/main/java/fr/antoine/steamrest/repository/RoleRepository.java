package fr.antoine.steamrest.repository;

import org.springframework.data.repository.CrudRepository;

import fr.antoine.steamrest.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
