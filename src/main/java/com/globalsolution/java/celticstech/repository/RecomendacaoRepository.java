package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.RecomendacaoModels;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendacaoRepository extends JpaRepository<RecomendacaoModels, Long> {

    Page<RecomendacaoModels> findByAssociacaoIdAssociacao(Long idAssociacao, Pageable pageable);

    Page<RecomendacaoModels> findByCultivoIdCultivo(Long idCultivo, Pageable pageable);

    Page<RecomendacaoModels> findByTipoRecomendacao(Integer tipoRecomendacao, Pageable pageable);
}