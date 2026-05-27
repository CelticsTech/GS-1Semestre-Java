package com.globalsolution.java.celticstech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_regiao", nullable = false)
    private RegiaoModels regiao;

    @ManyToMany
    @JoinTable(
            name = "TB_GS_ASC_AGR",
            joinColumns = @JoinColumn(name = "id_associacao"),
            inverseJoinColumns = @JoinColumn(name = "id_agricultor")
    )
    private List<AgricultorModels> agricultores;

    @ManyToMany
    @JoinTable(
            name = "TB_GS_CONT_ASC",
            joinColumns = @JoinColumn(name = "id_associacao"),
            inverseJoinColumns = @JoinColumn(name = "id_contato")
    )
    private List<ContatoModels> contatos;

    @JsonIgnore
    @OneToMany(mappedBy = "associacao")
    private List<RecomendacaoModels> recomendacoes;
}
