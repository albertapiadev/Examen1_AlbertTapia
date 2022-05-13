package com.idat.tapia.service;

import com.idat.tapia.dto.ProfesorDTORequest;
import com.idat.tapia.dto.ProfesorDTOResponse;

import java.util.List;

public interface ProfesorService {

    public void crearProfesor(ProfesorDTORequest profesorDTORequest);
    public void actualizarProfesor(ProfesorDTORequest profesorDTORequest);
    public void eliminarProfesor(Integer idProfesor);
    public List<ProfesorDTOResponse> listarProfesores();
    public ProfesorDTOResponse obtenerProfesor(Integer idProfesor);

}
