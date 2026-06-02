package com.globalsolution.java.celticstech.dto.response;

import com.globalsolution.java.celticstech.enums.TipoRecomendacaoEnum;
import com.globalsolution.java.celticstech.models.RecomendacaoModels;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record RecomendacaoResponseDTO(

        Long idRecomendacao,
        LocalDate dataRecAsc,
        String orientacao,
        TipoRecomendacaoEnum tipoRecomendacao,
        Long idAssociacao,
        String nomeAssociacao,
        Long idCultivo,
        String nomeCultivo

) {

    public static RecomendacaoResponseDTO fromEntity(RecomendacaoModels recomendacao){

        return RecomendacaoResponseDTO.builder()
                .idRecomendacao(recomendacao.getIdRecomendacao())
                .dataRecAsc(recomendacao.getDataRecAsc())
                .orientacao(recomendacao.getOrientacao())
                .tipoRecomendacao(recomendacao.getTipoRecomendacao())
                .idAssociacao(recomendacao.getAssociacao().getIdAssociacao())
                .nomeAssociacao(recomendacao.getAssociacao().getNomeAssociacao())
                .idCultivo(recomendacao.getCultivo().getIdCultivo())
                .nomeCultivo(recomendacao.getCultivo().getNomeCultivo())
                .build();

    }

}