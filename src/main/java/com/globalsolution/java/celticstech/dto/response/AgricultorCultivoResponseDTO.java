package com.globalsolution.java.celticstech.dto.response;

import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import lombok.Builder;

@Builder
public record AgricultorCultivoResponseDTO(

        Long idAgricultor,
        String nomeAgricultor,

        Long idCultivo,
        String nomeCultivo

) {

    public static AgricultorCultivoResponseDTO fromEntity(AgricultorCultivoModels entity) {
        return AgricultorCultivoResponseDTO.builder()
                .idAgricultor(entity.getAgricultor().getIdAgricultor())
                .nomeAgricultor(entity.getAgricultor().getNomeAgricultor())
                .idCultivo(entity.getCultivo().getIdCultivo())
                .nomeCultivo(entity.getCultivo().getNomeCultivo())
                .build();
    }
}