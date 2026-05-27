package com.globalsolution.java.celticstech.dto.response;
import com.globalsolution.java.celticstech.enums.SexoAgricultorEnum;
import com.globalsolution.java.celticstech.models.AgricultorModels;
import lombok.Builder;

@Builder
public record AgricultorResponseDTO(

    Long idAgricultor,
    String nomeAgricultor,
    Integer idade,
    SexoAgricultorEnum sexo,
    Integer qtdeDependentes

) {

    public static AgricultorResponseDTO fromEntity(AgricultorModels agricultor){
        return AgricultorResponseDTO.builder()
                .idAgricultor(agricultor.getIdAgricultor())
                .nomeAgricultor(agricultor.getNomeAgricultor())
                .idade(agricultor.getIdade())
                .sexo(agricultor.getSexo())
                .qtdeDependentes(agricultor.getQtdeDependentes())
                .build();
    }

}
