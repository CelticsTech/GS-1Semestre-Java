package com.globalsolution.java.celticstech.dto.request;

import com.globalsolution.java.celticstech.enums.UfRegiaoEnum;
import com.globalsolution.java.celticstech.models.RegiaoModels;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegiaoRequestDTO(

        @NotBlank(message = "Digite o nome da região")
        @Size(min = 2, max = 50, message = "O nome da região deve ter entre 2 e 50 caracteres")
        String nomeRegiao,

        @NotNull(message = "Digite a UF da região")
        UfRegiaoEnum ufRegiao

) {

    public RegiaoModels toEntity(){

        return RegiaoModels.builder()
                .nomeRegiao(nomeRegiao)
                .ufRegiao(ufRegiao)
                .build();

    }

}