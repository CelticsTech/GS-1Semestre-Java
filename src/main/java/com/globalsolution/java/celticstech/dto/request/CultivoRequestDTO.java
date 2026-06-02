package com.globalsolution.java.celticstech.dto.request;

import com.globalsolution.java.celticstech.enums.PorteCultivoEnum;
import com.globalsolution.java.celticstech.models.CultivoModels;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CultivoRequestDTO(

        @NotBlank(message = "Digite o nome do cultivo")
        @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
        String nomeCultivo,

        @NotBlank(message = "Digite a categoria do cultivo")
        @Size(min = 2, max = 50, message = "A categoria deve ter entre 2 e 50 caracteres")
        String categoriaCultivo,

        @NotNull(message = "Informe o porte do cultivo")
        PorteCultivoEnum porteCultivo,

        @NotBlank(message = "Digite o tempo de colheita")
        @Size(max = 80, message = "O tempo de colheita deve ter no máximo 80 caracteres")
        String tempoColheita,

        @NotBlank(message = "Digite a vida útil do cultivo")
        @Size(max = 80, message = "A vida útil deve ter no máximo 80 caracteres")
        String vidaUtil,

        @NotBlank(message = "Digite a intermitência do cultivo")
        @Size(max = 80, message = "A intermitência deve ter no máximo 80 caracteres")
        String intermitencia

) {

    public CultivoModels toEntity() {
        return CultivoModels.builder()
                .nomeCultivo(nomeCultivo)
                .categoriaCultivo(categoriaCultivo)
                .porteCultivo(porteCultivo)
                .tempoColheita(tempoColheita)
                .vidaUtil(vidaUtil)
                .intermitencia(intermitencia)
                .build();
    }
}