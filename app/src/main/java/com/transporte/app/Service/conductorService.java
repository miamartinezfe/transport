package com.transporte.app.Service;

import com.transporte.app.modelos.conductor;
import com.transporte.app.modelos.vehiculo;
import com.transporte.app.repositorio.conductorRepositorio;
import com.transporte.app.repositorio.vehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class conductorService {
    @Autowired
    private conductorRepositorio conductorRepositorio;

    public conductor guardarConductor(conductor conductor) {
        return conductorRepositorio.save(conductor);
    }

    public List<conductor> obtenerConductores() {
        return conductorRepositorio.findAll();
    }

    public conductor obtenerConductorPorId(Long id) {
        conductor conductor = conductorRepositorio.findById(id).orElse(null);
        return conductor;
    }
}
