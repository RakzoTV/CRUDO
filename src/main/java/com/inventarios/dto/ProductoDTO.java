package com.inventarios.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Integer stock_inicial;
    private Integer stock_actual;
    private Integer umbral_minimo;
    private Long categoria;
}
