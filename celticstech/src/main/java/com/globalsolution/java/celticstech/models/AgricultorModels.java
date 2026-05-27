package com.globalsolution.java.celticstech.models;

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
    private Long idAgricultor;

    @Column(nullable = false)
    private String nomeAgricultor;

    private Integer idade;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private Integer qtdeDependentes;

    @ManyToMany(mappedBy = "agricultores")
    private List<AssociacaoModels> associacoes;

    @ManyToMany
    @JoinTable(
            name = "TB_GS_AGR_CULTIVO",
            joinColumns = @JoinColumn(name = "id_agricultor"),
            inverseJoinColumns = @JoinColumn(name = "id_cultivo")
    )
    private List<CultivoModels> cultivos;

}
