package com.idat.tapia.service;

import com.idat.tapia.dto.CursoDTORequest;
import com.idat.tapia.dto.CursoDTOResponse;

import java.util.List;

public interface CursoService {

    public void crearCurso(CursoDTORequest cursoDTORequest);
    public void actualizarCurso(CursoDTORequest cursoDTORequest);
    public void eliminarCurso(Integer idCurso);
    public List<CursoDTOResponse> listarCursos();
    public CursoDTOResponse obtenerCurso(Integer idCurso);

}
