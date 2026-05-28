package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.response.AgricultorCultivoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import com.globalsolution.java.celticstech.models.AgricultorModels;
import com.globalsolution.java.celticstech.models.CultivoModels;
import com.globalsolution.java.celticstech.models.id.AgricultorCultivoId;
import com.globalsolution.java.celticstech.repository.AgricultorCultivoRepository;
import com.globalsolution.java.celticstech.repository.AgricultorRepository;
import com.globalsolution.java.celticstech.repository.CultivoRepository;
import org.springframework.stereotype.Service;

@Service
public class AgricultorCultivoService {

    private AgricultorCultivoRepository agricultorCultivoRepository;
    private AgricultorRepository agricultorRepository;
    private CultivoRepository cultivoRepository;

    public AgricultorCultivoService(AgricultorCultivoRepository agricultorCultivoRepository,
                                    AgricultorRepository agricultorRepository,
                                    CultivoRepository cultivoRepository)
    {
        this.agricultorCultivoRepository = agricultorCultivoRepository;
        this.agricultorRepository = agricultorRepository;
        this.cultivoRepository = cultivoRepository;
    }

    public AgricultorCultivoResponseDTO vincularCultivo(Long idAgricultor, Long idCultivo){

        AgricultorModels agricultor = agricultorRepository.findById(idAgricultor)
                .orElseThrow(() -> new ResourceNotFoundException("Id no agricultor não existe"));

        CultivoModels cultivo = cultivoRepository.findById(idCultivo)
                .orElseThrow(() -> new ResourceNotFoundException("Id do cultivo não encontrado"));

        AgricultorCultivoId id = new AgricultorCultivoId(idAgricultor, idCultivo);

        AgricultorCultivoModels vinculo = AgricultorCultivoModels.builder()
                .id(id)
                .agricultor(agricultor)
                .cultivo(cultivo)
                .build();

        return AgricultorCultivoResponseDTO.fromEntity(
                agricultorCultivoRepository.save(vinculo));
    };
}
