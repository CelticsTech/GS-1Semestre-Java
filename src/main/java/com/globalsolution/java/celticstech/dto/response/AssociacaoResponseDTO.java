package com.globalsolution.java.celticstech.dto.response;

import com.globalsolution.java.celticstech.models.AssociacaoModels;
import lombok.Builder;

@Builder
public record AssociacaoResponseDTO(

        Long idAssociacao,
        String nomeAssociacao,
        String siglaAssociacao,
        String cnpj,
        String login,
        Long idRegiao,
        String nomeRegiao
) {

    public static AssociacaoResponseDTO fromEntity(AssociacaoModels associacao){
        return AssociacaoResponseDTO.builder()
                .idAssociacao(associacao.getIdAssociacao())
                .nomeAssociacao(associacao.getNomeAssociacao())
                .siglaAssociacao(associacao.getSiglaAssociacao())
                .cnpj(associacao.getCnpj())
                .login(associacao.getLogin())
                .idRegiao(associacao.getRegiao().getIdRegiao())
                .nomeRegiao(associacao.getRegiao().getNomeRegiao())
                .build();
    }

}
