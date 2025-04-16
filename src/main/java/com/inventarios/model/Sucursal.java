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
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @Column(name = "id_sucursal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "ubicacion", nullable = false, length = 100)
    @Basic(optional = true)
    private String ubicacion;

    @OneToMany(mappedBy = "sucursal")
    private List<StockSucursal> stockPorSucursal;
}
