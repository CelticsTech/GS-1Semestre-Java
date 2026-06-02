package com.globalsolution.java.celticstech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalsolution.java.celticstech.enums.SexoAgricultorEnum;
import com.globalsolution.java.celticstech.models.embeddable.AuditoriaModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "TB_GS_AGRICULTOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgricultorModels {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_agricultor")
    private Long idAgricultor;

    @Column(nullable = false)
    private String nomeAgricultor;

    private Integer idade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SexoAgricultorEnum sexo;

    @Column(nullable = false)
    private Integer qtdeDependentes;

    @OneToMany(mappedBy = "agricultor")
    private List<AssociacaoAgricultorModels> associacaoAgricultores;

    @JsonIgnore
    @OneToMany(mappedBy = "agricultor")
    private List<AgricultorCultivoModels> agricultorCultivos;

    @Embedded
    private AuditoriaModels auditoria;

}
