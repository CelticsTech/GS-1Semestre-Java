package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.RecomendacaoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.RecomendacaoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.AssociacaoModels;
import com.globalsolution.java.celticstech.models.CultivoModels;
import com.globalsolution.java.celticstech.models.RecomendacaoModels;
import com.globalsolution.java.celticstech.repository.RecomendacaoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecomendacaoService {

    private RecomendacaoRepository recomendacaoRepository;
    private AssociacaoService associacaoService;
    private CultivoService cultivoService;

    public RecomendacaoService(
            RecomendacaoRepository recomendacaoRepository,
            AssociacaoService associacaoService,
            CultivoService cultivoService
    ) {
        this.recomendacaoRepository = recomendacaoRepository;
        this.associacaoService = associacaoService;
        this.cultivoService = cultivoService;
    }

    @CacheEvict(value = {
            "recomendacoes",
            "recomendacoesById",
            "recomendacoesByAssociacao",
            "recomendacoesByCultivo",
            "recomendacoesByTipo"
    }, allEntries = true)
    public RecomendacaoResponseDTO criarRecomendacao(RecomendacaoRequestDTO request) {
        AssociacaoModels associacao = associacaoService.listarPorId(request.idAssociacao());
        CultivoModels cultivo = cultivoService.listarCultivoPorId(request.idCultivo());

        RecomendacaoModels recomendacao = request.toEntity();
        recomendacao.setAssociacao(associacao);
        recomendacao.setCultivo(cultivo);

        RecomendacaoModels salva = recomendacaoRepository.save(recomendacao);

        return RecomendacaoResponseDTO.fromEntity(salva);
    }

    public RecomendacaoModels listarRecomendacaoPorId(Long id) {
        return recomendacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recomendação não encontrada"));
    }

    @Cacheable(value = "recomendacoesById", key = "#id")
    public RecomendacaoResponseDTO listarPorId(Long id) {
        return RecomendacaoResponseDTO.fromEntity(listarRecomendacaoPorId(id));
    }

    @Cacheable(value = "recomendacoes", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<RecomendacaoResponseDTO> listarTodas(Pageable pageable) {
        return recomendacaoRepository.findAll(pageable)
                .map(RecomendacaoResponseDTO::fromEntity);
    }

    @Cacheable(value = "recomendacoesByAssociacao",
            key = "#idAssociacao + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<RecomendacaoResponseDTO> listarPorAssociacao(Long idAssociacao, Pageable pageable) {
        associacaoService.listarPorId(idAssociacao);

        return recomendacaoRepository.findByAssociacaoIdAssociacao(idAssociacao, pageable)
                .map(RecomendacaoResponseDTO::fromEntity);
    }

    @Cacheable(value = "recomendacoesByCultivo", key = "#idCultivo + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<RecomendacaoResponseDTO> listarPorCultivo(Long idCultivo, Pageable pageable) {
        cultivoService.listarCultivoPorId(idCultivo);

        return recomendacaoRepository.findByCultivoIdCultivo(idCultivo, pageable)
                .map(RecomendacaoResponseDTO::fromEntity);
    }

    @Cacheable(value = "recomendacoesByTipo", key = "#tipoRecomendacao + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<RecomendacaoResponseDTO> listarPorTipo(Integer tipoRecomendacao, Pageable pageable) {
        return recomendacaoRepository.findByTipoRecomendacao(tipoRecomendacao, pageable)
                .map(RecomendacaoResponseDTO::fromEntity);
    }

    @CacheEvict(value = {
            "recomendacoes",
            "recomendacoesById",
            "recomendacoesByAssociacao",
            "recomendacoesByCultivo",
            "recomendacoesByTipo"
    }, allEntries = true)
    public void deletarRecomendacao(Long id) {
        RecomendacaoModels recomendacao = listarRecomendacaoPorId(id);
        recomendacaoRepository.delete(recomendacao);
    }

    @CacheEvict(value = {
            "recomendacoes",
            "recomendacoesById",
            "recomendacoesByAssociacao",
            "recomendacoesByCultivo",
            "recomendacoesByTipo"
    }, allEntries = true)
    public RecomendacaoResponseDTO atualizarRecomendacao(Long id, RecomendacaoRequestDTO request) {
        RecomendacaoModels recomendacao = listarRecomendacaoPorId(id);

        AssociacaoModels associacao = associacaoService.listarPorId(request.idAssociacao());
        CultivoModels cultivo = cultivoService.listarCultivoPorId(request.idCultivo());

        recomendacao.setDataRecAsc(request.dataRecAsc());
        recomendacao.setOrientacao(request.orientacao());
        recomendacao.setTipoRecomendacao(request.tipoRecomendacao());
        recomendacao.setAssociacao(associacao);
        recomendacao.setCultivo(cultivo);

        return RecomendacaoResponseDTO.fromEntity(
                recomendacaoRepository.save(recomendacao)
        );
    }
}