package com.example.vpopovych.vpopovych_classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VPopovychRepository extends JpaRepository<VPopovych, Integer> { //cambiar por vpopovych repository 
    // <...Integer> es porque el @id de Persona es un Integer

}