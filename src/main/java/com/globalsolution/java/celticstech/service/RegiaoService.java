package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.RegiaoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.RegiaoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.RegiaoModels;
import com.globalsolution.java.celticstech.repository.RegiaoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RegiaoService {

    private RegiaoRepository regiaoRepository;

    public RegiaoService(RegiaoRepository regiaoRepository){
        this.regiaoRepository = regiaoRepository;
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(value = {"regioes",
                         "regioesById"
    },
            allEntries = true)
    public RegiaoResponseDTO criarRegiao(RegiaoRequestDTO regiaoRequest){
        RegiaoModels regiao = regiaoRepository.save(regiaoRequest.toEntity());
        return RegiaoResponseDTO.fromEntity(regiao);
    }

    //-------------------------------------------------------------------------------------------------------------------

    public RegiaoModels listarRegioesPorId(Long id){
        return regiaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Regiao não encontrada"));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Cacheable(value = "regioesById", key = "#id")
    public RegiaoResponseDTO listarPorId(Long id){
        RegiaoModels regiao = listarRegioesPorId(id);
        return RegiaoResponseDTO.fromEntity(regiao);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Cacheable(
            value = "regioes",
            key = "#pageable.pageNumber + '-' + #pageable.pageSize"
    )
    public Page<RegiaoResponseDTO> listarTodos(Pageable pageable){
        return regiaoRepository.findAll(pageable)
                .map(RegiaoResponseDTO::fromEntity);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(value = {"regioes",
            "regioesById"
    },
            allEntries = true)
    public void deletarRegiao(Long id){
        RegiaoModels regiao = listarRegioesPorId(id);
        regiaoRepository.delete(regiao);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @CacheEvict(value = {"regioes",
            "regioesById"
    },
            allEntries = true)
    public RegiaoResponseDTO atualizarRegiao(Long id, RegiaoRequestDTO regiaoRequest){
        RegiaoModels regiao = listarRegioesPorId(id);

        regiao.setNomeRegiao(regiaoRequest.nomeRegiao());
        regiao.setUfRegiao(regiaoRequest.ufRegiao());

        RegiaoModels regiaoModels = regiaoRepository.save(regiao);

        return RegiaoResponseDTO.fromEntity(regiaoModels);
    }

}
