package com.globalsolution.java.celticstech.dto.response;

import com.globalsolution.java.celticstech.enums.UfRegiaoEnum;
import com.globalsolution.java.celticstech.models.RegiaoModels;
import lombok.Builder;

@Builder
public record RegiaoResponseDTO(

        Long idRegiao,
        String nomeRegiao,
        UfRegiaoEnum ufRegiao

) {

    public static RegiaoResponseDTO fromEntity(RegiaoModels regiao){

        return RegiaoResponseDTO.builder()
                .idRegiao(regiao.getIdRegiao())
                .nomeRegiao(regiao.getNomeRegiao())
                .ufRegiao(regiao.getUfRegiao())
                .build();

    }

}