package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.RegiaoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.RegiaoResponseDTO;
import com.globalsolution.java.celticstech.service.RegiaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regiao")
public class RegiaoController {

    private RegiaoService regiaoService;

    public RegiaoController(RegiaoService regiaoService){
        this.regiaoService = regiaoService;
    }

    @Operation(summary = "Criar Região")
    @PostMapping()
    public ResponseEntity<RegiaoResponseDTO> criarRegiao(@Valid @RequestBody RegiaoRequestDTO regiaoRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(regiaoService.criarRegiao(regiaoRequest));
    }

    @Operation(summary = "Listar regiao pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<RegiaoResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(regiaoService.listarPorId(id));
    }

    @Operation(summary = "Listar todas as regiões")
    @GetMapping()
    public ResponseEntity<Page<RegiaoResponseDTO>> listarTodos(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(regiaoService.listarTodos(pageable));
    }

    @Operation(summary = "Deletar Regiao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegiao(@PathVariable Long id){
        regiaoService.deletarRegiao(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @Operation(summary = "Atualizar região")
    @PutMapping("/{id}")
    public ResponseEntity<RegiaoResponseDTO> atualizarRegiao(@PathVariable Long id, @Valid @RequestBody RegiaoRequestDTO regiaoRequestDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(regiaoService.atualizarRegiao(id, regiaoRequestDTO));
    }

}
