package com.transporte.app.repositorio;

import com.transporte.app.modelos.vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vehiculoRepositorio extends JpaRepository<vehiculo, Long> {
}
