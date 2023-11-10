package com.transporte.app.Service;

import com.transporte.app.repositorio.pedidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class pedidosService {
    @Autowired
    private pedidosRepositorio pedidosRepositorio;
}
