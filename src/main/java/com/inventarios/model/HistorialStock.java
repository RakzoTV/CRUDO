package com.inventarios.model;

import java.time.LocalDate;

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
@Table(name = "historial_stock")
public class HistorialStock {
    @Id
    @Column(name="id_historial")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "tipo_cambio", nullable = false, length = 50)
    private String tipoCambio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    private LocalDate fecha_hora;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
