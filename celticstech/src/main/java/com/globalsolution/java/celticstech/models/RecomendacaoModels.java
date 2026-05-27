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
    private LocalDate dataRecAsc;
    private String orientacao;
    private Integer tipoRecomendacao;

}
