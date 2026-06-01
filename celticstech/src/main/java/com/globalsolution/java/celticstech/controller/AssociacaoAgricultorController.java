package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.response.AssociacaoAgricultorResponseDTO;
import com.globalsolution.java.celticstech.service.AssociacaoAgricultorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associacoes/{idAssociacao}/agricultores")
public class AssociacaoAgricultorController {

    private AssociacaoAgricultorService associacaoAgricultorService;

    public AssociacaoAgricultorController(
            AssociacaoAgricultorService associacaoAgricultorService
    ) {
        this.associacaoAgricultorService = associacaoAgricultorService;
    }

    @Operation(summary = "Vincular agricultor a uma associação")
    @PostMapping("/{idAgricultor}")
    public ResponseEntity<AssociacaoAgricultorResponseDTO> vincularAgricultor(
            @PathVariable Long idAssociacao,
            @PathVariable Long idAgricultor
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(associacaoAgricultorService.vincularAgricultor(
                        idAssociacao,
                        idAgricultor
                ));
    }

    @Operation(summary = "Listar agricultores de uma associação")
    @GetMapping
    public ResponseEntity<Page<AssociacaoAgricultorResponseDTO>> listarAgricultoresDaAssociacao(
            @PathVariable Long idAssociacao,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                associacaoAgricultorService.listarAgricultoresDaAssociacao(
                        idAssociacao,
                        pageable
                )
        );
    }

    @Operation(summary = "Remover vínculo entre associação e agricultor")
    @DeleteMapping("/{idAgricultor}")
    public ResponseEntity<Void> deletarVinculo(
            @PathVariable Long idAssociacao,
            @PathVariable Long idAgricultor
    ) {
        associacaoAgricultorService.deletarVinculo(
                idAssociacao,
                idAgricultor
        );

        return ResponseEntity.noContent().build();
    }
}