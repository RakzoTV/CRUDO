package com.inventarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventarios.dto.CategoriaDTO;
import com.inventarios.service.ICategoriaService;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @Autowired
    public CategoriaController(ICategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> obtenerTodasLasCategorias(){
        List<CategoriaDTO> categorias = categoriaService.obtenerTodasLasCategorias();
        return ResponseEntity.ok(categorias);
    }
    
}
