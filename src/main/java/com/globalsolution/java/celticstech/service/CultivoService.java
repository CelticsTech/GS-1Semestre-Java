package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.CultivoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.AgricultorResponseDTO;
import com.globalsolution.java.celticstech.dto.response.CultivoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.CultivoModels;
import com.globalsolution.java.celticstech.repository.CultivoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CultivoService {

    private CultivoRepository cultivoRepository;

    public CultivoService(CultivoRepository cultivoRepository){
        this.cultivoRepository = cultivoRepository;
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(
            value = {
                    "cultivos",
                    "cultivosById"
            },
            allEntries = true
    )
    public CultivoResponseDTO criarCultivo(CultivoRequestDTO cultivoRequest){
        CultivoModels cultivo = cultivoRepository.save(cultivoRequest.toEntity());

        return CultivoResponseDTO.fromEntity(cultivo);
    }

    //-------------------------------------------------------------------------------------------------------------------

    public CultivoModels listarCultivoPorId(Long id){
        return cultivoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo não encontrado"));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Cacheable(value = "cultivosById", key = "#id")
    public CultivoResponseDTO listarPorId(Long id){
        CultivoModels cultivo = listarCultivoPorId(id);
        return CultivoResponseDTO.fromEntity(cultivo);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(
            value = {
                    "cultivos",
                    "cultivosById"
            },
            allEntries = true
    )
    public void deletarCultivo(Long id){
        CultivoModels cultivo = listarCultivoPorId(id);
        cultivoRepository.delete(cultivo);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(
            value = {
                    "cultivos",
                    "cultivosById"
            },
            allEntries = true
    )
    public CultivoResponseDTO atualizarCultivo(Long id, CultivoRequestDTO cultivoRequest){
        CultivoModels cultivo = listarCultivoPorId(id);

        cultivo.setNomeCultivo(cultivoRequest.nomeCultivo());
        cultivo.setCategoriaCultivo(cultivoRequest.categoriaCultivo());
        cultivo.setPorteCultivo(cultivoRequest.porteCultivo());
        cultivo.setTempoColheita(cultivoRequest.tempoColheita());
        cultivo.setVidaUtil(cultivoRequest.vidaUtil());
        cultivo.setIntermitencia(cultivoRequest.intermitencia());

        CultivoModels cultivoModels = cultivoRepository.save(cultivo);

        return CultivoResponseDTO.fromEntity(cultivoModels);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Cacheable(
            value = "cultivos",
            key = "#pageable.pageNumber + '-' + #pageable.pageSize"
    )
   public Page<CultivoResponseDTO> listarTodosCultivos(Pageable pageable){
        return cultivoRepository.findAll(pageable)
                .map(CultivoResponseDTO::fromEntity);
   }
}
