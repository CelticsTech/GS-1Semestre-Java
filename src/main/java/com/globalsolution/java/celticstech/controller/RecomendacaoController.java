package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.RecomendacaoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.RecomendacaoResponseDTO;
import com.globalsolution.java.celticstech.service.RecomendacaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recomendacoes")
public class RecomendacaoController {

    private RecomendacaoService recomendacaoService;

    public RecomendacaoController(RecomendacaoService recomendacaoService) {
        this.recomendacaoService = recomendacaoService;
    }

    @Operation(summary = "Criar recomendação")
    @PostMapping
    public ResponseEntity<RecomendacaoResponseDTO> criarRecomendacao(
            @Valid @RequestBody RecomendacaoRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(recomendacaoService.criarRecomendacao(request));
    }

    @Operation(summary = "Listar recomendação por ID")
    @GetMapping("/{id}")
    public ResponseEntity<RecomendacaoResponseDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(recomendacaoService.listarPorId(id));
    }

    @Operation(summary = "Listar todas as recomendações")
    @GetMapping
    public ResponseEntity<Page<RecomendacaoResponseDTO>> listarTodas(Pageable pageable) {
        return ResponseEntity.ok(recomendacaoService.listarTodas(pageable));
    }

    @Operation(summary = "Listar recomendações por associação")
    @GetMapping("/associacao/{idAssociacao}")
    public ResponseEntity<Page<RecomendacaoResponseDTO>> listarPorAssociacao(
            @PathVariable Long idAssociacao,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                recomendacaoService.listarPorAssociacao(idAssociacao, pageable)
        );
    }

    @Operation(summary = "Listar recomendações por cultivo")
    @GetMapping("/cultivo/{idCultivo}")
    public ResponseEntity<Page<RecomendacaoResponseDTO>> listarPorCultivo(
            @PathVariable Long idCultivo,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                recomendacaoService.listarPorCultivo(idCultivo, pageable)
        );
    }

    @Operation(summary = "Listar recomendações por tipo")
    @GetMapping("/tipo/{tipoRecomendacao}")
    public ResponseEntity<Page<RecomendacaoResponseDTO>> listarPorTipo(
            @PathVariable Integer tipoRecomendacao,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                recomendacaoService.listarPorTipo(tipoRecomendacao, pageable)
        );
    }

    @Operation(summary = "Deletar recomendação")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRecomendacao(@PathVariable Long id) {
        recomendacaoService.deletarRecomendacao(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualizar recomendação")
    @PutMapping("/{id}")
    public ResponseEntity<RecomendacaoResponseDTO> atualizarRecomendacao(
            @PathVariable Long id,
            @Valid @RequestBody RecomendacaoRequestDTO request
    ) {
        return ResponseEntity.ok(
                recomendacaoService.atualizarRecomendacao(id, request)
        );
    }
}