package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.CultivoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.CultivoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.CultivoModels;
import com.globalsolution.java.celticstech.repository.CultivoRepository;
import org.springframework.stereotype.Service;

@Service
public class CultivoService {

    private CultivoRepository cultivoRepository;

    public CultivoService(CultivoRepository cultivoRepository){
        this.cultivoRepository = cultivoRepository;
    }

    public CultivoResponseDTO criarCultivo(CultivoRequestDTO cultivoRequest){
        CultivoModels cultivo = cultivoRepository.save(cultivoRequest.toEntity());

        return CultivoResponseDTO.fromEntity(cultivo);
    }

    public CultivoModels listarCultivoPorId(Long id){
        return cultivoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agricultor não encontrado"));
    }

    public CultivoResponseDTO listarPorId(Long id){
        CultivoModels cultivo = listarCultivoPorId(id);
        return CultivoResponseDTO.fromEntity(cultivo);
    }

}
