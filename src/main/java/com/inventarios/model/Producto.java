package com.inventarios.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false, length = 50)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "stock_inicial", nullable = false)
    private Integer stock_inicial;

    @Column(name = "stock_actual", nullable = false)
    private Integer stock_actual;

    @Column(name = "umbral_minimo", nullable = false)
    private Integer umbral_minimo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<StockSucursal> stockPorSucursal;

    @OneToMany(mappedBy = "producto")
    private List<HistorialStock> historialStock;
}
