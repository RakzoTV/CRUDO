package com.universidad.repository; // Define el paquete al que pertenece esta clase

import com.universidad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByNumeroInscripcion(String numeroInscripcion);
    Estudiante findByEstado(String estado);
}

