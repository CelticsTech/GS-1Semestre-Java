package com.globalsolution.java.celticstech.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String ufRegiao;

}
