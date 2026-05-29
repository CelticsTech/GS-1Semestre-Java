package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.AgricultorRequestDTO;
import com.globalsolution.java.celticstech.dto.response.AgricultorResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.AgricultorModels;
import com.globalsolution.java.celticstech.repository.AgricultorRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgricultorService {

    private AgricultorRepository agricultorRepository;

    public AgricultorService(AgricultorRepository agricultorRepository){
        this.agricultorRepository = agricultorRepository;
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(
            value = {
                    "agricultores",
                    "agricultoresById"
            },
            allEntries = true
    )
    public AgricultorResponseDTO criarAgricultor(AgricultorRequestDTO agricultorRequest){
        AgricultorModels agricultor = agricultorRepository.save(agricultorRequest.toEntity());

        return AgricultorResponseDTO.fromEntity(agricultor);
    }

    //-------------------------------------------------------------------------------------------------------------------

    public AgricultorModels listarAgricultorPorId(Long id){
        return agricultorRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Agricultor não encontrado"));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Cacheable(
            value = "agricultores",
            key = "#pageable.pageNumber + '-' + #pageable.pageSize"
    )
    public Page<AgricultorResponseDTO> listarTodosAgricultores(Pageable pageable){
        return agricultorRepository.findAll(pageable)
                .map(AgricultorResponseDTO::fromEntity);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Cacheable(value = "agricultoresById", key = "#id")
    public AgricultorResponseDTO buscarPorId(Long id){
        AgricultorModels agricultor = listarAgricultorPorId(id);

        return AgricultorResponseDTO.fromEntity(agricultor);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(
            value = {
                    "agricultores",
                    "agricultoresById"
            },
            allEntries = true
    )
    public void removerAgricultor(Long id){
        AgricultorModels agricultor = listarAgricultorPorId(id);
        agricultorRepository.delete(agricultor);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(
            value = {
                    "agricultores",
                    "agricultoresById"
            },
            allEntries = true
    )
    public AgricultorResponseDTO atualizarAgricultor(Long id, AgricultorRequestDTO agricultorRequest){
        AgricultorModels agricultor = listarAgricultorPorId(id);

        agricultor.setNomeAgricultor(agricultorRequest.nomeAgricultor());
        agricultor.setIdade(agricultorRequest.idade());
        agricultor.setSexo(agricultorRequest.sexo());
        agricultor.setQtdeDependentes(agricultorRequest.qtdeDependentes());

        AgricultorModels agricultorAtualizado = agricultorRepository.save(agricultor);

        return AgricultorResponseDTO.fromEntity(agricultorAtualizado);
    }
}
