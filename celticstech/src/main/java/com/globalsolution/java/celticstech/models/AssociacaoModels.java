package com.globalsolution.java.celticstech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_GS_ASSOCIACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociacaoModels {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAssociacao;

    @Column(nullable = false)
    private String nomeAssociacao;

    @Column(nullable = false)
    private String siglaAssociacao;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;
}
