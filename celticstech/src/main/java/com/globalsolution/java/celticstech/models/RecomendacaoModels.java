package com.globalsolution.java.celticstech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_GS_RECOMENDACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecomendacaoModels {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idRecomendacao;

    @Column(nullable = false)
    private LocalDate dataRecAsc;

    @Column(nullable = false)
    private String orientacao;

    @Column(nullable = false)
    private Integer tipoRecomendacao;

}
