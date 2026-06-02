package com.globalsolution.java.celticstech.models;

import com.globalsolution.java.celticstech.models.id.AgricultorCultivoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_GS_AGR_CULTIVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgricultorCultivoModels {

    @EmbeddedId
    private AgricultorCultivoId id;

    @ManyToOne
    @MapsId("idAgricultor")
    @JoinColumn(name = "id_agricultor")
    private AgricultorModels agricultor;

    @ManyToOne
    @MapsId("idCultivo")
    @JoinColumn(name = "id_cultivo")
    private CultivoModels cultivo;

}