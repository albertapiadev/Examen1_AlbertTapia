package com.idat.tapia.service;

import com.idat.tapia.dto.MallaCurricularDTORequest;
import com.idat.tapia.dto.MallaCurricularDTOResponse;
import com.idat.tapia.model.MallaCurricular;
import com.idat.tapia.repository.MallaCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

    @Autowired
    public MallaCurricularRepository mallaCurricularRepository;


    @Override
    public void crearMallaCurricular(MallaCurricularDTORequest mallaCurricularDTORequest) {

        MallaCurricular m = new MallaCurricular();
        m.setAnio(mallaCurricularDTORequest.getAnioDTO());

        mallaCurricularRepository.save(m);
    }

    @Override
    public void actualizarMallaCurricular(MallaCurricularDTORequest mallaCurricularDTORequest) {

        MallaCurricular m = new MallaCurricular();
        m.setAnio(mallaCurricularDTORequest.getAnioDTO());

        mallaCurricularRepository.saveAndFlush(m);

    }

    @Override
    public void eliminarMallaCurricular(Integer idMalla) {
        mallaCurricularRepository.deleteById(idMalla);

    }

    @Override
    public List<MallaCurricularDTOResponse> listarMallaCurricular() {

        List<MallaCurricularDTOResponse> list = new ArrayList<MallaCurricularDTOResponse>();
        MallaCurricularDTOResponse m = null;

        for (MallaCurricular mallaCurricular : mallaCurricularRepository.findAll()) {
            m = new MallaCurricularDTOResponse();
            m.setIdMallaDTO(mallaCurricular.getIdMalla());
            m.setAnioDTO(mallaCurricular.getAnio());

            list.add(m);
        }
        return list;
    }

    @Override
    public MallaCurricularDTOResponse obtenerMallaCurricular(Integer idMalla) {

        MallaCurricular malla = mallaCurricularRepository.findById(idMalla).orElse(null);
        MallaCurricularDTOResponse m = new MallaCurricularDTOResponse();
        m.setIdMallaDTO(malla.getIdMalla());
        m.setAnioDTO(malla.getAnio());
        return m;
    }
}
