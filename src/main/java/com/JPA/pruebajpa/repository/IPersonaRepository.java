package com.JPA.pruebajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.JPA.pruebajpa.model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
