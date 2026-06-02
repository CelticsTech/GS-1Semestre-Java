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
public class AssociacaoAgricultorId implements Serializable {
    private Long idAssociacao;
    private Long idAgricultor;
}
