package com.idat.tapia.service;

import com.idat.tapia.dto.UniversidadDTORequest;
import com.idat.tapia.dto.UniversidadDTOResponse;
import com.idat.tapia.model.Universidad;
import com.idat.tapia.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversidadServiceImpl implements UniversidadService {

    @Autowired
    public UniversidadRepository universidadRepository;


    @Override
    public void crearUniversidad(UniversidadDTORequest universidadDTORequest) {

        Universidad u = new Universidad();
        u.setUniversidad(universidadDTORequest.getUniversidadDTO());

        universidadRepository.save(u);

    }

    @Override
    public void actualizarUniversidad(UniversidadDTORequest universidadDTORequest) {

        Universidad u = new Universidad();
        u.setUniversidad(universidadDTORequest.getUniversidadDTO());

        universidadRepository.saveAndFlush(u);

    }

    @Override
    public void eliminarUniversidad(Integer idUniversidad) {

        universidadRepository.deleteById(idUniversidad);

    }

    @Override
    public List<UniversidadDTOResponse> listarUniversidades() {

        List<UniversidadDTOResponse> list = new ArrayList<UniversidadDTOResponse>();
        UniversidadDTOResponse u = null;

        for (Universidad universidad : universidadRepository.findAll()) {
            u = new UniversidadDTOResponse();
            u.setIdUniversidadDTO(universidad.getIdUniversidad());
            u.setUniversidadDTO(universidad.getUniversidad());

            list.add(u);
        }
        return list;
    }

    @Override
    public UniversidadDTOResponse obtenerUniversidad(Integer idUniversidad) {

        Universidad universidad = universidadRepository.findById(idUniversidad).orElse(null);
        UniversidadDTOResponse u = new UniversidadDTOResponse();
        u.setIdUniversidadDTO(universidad.getIdUniversidad());
        u.setUniversidadDTO(universidad.getUniversidad());

        return u;
    }
}
