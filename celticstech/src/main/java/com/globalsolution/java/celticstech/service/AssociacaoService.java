package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.AssociacaoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.AssociacaoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.AssociacaoModels;
import com.globalsolution.java.celticstech.models.RegiaoModels;
import com.globalsolution.java.celticstech.repository.AssociacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AssociacaoService {

    private AssociacaoRepository associacaoRepository;
    private RegiaoService regiaoService;

    public AssociacaoService(AssociacaoRepository associacaoRepository, RegiaoService regiaoService){
        this.associacaoRepository = associacaoRepository;
        this.regiaoService = regiaoService;
    }

    public AssociacaoResponseDTO criarAssociacao(AssociacaoRequestDTO associacaoRequest){
        RegiaoModels regiao = regiaoService.listarRegioesPorId(associacaoRequest.idRegiao());

        AssociacaoModels associacao = associacaoRequest.toEntity();
        associacao.setRegiao(regiao);

        AssociacaoModels salva = associacaoRepository.save(associacao);

        return AssociacaoResponseDTO.fromEntity(salva);
    }

    public Page<AssociacaoResponseDTO> listarTodasAssociacoes(Pageable pageable){
        return associacaoRepository.findAll(pageable)
                .map(AssociacaoResponseDTO::fromEntity);
    }

    public AssociacaoModels listarPorId(Long id){
        return associacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Associacao não encontrada"));
    }

    public AssociacaoResponseDTO listarAssociacaoPeloId(long id){
        AssociacaoModels associacao = listarPorId(id);
        return AssociacaoResponseDTO.fromEntity(associacao);
    }

    public void deletarAssociacao(Long id){
        AssociacaoModels associacao = listarPorId(id);
        associacaoRepository.delete(associacao);
    }

    public AssociacaoResponseDTO atualizarAssociacao(Long id, AssociacaoRequestDTO associacaoRequest){
        AssociacaoModels associacao = listarPorId(id);
        RegiaoModels regiao = regiaoService.listarRegioesPorId(associacaoRequest.idRegiao());

        associacao.setRegiao(regiao);
        associacao.setNomeAssociacao(associacaoRequest.nomeAssociacao());
        associacao.setSiglaAssociacao(associacaoRequest.siglaAssociacao());
        associacao.setCnpj(associacaoRequest.cnpj());
        associacao.setLogin(associacaoRequest.login());
        associacao.setSenha(associacaoRequest.senha());

        AssociacaoModels atualizado = associacaoRepository.save(associacao);

        return AssociacaoResponseDTO.fromEntity(atualizado);
    }

}
