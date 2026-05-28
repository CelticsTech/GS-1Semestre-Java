package com.globalsolution.java.celticstech.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalsolution.java.celticstech.enums.UfRegiaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_GS_REGIAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegiaoModels {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idRegiao;

    @Column(nullable = false)
    private String nomeRegiao;

    @Column(nullable = false)
    private UfRegiaoEnum ufRegiao;

    @JsonIgnore
    @OneToMany(mappedBy = "regiao")
    private List<AssociacaoModels> associacoes;

}
