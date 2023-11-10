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
@RequestMapping("/conductor")
public class conductorRest {
    @Autowired
    private conductorService conductorService;

    @Autowired
    private vehiculoService vehiculoService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<conductor> registrarConductor(@RequestBody conductor conductor) throws Exception {

        try {
            conductor.setId(conductor.getId());
            conductor.setApellido(conductor.getApellido());
            conductor.setDireccion(conductor.getDireccion());
            conductor.setNombre(conductor.getNombre());
            conductor.setTelefono(conductor.getTelefono());
            conductor.setIdentificacion(conductor.getIdentificacion());
            System.out.println("exito");
            return ResponseEntity.ok(conductor);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping(value = "/")
    public ResponseEntity<List<conductor>> obtenerConductores() throws Exception {

        try {
            List<conductor> conductores = conductorService.obtenerConductores();
            System.out.println("exito");
            return ResponseEntity.ok(conductores);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PostMapping(value = "/asociar-vehiculos/{idConductor}")
    public ResponseEntity<conductor> asociarVehiculosAConductor(@PathVariable("idConductor") Long idConductor, @RequestBody List<Long> idVehiculos) {
        try {

            conductor conductor = conductorService.obtenerConductorPorId(idConductor);
            if (conductor == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            List<vehiculo> vehiculosParaAsociar = new ArrayList<>();
            for (Long idVehiculo : idVehiculos) {
                vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(idVehiculo);
                if (vehiculo != null && !conductor.getVehiculos().contains(vehiculo)) {
                    vehiculosParaAsociar.add(vehiculo);
                }
            }

            conductor.setVehiculos(vehiculosParaAsociar);

            conductorService.guardarConductor(conductor);
            System.out.println("exito");
            return ResponseEntity.ok(conductor);
        } catch (Exception error) {
            System.out.println("exito");
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
