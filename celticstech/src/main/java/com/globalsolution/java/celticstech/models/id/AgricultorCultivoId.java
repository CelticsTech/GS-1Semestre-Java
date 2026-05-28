package com.globalsolution.java.celticstech.models.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgricultorCultivoId implements Serializable {

    private Long idAgricultor;
    private Long idCultivo;

}