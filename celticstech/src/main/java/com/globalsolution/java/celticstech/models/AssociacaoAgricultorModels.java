package com.globalsolution.java.celticstech.models;

import com.globalsolution.java.celticstech.models.id.AssociacaoAgricultorId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_GS_ASC_AGR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociacaoAgricultorModels {

    @EmbeddedId
    private AssociacaoAgricultorId id;

    @ManyToOne
    @MapsId("idAssociacao")
    @JoinColumn(name = "id_associacao")
    private AssociacaoModels associacao;

    @ManyToOne
    @MapsId("idAgricultor")
    @JoinColumn(name = "id_agricultor")
    private AgricultorModels agricultor;
}
