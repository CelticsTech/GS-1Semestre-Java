package com.globalsolution.java.celticstech.dto.request;

import com.globalsolution.java.celticstech.enums.TipoRecomendacaoEnum;
import com.globalsolution.java.celticstech.models.RecomendacaoModels;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record RecomendacaoRequestDTO(

        @NotNull(message = "Informe a data da recomendação")
        LocalDate dataRecAsc,

        @NotBlank(message = "Digite a orientação")
        @Size(min = 5, max = 200, message = "A orientação deve ter entre 5 e 200 caracteres")
        String orientacao,

        @NotNull(message = "Informe o tipo da recomendação")
        TipoRecomendacaoEnum tipoRecomendacao,

        @NotNull(message = "Informe a associação")
        Long idAssociacao,

        @NotNull(message = "Informe o cultivo")
        Long idCultivo

) {

    public RecomendacaoModels toEntity(){

        return RecomendacaoModels.builder()
                .dataRecAsc(dataRecAsc)
                .orientacao(orientacao)
                .tipoRecomendacao(tipoRecomendacao)
                .build();

    }

}