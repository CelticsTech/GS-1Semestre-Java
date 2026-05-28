package com.globalsolution.java.celticstech.dto.request;

import com.globalsolution.java.celticstech.models.ContatoModels;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ContatoRequestDTO(

        @Pattern(
                regexp = "^\\d{11,13}$",
                message = "Digite o telefone no modelo: 11941078460"
        )
        @NotBlank(message = "Digite seu telefone")
        String telefone,

        @NotBlank(message = "Digite seu email")
        @Email
        String email

) {

    public ContatoModels toEntity(){
        return ContatoModels.builder()
                .telefone(telefone)
                .email(email)
                .build();
    }

}
