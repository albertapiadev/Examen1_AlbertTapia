package com.idat.tapia.service;

import com.idat.tapia.dto.ProfesorDTORequest;
import com.idat.tapia.dto.ProfesorDTOResponse;
import com.idat.tapia.model.Profesor;
import com.idat.tapia.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    public ProfesorRepository profesorRepository;


    @Override
    public void crearProfesor(ProfesorDTORequest profesorDTORequest) {

        Profesor p = new Profesor();
        p.setProfesor(profesorDTORequest.getProfesorDTO());

        profesorRepository.save(p);

    }

    @Override
    public void actualizarProfesor(ProfesorDTORequest profesorDTORequest) {

        Profesor p = new Profesor();
        p.setProfesor(profesorDTORequest.getProfesorDTO());

        profesorRepository.saveAndFlush(p);

    }

    @Override
    public void eliminarProfesor(Integer idProfesor) {

        profesorRepository.deleteById(idProfesor);

    }

    @Override
    public List<ProfesorDTOResponse> listarProfesores() {

        List<ProfesorDTOResponse> list = new ArrayList<ProfesorDTOResponse>();
        ProfesorDTOResponse p = null;

        for (Profesor profesor : profesorRepository.findAll()) {
            p = new ProfesorDTOResponse();
            p.setIdProfesorDTO(profesor.getIdProfesor());
            p.setProfesorDTO(profesor.getProfesor());

            list.add(p);
        }
        return list;
    }

    @Override
    public ProfesorDTOResponse obtenerProfesor(Integer idProfesor) {

        Profesor profesor = profesorRepository.findById(idProfesor).orElse(null);
        ProfesorDTOResponse p = new ProfesorDTOResponse();
        p.setIdProfesorDTO(profesor.getIdProfesor());
        p.setProfesorDTO(profesor.getProfesor());
        return p;
    }
}
