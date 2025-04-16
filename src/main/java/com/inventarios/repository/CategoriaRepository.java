package com.inventarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventarios.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
}
