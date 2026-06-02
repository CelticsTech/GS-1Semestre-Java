package com.globalsolution.java.celticstech.dto.request;

import com.globalsolution.java.celticstech.models.AssociacaoModels;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public record AssociacaoRequestDTO(
        @NotBlank(message = "Digite o nome da associação")
        @Size(min = 2, max = 100, message = "Mínimo de 2 caracteres e máximo de 100")
        String nomeAssociacao,

        @NotBlank(message = "Digite a sigla da associação")
        @Size(min = 2, max = 20, message = "Mínimo de 2 caracteres e máximo de 20")
        String siglaAssociacao,

        @NotBlank(message = "Digite o CNPJ")
        @CNPJ(message = "CNPJ invalido")
        String cnpj,

        @NotBlank(message = "Digite o login")
        @Size(min = 4, max = 30, message = "O login deve ter entre 4 e 30 caracteres")
        String login,

        @NotBlank(message = "Digite a senha")
        @Size(min = 6, max = 100, message = "A senha deve ter no mínimo 6 caracteres")
        String senha,

        @NotNull(message = "Informe a região")
        Long idRegiao
) {

    public AssociacaoModels toEntity(){
        return AssociacaoModels.builder()
                .nomeAssociacao(nomeAssociacao)
                .siglaAssociacao(siglaAssociacao)
                .cnpj(cnpj)
                .login(login)
                .senha(senha)
                .build();
    }
}
