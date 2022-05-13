package com.idat.tapia.controller;

import com.idat.tapia.dto.MallaCurricularDTORequest;
import com.idat.tapia.dto.MallaCurricularDTOResponse;
import com.idat.tapia.service.MallaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/malla")
public class MallaCurricularController {

    @Autowired
    private MallaCurricularService mallaCurricularService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<MallaCurricularDTOResponse>> listarMallaCurricular() {
        return new ResponseEntity<List<MallaCurricularDTOResponse>>(mallaCurricularService.listarMallaCurricular(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Void> crearMallaCurricular(@RequestBody MallaCurricularDTORequest mallaCurricularDTORequest) {
        mallaCurricularService.crearMallaCurricular(mallaCurricularDTORequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "listar/{idMalla}", method = RequestMethod.GET)
    public ResponseEntity<MallaCurricularDTOResponse> obtenerMallaCurricular(@PathVariable Integer idMalla) {
        MallaCurricularDTOResponse m = mallaCurricularService.obtenerMallaCurricular(idMalla);
        if (m != null) {
            return new ResponseEntity<MallaCurricularDTOResponse>(m, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MallaCurricularDTOResponse>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarMallaCurricular(@RequestBody MallaCurricularDTORequest mallaCurricularDTORequest) {
        MallaCurricularDTOResponse m = mallaCurricularService.obtenerMallaCurricular(mallaCurricularDTORequest.getIdMallaDTO());
        if (m != null) {
            mallaCurricularService.actualizarMallaCurricular(mallaCurricularDTORequest);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/eliminar/{idMalla}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminarMallaCurricular(@PathVariable Integer idMalla) {
        MallaCurricularDTOResponse m = mallaCurricularService.obtenerMallaCurricular(idMalla);
        if (m != null) {
            mallaCurricularService.eliminarMallaCurricular(idMalla);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}

