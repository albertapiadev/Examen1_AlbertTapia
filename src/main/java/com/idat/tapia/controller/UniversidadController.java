package com.idat.tapia.controller;

import com.idat.tapia.dto.UniversidadDTORequest;
import com.idat.tapia.dto.UniversidadDTOResponse;
import com.idat.tapia.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universidad")
public class UniversidadController {

    @Autowired
    private UniversidadService universidadService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<UniversidadDTOResponse>> listarUniversidads() {
        return new ResponseEntity<List<UniversidadDTOResponse>>(universidadService.listarUniversidades(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Void> crearUniversidad(@RequestBody UniversidadDTORequest universidadDTORequest) {
        universidadService.crearUniversidad(universidadDTORequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "listar/{idUniversidad}", method = RequestMethod.GET)
    public ResponseEntity<UniversidadDTOResponse> obtenerUniversidad(@PathVariable Integer idUniversidad) {
        UniversidadDTOResponse u = universidadService.obtenerUniversidad(idUniversidad);
        if (u != null) {
            return new ResponseEntity<UniversidadDTOResponse>(u, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UniversidadDTOResponse>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarUniversidad(@RequestBody UniversidadDTORequest universidadDTORequest) {
        UniversidadDTOResponse u = universidadService.obtenerUniversidad(universidadDTORequest.getIdUniversidadDTO());
        if (u != null) {
            universidadService.actualizarUniversidad(universidadDTORequest);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/eliminar/{idUniversidad}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarUniversidad(@PathVariable Integer idUniversidad) {
        UniversidadDTOResponse u = universidadService.obtenerUniversidad(idUniversidad);
        if (u != null) {
            universidadService.eliminarUniversidad(idUniversidad);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}
