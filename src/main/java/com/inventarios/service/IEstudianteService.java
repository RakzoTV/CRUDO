package com.universidad.service;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Materia;
import java.util.List;

public interface IEstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes();
    List<EstudianteDTO> obtenerEstudianteActivo();
    List<EstudianteDTO> obtenerEstudianteInactivo();
    EstudianteDTO obtenerEstudiantePorNumeroInscripcion(String numeroInscripcion);
    List<Materia> obtenerMateriasDeEstudiante(Long estudianteId);
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    EstudianteDTO eliminarEstudiante(Long id, EstudianteDTO estudianteDTO);

}
