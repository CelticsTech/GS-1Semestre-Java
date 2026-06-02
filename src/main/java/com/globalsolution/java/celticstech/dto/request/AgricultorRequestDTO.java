package com.globalsolution.java.celticstech.dto.request;

import com.globalsolution.java.celticstech.enums.SexoAgricultorEnum;
import com.globalsolution.java.celticstech.models.AgricultorModels;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AgricultorRequestDTO(

        @NotBlank(message = "Digite o nome do agricultor !")
        @Size(min = 2, max = 50, message = "Minimo de 2 caracteres e máximo 50 caracteres.")
        String nomeAgricultor,

        @NotNull(message = "Digite sua idade.")
        @Min(value = 16, message = "Precisa ter no minimo 16 para atuar formalmente como produtor rural")
        Integer idade,

        @NotNull(message = "Digite o seu sexo novamente, (F - M) !")
        SexoAgricultorEnum sexo,

        @NotNull(message = "Digite quantos dependentes você possui")
        Integer qtdeDependentes
) {

    public AgricultorModels toEntity(){
        return AgricultorModels.builder()
                .nomeAgricultor(nomeAgricultor)
                .idade(idade)
                .sexo(sexo)
                .qtdeDependentes(qtdeDependentes)
                .build();
    }

}
