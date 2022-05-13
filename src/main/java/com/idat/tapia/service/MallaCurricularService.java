package com.idat.tapia.service;

import com.idat.tapia.dto.MallaCurricularDTORequest;
import com.idat.tapia.dto.MallaCurricularDTOResponse;

import java.util.List;

public interface MallaCurricularService {

    public void crearMallaCurricular(MallaCurricularDTORequest mallaCurricularDTORequest);
    public void actualizarMallaCurricular(MallaCurricularDTORequest mallaCurricularDTORequest);
    public void eliminarMallaCurricular(Integer idMalla);
    public List<MallaCurricularDTOResponse> listarMallaCurricular();
    public MallaCurricularDTOResponse obtenerMallaCurricular(Integer idMalla);

}
