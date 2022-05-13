package com.idat.tapia.controller;

import com.idat.tapia.dto.ProfesorDTORequest;
import com.idat.tapia.dto.ProfesorDTOResponse;
import com.idat.tapia.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<ProfesorDTOResponse>> listarProfesores() {
        return new ResponseEntity<List<ProfesorDTOResponse>>(profesorService.listarProfesores(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Void> crearProfesor(@RequestBody ProfesorDTORequest profesorDTORequest) {
        profesorService.crearProfesor(profesorDTORequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "listar/{idProfesor}", method = RequestMethod.GET)
    public ResponseEntity<ProfesorDTOResponse> obtenerProfesor(@PathVariable Integer idProfesor) {
        ProfesorDTOResponse p = profesorService.obtenerProfesor(idProfesor);
        if (p != null) {
            return new ResponseEntity<ProfesorDTOResponse>(p, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProfesorDTOResponse>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarProfesor(@RequestBody ProfesorDTORequest profesorDTORequest) {
        ProfesorDTOResponse p = profesorService.obtenerProfesor(profesorDTORequest.getIdProfesorDTO());
        if (p != null) {
            profesorService.actualizarProfesor(profesorDTORequest);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/eliminar/{idProfesor}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer idProfesor) {
        ProfesorDTOResponse p = profesorService.obtenerProfesor(idProfesor);
        if (p != null) {
            profesorService.eliminarProfesor(idProfesor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}
