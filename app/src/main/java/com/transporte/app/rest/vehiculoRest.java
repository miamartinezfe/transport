package com.transporte.app.rest;

import com.transporte.app.Service.conductorService;
import com.transporte.app.Service.vehiculoService;
import com.transporte.app.modelos.conductor;
import com.transporte.app.modelos.vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class vehiculoRest {
    @Autowired
    private vehiculoService vehiculoService;

    @Autowired
    private conductorService conductorService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<vehiculo> registrarVehiculo(@RequestBody vehiculo vehiculo) throws Exception {

        try {
            vehiculo.setId(vehiculo.getId());
            vehiculo.setCapacidad(vehiculo.getCapacidad());
            vehiculo.setPlaca(vehiculo.getPlaca());
            vehiculo.setModelo(vehiculo.getModelo());
            vehiculoService.guardarVehiculo(vehiculo);
            System.out.println("exito");
            return ResponseEntity.ok(vehiculo);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping(value = "/")
    public ResponseEntity<List<vehiculo>> vehiculos() throws Exception {

        try {
            List<vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
            System.out.println("exito");
            return ResponseEntity.ok(vehiculos);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping(value = "/disponibles")
    public ResponseEntity<List<Integer>> vehiculosDisponibles() throws Exception {

        try {
            List<vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
            List<Integer> vehiculosDisponibles = new ArrayList<>();
            for (vehiculo vehiculo: vehiculos){
                if (vehiculo.getConductor() == null){
                    vehiculosDisponibles.add(vehiculo.getId());
                }
            }
            return ResponseEntity.ok(vehiculosDisponibles);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
