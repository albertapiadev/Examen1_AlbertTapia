package com.idat.tapia.service;

import com.idat.tapia.dto.UniversidadDTORequest;
import com.idat.tapia.dto.UniversidadDTOResponse;

import java.util.List;

public interface UniversidadService {

    public void crearUniversidad(UniversidadDTORequest universidadDTORequest);
    public void actualizarUniversidad(UniversidadDTORequest universidadDTORequest);
    public void eliminarUniversidad(Integer idUniversidad);
    public List<UniversidadDTOResponse> listarUniversidades();
    public UniversidadDTOResponse obtenerUniversidad(Integer idUniversidad);
}
