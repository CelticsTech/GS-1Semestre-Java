package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.AssociacaoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.AssociacaoResponseDTO;
import com.globalsolution.java.celticstech.service.AssociacaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associacoes")
public class AssociacaoController {

    private AssociacaoService associacaoService;

    public AssociacaoController(AssociacaoService associacaoService){
        this.associacaoService = associacaoService;
    }

    @Operation(summary = "Cria uma associação")
    @PostMapping()
    public ResponseEntity<AssociacaoResponseDTO> criarAssociacao(@Valid @RequestBody AssociacaoRequestDTO associacaoRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(associacaoService.criarAssociacao(associacaoRequest));
    }

    @Operation(summary = "Busca associação pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<AssociacaoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(associacaoService.listarAssociacaoPeloId(id));
    }

    @Operation(summary = "Busca todas as associacoes cadastradas")
    @GetMapping()
    public ResponseEntity<Page<AssociacaoResponseDTO>> buscarTodasAssociacoes(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(associacaoService.listarTodasAssociacoes(pageable));
    }

    @Operation(summary = "Deleta uma associação")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssociacao(@PathVariable Long id){
        associacaoService.deletarAssociacao(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @Operation(summary = "Atualiza uma associação")
    @PutMapping("/{id}")
    public ResponseEntity<AssociacaoResponseDTO> atualizarAssociacao(@PathVariable Long id,
                                                                     @Valid @RequestBody AssociacaoRequestDTO associacaoRequest)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(associacaoService.atualizarAssociacao(id,associacaoRequest));
    }

}
