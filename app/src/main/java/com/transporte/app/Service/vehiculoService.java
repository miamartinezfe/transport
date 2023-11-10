package com.transporte.app.Service;

import com.transporte.app.modelos.conductor;
import com.transporte.app.modelos.vehiculo;
import com.transporte.app.repositorio.vehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehiculoService {
    @Autowired
    private vehiculoRepositorio vehiculoRepositorio;

    public vehiculo guardarVehiculo(vehiculo vehiculo) {
        return vehiculoRepositorio.save(vehiculo);
    }

    public List<vehiculo> obtenerVehiculos() {
        return vehiculoRepositorio.findAll();
    }

    public vehiculo obtenerVehiculoPorId(Long id) {
        vehiculo vehiculo = vehiculoRepositorio.findById(id).orElse(null);
        return vehiculo;
    }
}
