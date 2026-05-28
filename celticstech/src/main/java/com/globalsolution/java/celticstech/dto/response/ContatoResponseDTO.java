package com.globalsolution.java.celticstech.dto.response;
import com.globalsolution.java.celticstech.models.ContatoModels;
import lombok.Builder;

@Builder
public record ContatoResponseDTO(

        Long idContato,
        String telefone,
        String email

) {

    public static ContatoResponseDTO fromEntity(ContatoModels contato){
        return ContatoResponseDTO.builder()
                .idContato(contato.getIdContato())
                .telefone(contato.getTelefone())
                .email(contato.getEmail())
                .build();
    }

}
