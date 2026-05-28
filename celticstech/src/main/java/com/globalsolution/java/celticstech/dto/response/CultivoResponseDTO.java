package com.globalsolution.java.celticstech.dto.response;

import com.globalsolution.java.celticstech.enums.PorteCultivoEnum;
import com.globalsolution.java.celticstech.models.CultivoModels;
import lombok.Builder;

@Builder
public record CultivoResponseDTO(

        Long idCultivo,
        String nomeCultivo,
        String categoriaCultivo,
        PorteCultivoEnum porteCultivo,
        String tempoColheita,
        String vidaUtil,
        String intermitencia

) {

    public static CultivoResponseDTO fromEntity(CultivoModels cultivo){

        return CultivoResponseDTO.builder()
                .idCultivo(cultivo.getIdCultivo())
                .nomeCultivo(cultivo.getNomeCultivo())
                .categoriaCultivo(cultivo.getCategoriaCultivo())
                .porteCultivo(cultivo.getPorteCultivo())
                .tempoColheita(cultivo.getTempoColheita())
                .vidaUtil(cultivo.getVidaUtil())
                .intermitencia(cultivo.getIntermitencia())
                .build();

    }

}