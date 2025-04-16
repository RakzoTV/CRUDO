package com.inventarios.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventarios.service.ICategoriaService;
import com.inventarios.repository.CategoriaRepository;
import com.inventarios.dto.CategoriaDTO;
import com.inventarios.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> obtenerTodasLasCategorias(){
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    public CategoriaDTO convertToDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .build();
    }

    public Categoria convertToEntity(CategoriaDTO categoriaDTO) {
        return Categoria.builder()
                .id(categoriaDTO.getId())
                .nombre(categoriaDTO.getNombre())
                .build();
    }
}
