package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.response.AssociacaoAgricultorResponseDTO;
import com.globalsolution.java.celticstech.exceptions.BusinessException;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.AgricultorModels;
import com.globalsolution.java.celticstech.models.AssociacaoAgricultorModels;
import com.globalsolution.java.celticstech.models.AssociacaoModels;
import com.globalsolution.java.celticstech.models.id.AssociacaoAgricultorId;
import com.globalsolution.java.celticstech.repository.AssociacaoAgricultorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AssociacaoAgricultorService {

    private AssociacaoAgricultorRepository associacaoAgricultorRepository;
    private AssociacaoService associacaoService;
    private AgricultorService agricultorService;

    public AssociacaoAgricultorService(
            AssociacaoAgricultorRepository associacaoAgricultorRepository,
            AssociacaoService associacaoService,
            AgricultorService agricultorService
    ) {
        this.associacaoAgricultorRepository = associacaoAgricultorRepository;
        this.associacaoService = associacaoService;
        this.agricultorService = agricultorService;
    }

    public Page<AssociacaoAgricultorResponseDTO> listarAgricultoresDaAssociacao(
            Long idAssociacao,
            Pageable pageable
    ) {
        associacaoService.listarPorId(idAssociacao);

        return associacaoAgricultorRepository
                .findByAssociacaoIdAssociacao(idAssociacao, pageable)
                .map(AssociacaoAgricultorResponseDTO::fromEntity);
    }

    public AssociacaoAgricultorResponseDTO vincularAgricultor(
            Long idAssociacao,
            Long idAgricultor
    ) {
        AssociacaoModels associacao = associacaoService.listarPorId(idAssociacao);
        AgricultorModels agricultor = agricultorService.listarAgricultorPorId(idAgricultor);

        AssociacaoAgricultorId id =
                new AssociacaoAgricultorId(idAssociacao, idAgricultor);

        if (associacaoAgricultorRepository.existsById(id)) {
            throw new BusinessException(
                    "Este agricultor já está vinculado à associação"
            );
        }

        AssociacaoAgricultorModels vinculo = AssociacaoAgricultorModels.builder()
                .id(id)
                .associacao(associacao)
                .agricultor(agricultor)
                .build();

        return AssociacaoAgricultorResponseDTO.fromEntity(
                associacaoAgricultorRepository.save(vinculo)
        );
    }

    public void deletarVinculo(Long idAssociacao, Long idAgricultor) {
        AssociacaoAgricultorId id =
                new AssociacaoAgricultorId(idAssociacao, idAgricultor);

        if (!associacaoAgricultorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vínculo não encontrado");
        }

        associacaoAgricultorRepository.deleteById(id);
    }
}