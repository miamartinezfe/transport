package com.transporte.app.repositorio;


import com.transporte.app.modelos.pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pedidosRepositorio extends JpaRepository<pedidos, Long> {
}
