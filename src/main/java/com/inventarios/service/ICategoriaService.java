package com.inventarios.service;

import java.util.List;

import com.inventarios.dto.CategoriaDTO;

public interface ICategoriaService {
    List<CategoriaDTO> obtenerTodasLasCategorias();
}
