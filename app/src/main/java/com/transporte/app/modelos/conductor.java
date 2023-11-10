package com.transporte.app.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table (name = "conductor")
public class conductor {
    @Id
    @Column( length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(length = 11)
    private String identificacion;
    @NotNull
    @Column(length = 20)
    private String apellido;
    @NotNull
    @Column(length = 20)
    private String nombre;
    @NotNull
    @Column(length = 10)
    private String telefono;
    @NotNull
    @Column(length = 50)
    private String direccion;
    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL)
    private List<pedidos> listaPedidos;
    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL)
    private List<vehiculo> vehiculos;
}
