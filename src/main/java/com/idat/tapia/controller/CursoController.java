package com.idat.tapia.controller;

import com.idat.tapia.dto.CursoDTORequest;
import com.idat.tapia.dto.CursoDTOResponse;
import com.idat.tapia.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<CursoDTOResponse>> listarCursos() {
        return new ResponseEntity<List<CursoDTOResponse>>(cursoService.listarCursos(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Void> crearCurso(@RequestBody CursoDTORequest cursoDTORequest) {
        cursoService.crearCurso(cursoDTORequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "listar/{idCurso}", method = RequestMethod.GET)
    public ResponseEntity<CursoDTOResponse> obtenerCurso(@PathVariable Integer idCurso) {
        CursoDTOResponse c = cursoService.obtenerCurso(idCurso);
        if (c != null) {
            return new ResponseEntity<CursoDTOResponse>(c, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CursoDTOResponse>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarCurso(@RequestBody CursoDTORequest cursoDTORequest) {
        CursoDTOResponse c = cursoService.obtenerCurso(cursoDTORequest.getIdCursoDTO());
        if (c != null) {
            cursoService.actualizarCurso(cursoDTORequest);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/eliminar/{idCurso}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarCurso(@PathVariable Integer idCurso) {
        CursoDTOResponse c = cursoService.obtenerCurso(idCurso);
        if (c != null) {
            cursoService.eliminarCurso(idCurso);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}
