package com.transporte.app.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table (name = "pedidos")
public class pedidos {
    @Id
    @Column( length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String tipo_pedido;
    @NotNull
    @Column(length = 50)
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private conductor conductor;
}
