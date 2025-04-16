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
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<HistorialStock> historialStock;
}
