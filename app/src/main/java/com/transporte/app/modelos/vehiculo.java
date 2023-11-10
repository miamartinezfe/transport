package com.transporte.app.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table (name = "vehiculo")
public class vehiculo {

    @Id
    @Column( length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(length = 4)
    private String modelo;
    @NotNull
    @Column(length = 7)
    private String placa;
    @Column(length = 7)
    private String capacidad;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private conductor conductor;
}
