package com.globalsolution.java.celticstech.dto.response;

import com.globalsolution.java.celticstech.models.AssociacaoAgricultorModels;
import lombok.Builder;

@Builder
public record AssociacaoAgricultorResponseDTO (

        Long idAgricultor,
        String nomeAgricultor,

        Long idAssociacao,
        String nomeAssociacao,
        String siglaAssociacao,
        String cnpj

){
    public static AssociacaoAgricultorResponseDTO fromEntity(AssociacaoAgricultorModels entity){
        return AssociacaoAgricultorResponseDTO.builder()
                .idAgricultor(entity.getAgricultor().getIdAgricultor())
                .nomeAgricultor(entity.getAgricultor().getNomeAgricultor())
                .idAssociacao(entity.getAssociacao().getIdAssociacao())
                .nomeAssociacao(entity.getAssociacao().getNomeAssociacao())
                .siglaAssociacao(entity.getAssociacao().getSiglaAssociacao())
                .cnpj(entity.getAssociacao().getCnpj())
                .build();
    }
}
