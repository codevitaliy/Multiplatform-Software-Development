package com.example.demoapi.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> { //cambiar por vpopovych repository 
    // <...Integer> es porque el @id de Persona es un Integer

}