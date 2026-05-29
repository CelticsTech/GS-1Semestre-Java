package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.response.AgricultorCultivoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.BusinessException;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import com.globalsolution.java.celticstech.models.AgricultorModels;
import com.globalsolution.java.celticstech.models.CultivoModels;
import com.globalsolution.java.celticstech.models.id.AgricultorCultivoId;
import com.globalsolution.java.celticstech.repository.AgricultorCultivoRepository;
import com.globalsolution.java.celticstech.repository.AgricultorRepository;
import com.globalsolution.java.celticstech.repository.CultivoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgricultorCultivoService {

    private AgricultorCultivoRepository agricultorCultivoRepository;
    private AgricultorRepository agricultorRepository;
    private CultivoRepository cultivoRepository;
    private AgricultorService agricultorService;
    private CultivoService cultivoService;

    public AgricultorCultivoService(AgricultorCultivoRepository agricultorCultivoRepository,
                                    AgricultorRepository agricultorRepository,
                                    CultivoRepository cultivoRepository,
                                    AgricultorService agricultorService,
                                    CultivoService cultivoService
                                    )
    {
        this.agricultorCultivoRepository = agricultorCultivoRepository;
        this.agricultorRepository = agricultorRepository;
        this.cultivoRepository = cultivoRepository;
        this.agricultorService = agricultorService;
        this.cultivoService = cultivoService;
    }

    //-------------------------------------------------------------------------------------------------------------------

    public Page<AgricultorCultivoResponseDTO> listarCultivosDoAgricultor(
            Long idAgricultor,
            Pageable pageable
    ) {
        agricultorService.listarAgricultorPorId(idAgricultor);

        return agricultorCultivoRepository
                .findByAgricultorIdAgricultor(idAgricultor, pageable)
                .map(AgricultorCultivoResponseDTO::fromEntity);
    }

    //-------------------------------------------------------------------------------------------------------------------

    public AgricultorCultivoResponseDTO vincularCultivo(Long idAgricultor, Long idCultivo){

        AgricultorModels agricultor = agricultorService.listarAgricultorPorId(idAgricultor);
        CultivoModels cultivo = cultivoService.listarCultivoPorId(idCultivo);
        AgricultorCultivoId id = new AgricultorCultivoId(idAgricultor, idCultivo);

        if (agricultorCultivoRepository.existsById(id)) {
            throw new BusinessException(
                    "Este cultivo já está vinculado ao agricultor"
            );
        }

        AgricultorCultivoModels vinculo = AgricultorCultivoModels.builder()
                .id(id)
                .agricultor(agricultor)
                .cultivo(cultivo)
                .build();

        return AgricultorCultivoResponseDTO.fromEntity(
                agricultorCultivoRepository.save(vinculo));
    };

    //-------------------------------------------------------------------------------------------------------------------

    public void deletarVinculo(Long idCultivo, Long idAgricultor){
        AgricultorCultivoId id = new AgricultorCultivoId(idCultivo, idAgricultor);

        if (!agricultorCultivoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vínculo não encontrado");
        }

        agricultorCultivoRepository.deleteById(id);
    }

}
