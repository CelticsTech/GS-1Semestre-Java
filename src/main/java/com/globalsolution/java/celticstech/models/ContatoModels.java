package com.globalsolution.java.celticstech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_GS_CONTATO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoModels {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long idContato;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "contatos")
    private List<AssociacaoModels> associacoes;
}
