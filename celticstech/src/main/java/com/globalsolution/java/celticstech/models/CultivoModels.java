package com.globalsolution.java.celticstech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalsolution.java.celticstech.enums.PorteCultivoEnum;
import com.globalsolution.java.celticstech.models.embeddable.AuditoriaModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_GS_CULTIVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultivoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long idCultivo;

    @Column(nullable = false)
    private String nomeCultivo;

    @Column(nullable = false)
    private String categoriaCultivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PorteCultivoEnum porteCultivo;

    @Column(nullable = false)
    private String tempoColheita;

    @Column(nullable = false)
    private String vidaUtil;

    @Column(nullable = false)
    private String intermitencia;

    @JsonIgnore
    @ManyToMany(mappedBy = "cultivos")
    private List<AgricultorModels> agricultores;

    @JsonIgnore
    @OneToMany(mappedBy = "cultivo")
    private List<RecomendacaoModels> recomendacoes;

    @Embedded
    private AuditoriaModels auditoria;
}
