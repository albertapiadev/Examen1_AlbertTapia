package com.idat.tapia.service;

import com.idat.tapia.dto.CursoDTORequest;
import com.idat.tapia.dto.CursoDTOResponse;
import com.idat.tapia.model.Curso;
import com.idat.tapia.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    public CursoRepository cursoRepository;


    @Override
    public void crearCurso(CursoDTORequest cursoDTORequest) {
        Curso c = new Curso();
        c.setCurso(cursoDTORequest.getCursoDTO());
        c.setDescripcion(cursoDTORequest.getDescripcionDTO());
        c.setIdMalla(cursoDTORequest.getIdMallaDTO());

        cursoRepository.save(c);
    }

    @Override
    public void actualizarCurso(CursoDTORequest cursoDTORequest) {
        Curso c = new Curso();
        c.setCurso(cursoDTORequest.getCursoDTO());
        c.setDescripcion(cursoDTORequest.getDescripcionDTO());
        c.setIdMalla(cursoDTORequest.getIdMallaDTO());

        cursoRepository.saveAndFlush(c);
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
        cursoRepository.deleteById(idCurso);

    }

    @Override
    public List<CursoDTOResponse> listarCursos() {

        List<CursoDTOResponse> list = new ArrayList<CursoDTOResponse>();
        CursoDTOResponse c = null;
        for (Curso curso : cursoRepository.findAll()) {
            c = new CursoDTOResponse();
            c.setIdCursoDTO(curso.getIdCurso());
            c.setCursoDTO(curso.getCurso());
            c.setDescripcionDTO(curso.getDescripcion());
            c.setIdMallaDTO(curso.getIdMalla());

            list.add(c);
        }

        return list;
    }

    @Override
    public CursoDTOResponse obtenerCurso(Integer idCurso) {

        Curso curso = cursoRepository.findById(idCurso).orElse(null);
        CursoDTOResponse c = new CursoDTOResponse();
        c.setIdCursoDTO(curso.getIdCurso());
        c.setCursoDTO(curso.getCurso());
        c.setDescripcionDTO(curso.getDescripcion());
        c.setIdMallaDTO(curso.getIdMalla());

        return c;
    }
}
