package com.inventarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stock_sucursal")
public class StockSucursal {
    @Id
    @Column(name = "id_stocksucursal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_actual", nullable = false)
    private Integer stock_actual;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
